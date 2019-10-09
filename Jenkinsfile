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
                def message
            }
    	}
    }

    post {
        failure {
            def msg = [
                [
                    text: """
                    Build #${BUILD_NUMBER} Failed in ${Util.getTimeSpanString(System.currentTimeMillis() - currentBuild.startTimeInMillis)} ms\n
                    Build Log:\n
                    ```\n
                    ${currentBuild.rawBuild.getLog(10)}
                    ```\n
                    See <${BUILD_URL}|here> for more details"""
                    color: 'danger'
                ]
            ]
            slackSend(channel: '#kafka-webhook-test', attachments: msg)
        }
    }
}
