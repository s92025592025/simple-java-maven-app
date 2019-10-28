
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
                /*
                withKafkaLog(kafkaServers: '172.17.0.4:9093', kafkaTopic: 'test', metadata:'Other info to send..') {
                echo 'this'
                echo 'is a'
                echo 'Demo'
                }
                */
                echo "apples"
                node {
                    label 'apples'
                    def sendData = load 'postData.groovy'
                    sendData.sendMsg()
                }
                
            }
        
        }
    }
}
