import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        try {
            Socket s=new Socket("localhost",8090);
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            PrintWriter pw=new PrintWriter(os,true);
            pw.println("Bonjour");
            String msg=br.readLine();
            System.out.println(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
