pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                git 'https://github.com/username/repo.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }  

      stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
      
      stage('Package') {
            steps {
                sh './gradlew bootJar'
            }
        }
        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
}
