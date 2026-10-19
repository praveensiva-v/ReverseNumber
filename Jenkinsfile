pipeline {
    agent any

    stages {
        stage('Checkout GitHub') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/praveensiva-v/ReverseNumber.git'
            }
        }

        stage('Maven Build and JUnit Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Correct and Incorrect Input Demo') {
            steps {
                sh 'java -cp target/classes com.reverse.App'
            }
        }
    }

    post {
        success {
            echo 'Maven Build and JUnit Tests Successful'
        }

        failure {
            echo 'Maven Build or JUnit Tests Failed'
        }
    }
}
