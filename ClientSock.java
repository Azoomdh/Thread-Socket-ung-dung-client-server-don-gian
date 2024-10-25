
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.Scanner;


public class ClientSock {
    public static void main(String[] args) {
        try {
            Socket client1Socket1 = new Socket("127.0.0.1", 9999);
            System.out.println("#bat dau ket noi voi server");
            
            DataInputStream nhanDuLieuServerGuiVe1 = new DataInputStream(client1Socket1.getInputStream() );
            DataOutputStream ghiDuLieuToiServer1 = new DataOutputStream(client1Socket1.getOutputStream() );
            Scanner docDuLieuBanPhim1 = new Scanner(System.in);

            Thread threadDocDuLieuBanPhimVaGuiServer1 = new Thread( new ThreadDocDuLieuBanPhimVaGuiServer(client1Socket1, docDuLieuBanPhim1, ghiDuLieuToiServer1) );
            Thread threadDocDuLieuServerGuiVe1 = new Thread( new ThreadDocDuLieuServerGuiVe(client1Socket1, nhanDuLieuServerGuiVe1) );

            // while(true){
                threadDocDuLieuBanPhimVaGuiServer1.start();
                threadDocDuLieuServerGuiVe1.start();
            // }
        } catch (IOException ex) {
            System.out.println("IOException : "+ ex.getMessage());
        }
    }
}
