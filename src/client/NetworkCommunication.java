package client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class NetworkCommunication {
    private String queueLength = "";
    private Socket socket;
    private PrintWriter writer;

    public void connect(Controller controller) {
        try {
            this.socket = new Socket("127.0.0.1", 7777);
            OutputStream output = socket.getOutputStream();

            this.writer = new PrintWriter(output, true);
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            controller.getQueueLength();
            while (!queueLength.equals("-1")) {

                writer.println(queueLength);

            }

        }

     catch (UnknownHostException e) {
        System.out.println("Server not found: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }

    public void sendQueueLength(String queueLength) {

        writer.println(queueLength);
    }

    public void closeConnection(Socket socket) throws IOException {
             socket.close();
    }


    public Socket getSocket() {
        return socket;
    }
}

