package TicTacToe;

public class Game {

    public static final int SIZE = 3;
    public static Cell[][] field = new Cell[SIZE][SIZE];
    public static State step = State.CROSS;

    public static void main(String[] args){

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                field[i][j] = new Cell(State.NONE);
            }
        }

        new Window();
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
                (field[0][2].getState().equals(field[1][1].getState()) && field[1][1].getState().equals(field[0][2].getState()))
        )
            win = true;

        if(win){
            new WinWindow(state);
        }
    }
}
