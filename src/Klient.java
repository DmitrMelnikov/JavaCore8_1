import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Klient {
    public static void main(String[] args) throws IOException {

        try (Socket clientSocket = new Socket("localhost", 8082);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println(clientSocket.getInetAddress()); // отправляю свой адрес
            String resp = in.readLine();
            System.out.println(resp); // читаем ответ сервера
            out.println("quit"); // отправляю команду quit
            resp = in.readLine();
            System.out.println(resp); // читаем, что ответил сервер на команду
        }
    }
}
