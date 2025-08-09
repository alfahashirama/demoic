pipeline {
    agent any
    stages {
        stage('clone and clean repo') {
            steps {
                bat 'IF EXIST demoic rmdir /S /Q demoic'
                bat 'git clone https://github.com/adrienfranto/demoic'
                bat 'mvn clean -f demoic/pom.xml'
            }
        }
        // stages hafa ...
    }
}
