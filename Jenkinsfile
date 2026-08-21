pipeline {

    agent any

    environment {
        BROWSER = 'chrome'
        TEST_ENV = 'qa'
    }

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

        stage('Selenium Regression') {
            steps {
                sh '''
                    mvn -B test \
                    -Dbrowser=${BROWSER} \
                    -Denv=${TEST_ENV}
                '''
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
            echo 'Selenium regression PASSED'
        }

        failure {
            echo 'Selenium regression FAILED'
        }
    }
}