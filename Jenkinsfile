node ('slave1') {
    def app
    
    stage('Clone repository') {
        checkout scm
    }
    
    stage('Build image') {
        app = docker.build("chxws/internshipback")
    }

    stage('Push image') {
        docker.withRegistry('https://registry.hub.docker.com', 'docker-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }
}
