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
            String buildTime = currentBuild.durationString
            String buildLog = currentBuild.rawBuild.getLog(10)
            enviroment {
                BUILD_TIME = buildTime
                BUILD_LOG = buildLog
            }

            script {
                def sg = [
                    [
                        text: """
                        Build #${BUILD_NUMBER} Failed in ${BUILD_TIME} ms\n
                        Build Log:\n
                        ```\n
                        ${BUILD_LOG}
                        ```\n
                        See <${BUILD_URL}|here> for more details""",
                        color: 'danger'
                    ]
                ]
                slackSend(channel: '#kafka-webhook-test', attachments: msg)
            }
        }
    }
}
