pipeline {
    agent any
    environment {
        SONAR_TOKEN = credentials('sqa_c656ba75db2266a9137889ea632838c547936f31') // Apetraho ao Jenkins Credentials ny token-nao
    }
    stages {
        stage('clone and clean repo') {
            steps {
                bat 'IF EXIST DemoIC rmdir /S /Q DemoIC'
                bat 'git clone https://gitlab.com/adrienfranto/demoic'
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
                   -Dsonar.login=%SONAR_TOKEN%
                """
            }
        }
    }
}
