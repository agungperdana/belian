pipeline {
    agent any

    stages {
        stage('Clean & Build') {
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker compose up'
            }
        }
    }
}