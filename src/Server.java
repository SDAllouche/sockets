import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        try {

            ServerSocket ss=new ServerSocket(8090);
            Socket s=ss.accept();
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            String str=br.readLine();
            System.out.println(str);
            PrintWriter pw=new PrintWriter(os,true);
            pw.println("Server");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
