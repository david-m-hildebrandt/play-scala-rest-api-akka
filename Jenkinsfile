
pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                echo 'This is stage: checkout'
                checkout scm
            }
        }
        stage('clean') {
            steps {
                echo 'This is stage: clean'
                sh "sbt clean"
            }
        }
        stage('build') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: build'
                sh "sbt build"
            }
        }
        stage('test') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: test'
                sh "sbt build"
            }
        }
        stage('deploy') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: deploy'
            }
        }
    }
}