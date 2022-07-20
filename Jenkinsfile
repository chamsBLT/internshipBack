pipeline {
    agent {label 'slave1'}
    
    environment {
        imagename = "chxws/internship-app-back"
        dockerhub=credentials('docker-credentials')
    }

    stages {
        
        stage("Build project") {
            
            steps {
                sh './mvnw package'
            }
        }
        
        stage('Building image') {
     
            steps{
        
                script {
          
                    dockerImage = docker.build imagename
        }
      }
    }
    
        stage('Deploy Image') {
      
            steps{
        
                script {
          
                    docker.withRegistry( '', dockerhub ) {
            
                        dockerImage.push("$BUILD_NUMBER")
             
                        dockerImage.push('latest')

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
