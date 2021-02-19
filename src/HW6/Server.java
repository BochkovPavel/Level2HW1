package HW6;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static final int PORT = 8199;

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started");
            Socket socket = server.accept();
            try(
                Scanner message = new Scanner(System.in);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                Scanner sc = new Scanner(socket.getInputStream());){

                System.out.println("Client connected");

                new Thread(() -> {
                    try{
                        while (true) {
                            String str = sc.nextLine();
                            if (str.equals("/end")) {
                                System.out.println("Client disconnected");
                                break;
                            }
                            System.out.println("Client: " + str);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();

                new Thread(() -> {
                    try{
                        while (true) {
                            String str = message.nextLine();
                            out.println(str);
                            if (str.equals("/end")) {
                                System.out.println("Client disconnected");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
