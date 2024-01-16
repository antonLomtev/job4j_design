package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                boolean isStop = false;
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    for (String s = input.readLine(); s != null && !s.isEmpty(); s = input.readLine()) {
                        if (s.contains("Bye")) {
                            isStop = true;
                        }
                    }
                    if (isStop) {
                        server.close();
                    }  else {
                        out.flush();
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    }
                }
            }
        }
    }
}
