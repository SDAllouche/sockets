package ServerMT;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Server {
    public static void main(String[] args) {

        List<Socket> players=new ArrayList<>();
        int number=new Random().nextInt(100);

        try {
            ServerSocket ss=new ServerSocket(8090);
            while (true){
                Socket s=ss.accept();
                players.add(s);
                ServerThread st=new ServerThread(s,players,number);
                st.start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
