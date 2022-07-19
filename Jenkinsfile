pipeline {
    agent any
    
    environment {
        dockerhub=credentials('docker-credentials')
    }

    stages {
        stage("Buid image") {
        	when {
            	branch "main"
        		}
        		
            steps {
                sh 'docker build -f src/main/docker/Dockerfile.jvm -t internship-app-back:1.0 .'
            }
        }
        
        stage("Pushing image") {
            steps {
                 sh 'docker tag internship-app-back:1.0 chxws/internship-app-back:1.0'
                 
                 sh 'push chxws/internship-app-back:1.0'      
            }
        }

        stage("Deploying") {
            steps {
                echo 'Deploying the app' 
            }
        }
    }
}
