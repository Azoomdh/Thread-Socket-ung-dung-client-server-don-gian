


import java.io.*;
import java.lang.*;
import java.net.*;

public class ThreadDocDuLieuClientGuiVe implements Runnable{
    private Socket server1Socket1;
    private DataInputStream docDuLieuClientGuiVe1;
    public ThreadDocDuLieuClientGuiVe(Socket server1Socket1, DataInputStream docDuLieuClientGuiVe1){
        this.server1Socket1 = server1Socket1;
        this.docDuLieuClientGuiVe1 = docDuLieuClientGuiVe1; 
    }

    @Override
    public void run(){
        try {
            String idClient1 = server1Socket1.getInetAddress().getHostAddress();
            while(true){ 
                String str1= docDuLieuClientGuiVe1.readUTF();
                System.out.println("[id : "+ idClient1+ " ] said= "+ str1);
            }   
        } catch (IOException ex) {
            System.out.println("IOexception : "+ ex.getMessage());
        }
    }
}