def call( String credentials){ // takes credentials and the image name from the pipline variable (DOCKER_IMAGE)
  String dockerImage = env.DOCKER_IMAGE
  script {
    withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
      sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                        
      sh "docker tag devopstasksupdated_app ${dockerImage}"
      sh "docker push ${dockerImage}"
     
    }
  }
}
