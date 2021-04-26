
public class main {

    public static void main(String[] args) {
        String text = "Rosy Park";

        //Encryption
        Encryption encryption = new Encryption();

        String encryptMD5 = encryption.MD5(text);
        System.out.println("MD5 : " + encryptMD5);

        String encryptSHA256 = encryption.SHA256(text);
        System.out.println("SHA256 : " + encryptSHA256);
    }

}
