pipeline {
    agent any
    environment {
        SONAR_AUTH = credentials('sonar-credentials')
    }
    stages {
        stage('Clone and Clean Repo') {
            steps {
                bat 'IF EXIST DemoIC rmdir /S /Q DemoIC'
                bat 'git clone https://github.com/adrienfranto/demoic'
                bat 'mvn clean -f DemoIC/pom.xml'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test -f DemoIC/pom.xml'
            }
        }
        stage('Deploy & SonarQube Analysis') {
            steps {
                bat 'mvn package -f DemoIC/pom.xml'
                bat 'mvn deploy -f DemoIC/pom.xml'
                bat """
                    mvn sonar:sonar -f DemoIC/pom.xml ^
                    -Dsonar.projectKey=demoic ^
                    -Dsonar.host.url=http://localhost:9000 ^
                    -Dsonar.login=admin ^
                    -Dsonar.password=%SONAR_AUTH%
                """
            }
        }
    }
}
