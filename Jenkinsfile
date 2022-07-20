pipeline {
    agent {label 'slave1'}

    environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-credentials')
	}

	stages {

		stage('Build') {

			steps {
				sh 'docker build -f src/main/docker/Dockerfile.jvm -t internship-app-back:1.0 .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push bharathirajatut/nodeapp:latest'
			}
		}
	}
    
    post {
		always {
			sh 'docker logout'
		}
	}

}
