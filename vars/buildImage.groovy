#!/user/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'GitHub-Creds', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t sumanrizvi/ec2-jenkins-pipeline:1.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push sumanrizvi/ec2-jenkins-pipeline:1.0'
    }
}