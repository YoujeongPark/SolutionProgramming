import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    public String MD5(String pwd){
        String MD5 = "";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest msgDgst = MessageDigest.getInstance("MD5");
            msgDgst.update(pwd.getBytes());


            byte[] msg = msgDgst.digest();
            for(int i=0 ; i<msg.length ; i++){
                String temp = Integer.toHexString((int)msg[i] & 0x00ff);
                stringBuffer.append(temp);
            }

        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            MD5 = null;
        }
        return stringBuffer.toString();
    }

    public String SHA256(String pwd){
        String SHA256 = "";
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest msgDgst = MessageDigest.getInstance("SHA-256");
            msgDgst.update(pwd.getBytes("UTF-8"));

            byte[] msg = msgDgst.digest();
            for (int i = 0; i < msg.length; i++) {
                String temp = Integer.toHexString((int) msg[i] & 0xff);
                if(temp.length() == 1) stringBuffer.append('0');
                stringBuffer.append(temp);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}
