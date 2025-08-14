pipeline {
    agent any
    stages {
        stage('Clone and Clean Repo') {
            steps {
                bat '''
                    IF EXIST DemoIC rmdir /S /Q DemoIC
                    git clone https://gitlab.com/adrienfranto/demoic
                '''
                bat 'mvn clean -f DemoIC\\pom.xml'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test -f DemoIC\\pom.xml'
            }
        }
        stage('Build & SonarQube Analysis') {
            steps {
                bat 'mvn package -f DemoIC\\pom.xml'
                bat 'mvn deploy -f DemoIC\\pom.xml'
               withCredentials([string(credentialsId: 'demoic_token', variable: 'SONAR_TOKEN')]) {
				    bat """
				        mvn sonar:sonar -f DemoIC\\pom.xml ^
				        -Dsonar.projectKey=demoic ^
				        -Dsonar.host.url=http://localhost:9000 ^
				        -Dsonar.login=%SONAR_TOKEN%
				    """
				}

            }
        }
    }
}
