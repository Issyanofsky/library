def call( String cresentials){
  String dockerImage = env.DOCKER_IMAGE
  script {
    withCredentials([usernamePassword(credentialsId: 'cresentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
      sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
                        
      sh "docker tag devopstasksupdated_app ${dockerImage}"
      sh "docker push ${dockerImage}"
     
    }
  }
}
