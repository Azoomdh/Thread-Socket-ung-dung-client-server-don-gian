
import java.io.*;
import java.lang.*;
import java.net.*;
import java.util.*;

public class ServerSock {
    public static void main(String[] args) {
        try(ServerSocket manager1OfServer1Socket = new ServerSocket(9999);) {
            Socket server1Socket1= manager1OfServer1Socket.accept();
            System.out.println("# da accept voi client");

            DataInputStream docDuLieuClientGuiVe1 = new DataInputStream(server1Socket1.getInputStream() );
            DataOutputStream ghiDuLieuToiClient1 = new DataOutputStream(server1Socket1.getOutputStream() );
            Scanner docDuLieuBanPhim1 = new Scanner(System.in);

            Thread threadDocDuLieuBanPhimVaGuiClient1 = new Thread( new ThreadDocDuLieuBanPhimVaGuiClient(server1Socket1, docDuLieuBanPhim1, ghiDuLieuToiClient1) );
            Thread threadDocDuLieuClientGuiVe1 = new Thread( new ThreadDocDuLieuClientGuiVe(server1Socket1, docDuLieuClientGuiVe1) );

                threadDocDuLieuClientGuiVe1.start();
                threadDocDuLieuBanPhimVaGuiClient1.start();
        } catch (IOException ex) {
            System.out.println("IOException : "+ ex.getMessage());
        }
    }
}
