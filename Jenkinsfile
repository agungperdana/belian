pipeline {
    agent none

    stages {
        stage('Clean & Build') {
            agent any
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            agent any
            steps {
                sh './gradlew test'
            }
        }
        stage('Deploy') {
            agent{
                docker { image 'node:16.13.1-alpine' }
            }
            steps {
                sh 'node --version'
            }
        }
    }
}
