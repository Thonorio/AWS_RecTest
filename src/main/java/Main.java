
public class Main {

    public static void main(String[] args) {
        String clientEndpoint = "<prefix>.iot.<region>.amazonaws.com";       // replace <prefix> and <region> with your own
        String clientId = "<unique client id>";                              // replace with your own client ID. Use unique client IDs for concurrent connections.
        String certificateFile = "<certificate file>";                       // X.509 based certificate file
        String privateKeyFile = "<private key file>";                        // PKCS#1 or PKCS#8 PEM encoded private key file

        // SampleUtil.java and its dependency PrivateKeyReader.java can be copied from the sample source code.
        // Alternatively, you could load key store directly from a file - see the example included in this README.
        SampleUtil.KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certificateFile, privateKeyFile);
        AWSIotMqttClient client = new AWSIotMqttClient(clientEndpoint, clientId, pair.keyStore, pair.keyPassword);

        // optional parameters can be set before connect()
        try {
            client.connect();
        } catch (AWSIotException e) {
            e.printStackTrace();
        }
    }
}
