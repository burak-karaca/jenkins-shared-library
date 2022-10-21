#!/usr/bin/env groovy
package com

class Docker implements Serializable  {
    def script

    Docker(script){
        this.script
    }

    def buildDockerImage(String imageName){
        script.echo "building the docker image"
        script.withCredentials([script.usernamePassword(credentialsId: 'docker-burak', passwordVariable: 'PASS', usernameVariable: "USER")]){
            script.sh "docker build -t $imageName ."
            script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}
