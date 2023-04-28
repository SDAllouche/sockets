package ServerMT;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        try {
            Socket s=new Socket("localhost",8090);
            InputStream is=s.getInputStream();
            OutputStream os=s.getOutputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            PrintWriter pw=new PrintWriter(os,true);

            Scanner sc =new Scanner(System.in);
            String msg="";

            while (msg!=null && msg.equals("q")){
                System.out.println("Write a message : ");
                msg=sc.nextLine();
                pw.println(msg);
                msg= br.readLine();
                System.out.println("Server : "+msg);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
