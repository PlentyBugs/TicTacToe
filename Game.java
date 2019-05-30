package TicTacToe;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Game {

    public static final int SIZE = 3;
    public static Cell[][] field = new Cell[SIZE][SIZE];
    public static State step = State.CROSS;
    public static State winner = null;

    public static Socket player1;
    public static Socket player2;

    private static ObjectInputStream in1;
    private static ObjectOutputStream out1;

    private static ObjectInputStream in2;
    private static ObjectOutputStream out2;

    public static void main(String[] args) throws IOException {

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                field[i][j] = new Cell(State.NONE);
            }
        }
        ServerSocket server = new ServerSocket(4004);

        player1 = server.accept();
        out1 = new ObjectOutputStream(player1.getOutputStream());
        in1 = new ObjectInputStream(player1.getInputStream());;

        player2 = server.accept();
        out2 = new ObjectOutputStream(player2.getOutputStream());
        in2 = new ObjectInputStream(player2.getInputStream());
    }

    public static void check(State state){
        boolean win = false;

        if(
                (field[0][0].getState().equals(field[0][1].getState()) && field[0][0].getState().equals(field[0][2].getState())) ||
                (field[1][0].getState().equals(field[1][1].getState()) && field[1][0].getState().equals(field[1][2].getState())) ||
                (field[2][0].getState().equals(field[2][1].getState()) && field[2][0].getState().equals(field[2][2].getState())) ||
                (field[0][0].getState().equals(field[1][0].getState()) && field[1][0].getState().equals(field[2][0].getState())) ||
                (field[0][1].getState().equals(field[1][1].getState()) && field[1][1].getState().equals(field[2][1].getState())) ||
                (field[0][2].getState().equals(field[1][2].getState()) && field[1][2].getState().equals(field[2][2].getState())) ||
                (field[0][0].getState().equals(field[1][1].getState()) && field[1][1].getState().equals(field[2][2].getState())) ||
                (field[0][2].getState().equals(field[1][1].getState()) && field[1][1].getState().equals(field[2][0].getState()))
        )
            win = true;

        if(win){
            new WinWindow(state);
        }
    }
}
