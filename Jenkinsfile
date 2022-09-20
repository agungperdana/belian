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
            agen docker {
                image adoptopenjdk:openjdk11:alpine-jre
            }
            steps {
                sh '''
                docker version
                '''
            }
        }
    }
}
