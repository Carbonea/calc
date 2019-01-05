package GUI;

import javax.swing.*;
import java.awt.*;

public class Equation extends JInternalFrame{


    JPanel internalPanel;
    JInternalFrame internalFrame;
    JTextField text;
    public Equation(){


    internalFrame = new JInternalFrame("Equations", true,true,true);

        internalFrame.setVisible(true);
        internalFrame.setSize(300,420);
        internalFrame.setMinimumSize(new Dimension(300,500));
        text = new JTextField();
        add(text);

    }








}
