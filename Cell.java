package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {

    public State state;

    public Cell(State state) {
        setPreferredSize(new Dimension(100,100));
        setMaximumSize(new Dimension(100,100));
        setMinimumSize(new Dimension(100,100));
        this.state = state;
        addActionListener(e -> {
            setState(Game.step);
            setEnabled(false);
            Game.check(Game.step);
            if(Game.step == State.CROSS) {
                setText("Cross");
                Game.step = State.ZERO;
            } else {
                setText("Zero");
                Game.step = State.CROSS;
            }
        });
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
