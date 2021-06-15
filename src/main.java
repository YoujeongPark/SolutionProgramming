import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {

        //Encryption
        System.out.println("-----------------------------------------");
        String text = "Rosy Park";
        Encryption encryption = new Encryption();

        String encryptMD5 = encryption.MD5(text);
        System.out.println("MD5 : " + encryptMD5);

        String encryptSHA256 = encryption.SHA256(text);
        System.out.println("SHA256 : " + encryptSHA256);

        //FileIO
        //1) 상대경로 주소
        System.out.println("-----------------------------------------");
        String path = FileIO.class.getResource("").getPath(); // 현재 클래스의 절대 경로를 가져오기
        System.out.println(path);

        FileIO fo = new FileIO();
        fo.fileRead();
        fo.fileWrite();
        fo.fileReadAll();

        //Random
        RandomMaker rm = new RandomMaker();
        rm.randomAlphabet();


    }



}
