pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                sh 'gradle clean'
            }
        }
        stage('Build') {
            steps {
                sh 'gradle build'
            }
        }
        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker compose up'
            }
        }
    }
}