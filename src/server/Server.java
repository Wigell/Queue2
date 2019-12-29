package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[] args) {

        String queueLength = "";
        String sentMessage = "";

        try (ServerSocket serverSocket = new ServerSocket(7777)) {

            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            InputStream input = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            while (!queueLength.equals("-1")) {
                queueLength = bufferedReader.readLine();

                System.out.print("Du har nummer: " + queueLength);

                Scanner sc = new Scanner(System.in);
                sentMessage = sc.nextLine();

                writer.println(sentMessage);
                System.out.println("Await clients response..");
            }
            socket.close();

        } catch (IOException e) {
            System.out.println("Server Exception " + e.getMessage());
            e.printStackTrace();
        }
    }

}
