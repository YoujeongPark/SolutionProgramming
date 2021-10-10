package main.java;

public class ExternalFileCallClass {

    public void ExternalFileCall(String address){
        Runtime runtime = Runtime.getRuntime();
        //String exeFile = ".\\Everything.exe";
        String exeFile = address;

        Process process;
        try{
            process = runtime.exec(exeFile);
            process.waitFor();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void ExternalFileCall2(String address){
        //String address = ".\\Everything.exe";
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(address);
    }

    public void ExternalFileCall3(){
        String address = ".\\notepad.exe";
        String ex = "안녕하세요\n반갑습니다\n";
        ProcessBuilder processBuilder = new ProcessBuilder(address, ex); // String으로 변환필요
        processBuilder.command(address);
    }


    public void ExternalFileCall4(String address, StringBuffer stringBuffer){
        //String address = ".\\notepad.exe";
        ProcessBuilder processBuilder = new ProcessBuilder(address, stringBuffer.toString()); // String으로 변환필요
        processBuilder.command(address);
    }


}
