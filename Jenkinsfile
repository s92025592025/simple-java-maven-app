
import hudson.Util

import groovy.grape.Grape
//Grape.grab([group='com.oracle.oci.sdk', module='oci-java-sdk-common', version='1.9.1'])
//import com.oracle.*;
//@Grab(group='com.oracle.oci.sdk', module='oci-java-sdk-bom', version='1.9.1',scope='import')
//@Grab(group='com.oracle.oci.sdk', module='oci-java-sdk-common', version='1.9.1')
/*@Grapes(
    @Grab(group='com.oracle.oci.sdk', module='oci-java-sdk-common', version='1.9.1')
)*/
//import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider
//@Grab('com.oracle.oci.sdk:oci-java-sdk-bom:1.9.1')

//def sendData

pipeline {
    agent { node { label 'master' } }

    stages {
        stage('Build') { 
            steps {
                sh '/Users/jiuwang/Documents/oci-stream-jenkins/env/bin/python /Users/jiuwang/Documents/oci-stream-jenkins/jenkins_log_streaming.py --key build-event --msg "build #${BUILD_NUMBER} started at $(date)"'
                sh 'mvn -B -DskipTests clean package' 
            }
        }
    	stage("Send Build Result") {
            steps{
                sh 'python3 /Users/jiuwang/Documents/oci-stream-jenkins/jenkins_log_streaming.py --key build-event --msg "build #${BUILD_NUMBER} Ended at $(date)"'
                sh 'python3 /Users/jiuwang/Documents/oci-stream-jenkins/jenkins_log_streaming.py --key build-log --msg (cat .jenkins/jobs/oci-stream-demo/branches/master/builds/${BUILD_NUMBER}/log)'              
            }
        
        }
    }
}