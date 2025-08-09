pipeline {
    agent any
    stages {
        stage('Clone and Clean Repo') {
            steps {
                bat 'IF EXIST demoic rmdir /S /Q demoic'
                bat 'git clone https://github.com/adrienfranto/demoic'
                bat 'mvn clean -f demoic/pom.xml'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test -f demoic/pom.xml'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn package -f demoic/pom.xml'
            }
        }
        stage('Deploy') {
            steps {
                bat 'mvn deploy -f demoic/pom.xml'
            }
        }
    }
}
