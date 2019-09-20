pipeline {
    agent {
        docker {
            image 'maven:3-alpine' 
            args '-v /root/.m2:/root/.m2' 
        }
    }
    stages {
        stage('Build') { 
            steps {
                sh 'mvn -B -DskipTests clean package' 
            }
        }
	stage("Send Build Result") {
		steps{
			withKafkaLog(kafkaServers: '127.0.0.1:9092', kafkaTopic: 'test', metadata:'Other info to send..') {
			echo 'Hello World'
			echo 'Oh Hello'
			echo 'Finally'
			}
		}
		
	}
    }
	node {
    	withKafkaLog(kafkaServers: 'localhost:9092', kafkaTopic: 'test', metadata:'Other info to send..') {
        	echo 'Hello World'
	        echo 'Oh Hello'
        	echo 'Finally'
    }
}
}
