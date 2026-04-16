pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-username/order-tracking.git'
            }
        }
        stage('Compile & Test') {
            steps {
                sh 'javac -d out src/main/java/com/example/order/*.java src/test/java/com/example/order/*.java'
                sh 'java -cp out com.example.order.OrderServiceTestRunner'
            }
        }
        stage('Docker Build') {
            steps {
                sh 'docker build -t your-dockerhub-username/order-service:1.0 .'
            }
        }
        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push your-dockerhub-username/order-service:1.0'
                }
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/deployment.yaml'
                sh 'kubectl apply -f k8s/service.yaml'
            }
        }
    }
}
