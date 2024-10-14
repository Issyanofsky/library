def call(String credentials) { 
// takes credentials and the image name from the pipline variable (DOCKER_IMAGE)
    echo "Starting Docker push process..."
    String dockerImage = env.DOCKER_IMAGE 
    echo "Using Docker image: ${dockerImage}"
    script {
        echo "Using Docker image: ${dockerImage}"
        withCredentials([usernamePassword(credentialsId: credentials, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) { 
            sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
            echo "Logging in to Docker Hub as: $DOCKER_USERNAME"
            sh "docker tag devopstasksupdated_app ${dockerImage}"
            sh "docker push ${dockerImage}"
            
            echo "The image has been pushed to DockerHub successfully!!"
        }
    }
}
