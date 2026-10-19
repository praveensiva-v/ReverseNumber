
pipeline {
    agent any

    environment {
        IMAGE_NAME = 'praveensivav2023/reverse-number'
        KUBECONFIG = '/var/jenkins_home/jenkins-kubeconfig.yaml'
    }

    stages {
        stage('Checkout GitHub') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/praveensiva-v/ReverseNumber.git'
            }
        }

        stage('Maven Build and JUnit Test') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Correct and Incorrect Input Demo') {
            steps {
                sh 'java -cp target/classes com.reverse.App'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $IMAGE_NAME:$BUILD_NUMBER -t $IMAGE_NAME:latest .'
            }
        }

        stage('Docker Hub Push') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-credentials',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_TOKEN'
                )]) {
                    sh '''
                        echo "$DOCKER_TOKEN" | docker login \
                            -u "$DOCKER_USER" --password-stdin
                        docker push "$IMAGE_NAME:$BUILD_NUMBER"
                        docker push "$IMAGE_NAME:latest"
                    '''
                }
            }
        }

        stage('Kubernetes Deployment') {
            steps {
                sh '''
                    kubectl delete job reverse-number --ignore-not-found=true
                    kubectl create job reverse-number \
                        --image="$IMAGE_NAME:$BUILD_NUMBER"
                    kubectl wait --for=condition=complete \
                        job/reverse-number --timeout=180s
                    kubectl logs job/reverse-number
                '''
            }
        }
    }

    post {
        success {
            echo 'CI/CD Pipeline SUCCESS'
        }
        failure {
            echo 'CI/CD Pipeline FAILED'
        }
    }
}

