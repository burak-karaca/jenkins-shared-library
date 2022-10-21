#!/usr/bin/env groovy


def call(String imageName) {
    return new Docker(this).buildDockerImage(imageName)

    // echo "building the docker image"
    // withCredentials([usernamePassword(credentialsId: 'docker-burak', passwordVariable: 'PASS', usernameVariable: "USER")]){
    //     sh "docker build -t $imageName ."
    //     sh "echo $PASS | docker login -u $USER --password-stdin"
    //     sh "docker push $imageName"
    // }
}
