

import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;


public class ThreadDocDuLieuBanPhimVaGuiClient implements Runnable {

    private Socket server1Socket1;
    private Scanner docDuLieuBanPhim1; 
    private DataOutputStream ghiDuLieuToiClient1;

    public ThreadDocDuLieuBanPhimVaGuiClient(Socket server1Socket1, Scanner docDuLieuBanPhim1, DataOutputStream ghiDuLieuToiClient1) {
        this.server1Socket1 = server1Socket1;
        this.docDuLieuBanPhim1 = docDuLieuBanPhim1;
        this.ghiDuLieuToiClient1 = ghiDuLieuToiClient1;
    }

    @Override
    public void run(){
        try{
            while(true){
                String str1 = docDuLieuBanPhim1.nextLine();
                ghiDuLieuToiClient1.writeUTF(str1);
                System.out.println("[ban da gui]= "+ str1);
            }
        }catch(IOException ex){
            System.out.println("IOException : "+ ex.getMessage());
        }
    }
}
