
import hudson.Util;
//import com.oracle.*;
@Grab('com.oracle.oci.sdk:oci-java-sdk-bom:1.9.1')
import com.oracle.bmc.auth.*; //ConfigFileAuthenticationDetailsProvider
//@Grab('com.oracle.oci.sdk:oci-java-sdk-bom:1.9.1')

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
                ConfigFileAuthenticationDetailsProvider provider =  new ConfigFileAuthenticationDetailsProvider('/path/to/.oci/config', 'DEFAULT')
            }
        
        }
    }
}
