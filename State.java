package TicTacToe;

public enum State {
    ZERO,
    CROSS,
    NONE;

    public boolean equals(State state){
        if(this == NONE || state == NONE)
            return false;
        if(state == this){
            return true;
        }
        return false;
    }
}
