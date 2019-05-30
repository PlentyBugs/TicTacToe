package TicTacToe;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TestClient {

    public static Window window;

    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Socket socket = new Socket(InetAddress.getByName("localhost"), 4004);

        in = new ObjectInputStream(socket.getInputStream());
        out = new ObjectOutputStream(socket.getOutputStream());

        window = new Window();

        while (Game.winner == null){

        }
    }
}
