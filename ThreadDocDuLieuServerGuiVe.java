
import java.io.*;
import java.lang.*;
import java.net.*;


public class ThreadDocDuLieuServerGuiVe implements Runnable {
    private Socket client1Socket1;
    private DataInputStream nhanDuLieuServerGuiVe1;
    
    public ThreadDocDuLieuServerGuiVe( Socket client1Socket1, DataInputStream nhanDuLieuServerGuiVe1) {
        this.nhanDuLieuServerGuiVe1 = nhanDuLieuServerGuiVe1;
        this.client1Socket1 = client1Socket1;
    }

    @Override
    public void run(){
        try {
            String idServer1= client1Socket1.getInetAddress().toString();
            while(true){
                String str1= nhanDuLieuServerGuiVe1.readUTF();
                System.out.println("[id :"+ idServer1+ "] said= "+ str1);
            }
        } catch (IOException ex) {
            System.out.println("IOException : "+ ex.getMessage());
        }
    }
}
