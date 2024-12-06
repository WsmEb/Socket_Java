import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MTServerSocket extends Thread {
    private static int NB_CLIENT;
    private final int PORT = 3005;

    public static void main(String[] args) {
        new MTServerSocket().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(this.PORT);
            System.out.println("Server is Runnig...");
            while (true) {
                Socket s = ss.accept();
                NB_CLIENT++;
                int client_nb = NB_CLIENT;
                new Conversation(s, client_nb).start();
            }
        } catch (IOException err) {
            err.printStackTrace();
        }

    }

    public class Conversation extends Thread {
        private final Socket socket;
        private final int NB_CLIENT;

        public Conversation(Socket s, int nb_client) {
            this.socket = s;
            this.NB_CLIENT = nb_client;
        }

        public void run() {
            try {
                InputStream is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os, true);

                String IP = socket.getRemoteSocketAddress().toString();

                System.out.println("Client N " + this.NB_CLIENT + " Connected." + " IP=" + IP);
                pw.println("Welcome you are the client N: " + this.NB_CLIENT + " Your IP=" + IP);

                while (true) {
                    Scanner Input = new Scanner(System.in);
                    String msg = Input.nextLine();
                    pw.println(msg);
                    String res = br.readLine();
                    System.out.println("Client NB : " + this.NB_CLIENT + " Send : " + res);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
