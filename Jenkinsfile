
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
                bat "sbt clean"
            }
        }
        stage('compile') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: compile'
                bat "sbt compile"
            }
        }
        stage('test') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: test'
                bat "sbt test"
            }
        }
        stage('run') {
            steps {
                // One or more steps need to be included within the steps block.
                echo 'This is stage: run'
                bat "start 'scripts\run.bat'"
            }
        }
    }
}