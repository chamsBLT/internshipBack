node ('slave1') {
    def app
    
    stage('Clone repository') {
        checkout scm
    }
    
    stage('Build image') {
        app = docker.build("chxws/internshipback")
    }

    stage('Push image') {
        docker.withRegistry('', 'docker-credentials') {
            app.push("latest")
        }
    }
    
      
    stage('Delpoying the App on Azure Kubernetes Service') {            
        app = docker.image('chxws/internshipback:latest')            
        withDockerRegistry('', 'docker-credentials') {            
            app.pull()            
            
            sh "kubectl apply -f mysql-secrets.yaml"
            sh "kubectl apply -f mysql-configMap.yaml"
            sh "kubectl apply -f db.yml"
            sh "kubectl apply -f internship_back.yml"
            
            
        }       
    }  
}
