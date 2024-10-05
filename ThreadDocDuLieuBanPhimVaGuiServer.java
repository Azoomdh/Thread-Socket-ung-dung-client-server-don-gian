
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;


public class ThreadDocDuLieuBanPhimVaGuiServer implements Runnable{
    private Socket client1Socket1;
    private Scanner docDuLieuBanPhim1;
    private DataOutputStream ghiDuLieuToiServer1;
    public ThreadDocDuLieuBanPhimVaGuiServer(Socket client1Socket1, Scanner docDuLieuBanPhim1, DataOutputStream ghiDuLieuToiServer1){
        this.client1Socket1 = client1Socket1;
        this.docDuLieuBanPhim1 = docDuLieuBanPhim1;
        this.ghiDuLieuToiServer1 = ghiDuLieuToiServer1;
    }

    @Override
    public void run(){
        try {
            while(true){
                String str1 = docDuLieuBanPhim1.nextLine();
                ghiDuLieuToiServer1.writeUTF(str1);
                System.out.println("ban da gui : "+ str1);
            }   
        } catch (IOException ex) {
            System.out.println("IOException : "+ ex.getMessage());
        }
    }
}
