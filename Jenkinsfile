
pipeline {
    agent any
    stages {
        stage('checkout') {
            steps {
                echo 'This is stage: checkout'
                checkout scm
            }
        }
        stage('build') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: build'
            }
        }
        stage('test') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: test'
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