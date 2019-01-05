package GUI;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {


    NumberPanel numberPanel;
    JDesktopPane pane = new JDesktopPane();

    public GUI(){

        setTitle("Calculator");
        setSize(300,350);


        numberPanel = new NumberPanel();
        setLayout(new GridBagLayout());

        add(numberPanel);

    }

}
