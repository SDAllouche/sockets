package ServerMT;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread{

    private Socket s;
    private List<Socket> gamers=new ArrayList<>();
    private int number;

    public ServerThread(Socket s, List<Socket> gamers,int number) {
        this.s = s;
        this.gamers = gamers;
        this.number=number;
    }

    @Override
    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os=s.getOutputStream();
            InputStreamReader isr=new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);
            PrintWriter pw=new PrintWriter(os,true);
            pw.println("Write your name : ");
            String name=br.readLine();
            System.out.println(name+" is connected successfully");
            int n=0;
            String str="";
            do {
                try {
                    pw.println("Guess a number : ");
                    if ((str=br.readLine())!=null){
                        n=Integer.parseInt(str);
                        if (n==number){
                            pw.println("You succeed!!");
                            for (Socket player:gamers){
                                if (s!=player){
                                    OutputStream osg=player.getOutputStream();
                                    PrintWriter pwg=new PrintWriter(osg,true);
                                    pwg.println("Player : "+name+" finds the right number");
                                }
                            }
                        } else if (n>number) {
                            pw.println("The number is high");
                        }else {
                            pw.println("The number is low");
                        }
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
                catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                }
            }while (n!=number);
            for (Socket player:gamers) {
                player.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
