pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'mvn -B clean compile -DskipTests'
            }
        }

        stage('Selenium Tests') {
            steps {
                sh 'mvn -B test'
            }
        }
    }

    post {

        always {
            junit(
                testResults: 'target/surefire-reports/*.xml',
                allowEmptyResults: true
            )
        }

        success {
            echo 'Selenium tests PASSED'
        }

        failure {
            echo 'Selenium tests FAILED'
        }
    }
}