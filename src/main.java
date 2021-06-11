import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        //Encryption
        String text = "Rosy Park";
        Encryption encryption = new Encryption();

        String encryptMD5 = encryption.MD5(text);
        System.out.println("MD5 : " + encryptMD5);

        String encryptSHA256 = encryption.SHA256(text);
        System.out.println("SHA256 : " + encryptSHA256);

        //FileIO
        //1) 상대경로 주소 
        String path = FileIO.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져온다.
        System.out.println(path);

        FileIO fo = new FileIO();
        fo.fileIO();




    }



}
