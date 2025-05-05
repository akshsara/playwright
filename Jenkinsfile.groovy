pipeline {
    agent any

    tools {
        maven 'Maven 3.8.6'
        jdk 'Java 17'
    }

    environment {
        HOME = "${env.WORKSPACE}"
    }

    stages {
        stage('Checkout') {
            steps {
                git ' https://github.com/akshsara/Master.git'
            }
        }

        stage('Install Browsers') {
            steps {
                sh 'mvn exec:java -e -Dexec.mainClass="com.microsoft.playwright.CLI" -Dexec.args="install"'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            junit '**/surefire-reports/*.xml'
        }
    }
}
