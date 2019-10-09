import hudson.Util;

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
                sh 'mvnn -B -DskipTests clean package' 
            }
        }
    	stage("Send Build Result") {
    		steps {
                sh "echo test change"
            }
    	}
    }

    post {
        failure {
            slackSend color: 'danger', message: """Build #${BUILD_NUMBER} Failed in ${currentBuild.durationString}\nBuild Log:\n```\n${currentBuild.rawBuild.getLog(10)}```\nSee <${BUILD_URL}|here> for more details"""
        }
    }
}
