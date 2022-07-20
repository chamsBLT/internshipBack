pipeline {
    agent {label 'slave1'}
    
    environment {
        dockerhub=credentials('docker-credentials')
    }

    stages {
        
        stage("Build project") {
            
            steps {
                sh './mvnw package'
            }
        }
        
        stage("Buid image") {

            steps {
                sh 'docker build -f src/main/docker/Dockerfile.jvm -t chxws/internship-app-back:1.0 .'
            }
        }
        
        stage("Pushing image") {
            steps {
                 script {
                     docker.withRegistry( '', dockerhub ) {
                         dockerImage.push
                     }
                 }      
            }
        }

        stage("Deploying") {
            steps {
                echo 'Deploying the app' 
            }
        }
    }
}
