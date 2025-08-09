pipeline {
    agent any
    stages {
        stage('clone and clean repo') {
            steps {
                bat 'git clone https://github.com/adrienfranto/demoic'
                bat 'mvn clean -f demoic/pom.xml'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test -f demoic/pom.xml'
            }
        }
        stage('Deploy') {
            steps {
                bat 'mvn package -f demoic/pom.xml'
                bat 'mvn deploy -f demoic/pom.xml'
                bat 'mvn sonar:sonar -f demoic/pom.xml'
            }
        }
    }
}
