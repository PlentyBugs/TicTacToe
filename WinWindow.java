package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

public class WinWindow extends JFrame {

    public WinWindow(State state) {
        super("Вы победили");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new Dimension(240,480));
        setAlwaysOnTop(true);
        String text = "";

        if(state.equals(State.CROSS))
            text = "Крестики победили";
        else
            text = "Нолики победили";

        Game.winner = state;

        JLabel label = new JLabel(text);
        label.setFont(new Font("Default", Font.BOLD, 40));

        getContentPane().add(label);
        pack();
        setVisible(true);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                close();
            }
        }, 5*1000);
    }

    public void close(){
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
