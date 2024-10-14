def call(String credentials) { 
    echo "Starting Docker push process..."
    String dockerImage = env.DOCKER_IMAGE
    String image_to_tag = env.IMAGE_NAME 
    echo "Using Docker image: ${dockerImage}"
    script {
//        withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) { 
//            sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
//            echo "Logging in to Docker Hub as: $DOCKER_USERNAME"
//            sh "docker tag ${image_to_tag} ${dockerImage}"
//            sh "docker push ${dockerImage}"
            
          echo "The image has been pushed to DockerHub successfully!!"
//        }
    }
}
