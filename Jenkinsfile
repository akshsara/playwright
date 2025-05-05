pipeline {
    agent any

    tools {
        maven 'Maven 3'  // Replace with your configured tool name
        jdk 'JDK 17'     // Or your actual JDK name in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/akshsara/playwright', branch: 'main'
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}
