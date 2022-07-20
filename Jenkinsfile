pipeline {
    agent {label 'slave1'}

    environment {
		DOCKERHUB_CREDENTIALS=credentials('docker-credentials')
	}

	stages {

		stage('Build') {

			steps {
				sh 'docker build -f src/main/docker/Dockerfile.jvm -t chxws/internship-app-back:latest .'
			}
		}

		stage('Login') {

			steps {
				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
			}
		}

		stage('Push') {

			steps {
				sh 'docker push chxws/internship-app-back:latest'
			}
		}
	}
    
	post {
		always {
			sh 'docker logout'
		}
	}

}
