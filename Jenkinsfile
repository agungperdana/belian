pipeline {
    agent none

    stages {
        stage('Clean & Build') {
            agen any
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            agen any
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') {
            docker { image 'node:16.13.1-alpine' }
            steps {
                sh 'node --version'
            }
        }
    }
}
