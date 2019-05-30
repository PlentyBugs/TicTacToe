package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(){
        super("Tic Tac Toe");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.anchor = GridBagConstraints.NORTH;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                constraints.gridy = i;
                constraints.gridx = j;

                panel.add(Game.field[i][j], constraints);
            }
        }

        getContentPane().add(panel);
        pack();
        setVisible(true);
    }

    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
    }
}
