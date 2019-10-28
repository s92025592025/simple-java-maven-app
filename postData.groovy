@Grab(group='com.oracle.oci.sdk', module='oci-java-sdk-bom', version='1.9.1')
import import com.oracle.bmc.auth.ConfigFileAuthenticationDetailsProvider

def sendMsg(){
	ConfigFileAuthenticationDetailsProvider provider =  new ConfigFileAuthenticationDetailsProvider('/path/to/.oci/config', 'DEFAULT')
}