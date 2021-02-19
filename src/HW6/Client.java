package HW6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client   {
    private static final int PORT = 8199;
    private static final String IP_ADDRESS = "localhost";

    public static void main(String[] args)  {

        try  {
            Socket socket = new Socket(IP_ADDRESS, PORT);
            Scanner in = new Scanner(socket.getInputStream());
            Scanner message = new Scanner(System.in);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Client started");

            new Thread(() -> {
                try {
                    while (true) {
                        String str = in.nextLine();

                        if (str.equals("/end")) {
                            System.out.println("Client disconnected");
                            break;
                        }
                        System.out.println( "Server: " + str);
                    }
                } finally {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


            new Thread(() -> {
                try {
                    while (true) {
                        String str = message.nextLine();
                        out.println(str);
                        if (str.equals("/end")) {
                            System.out.println("Client disconnected");
                            break;
                        }

                    }
                } finally {
                    try {
                        in.close();
                        out.close();
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
