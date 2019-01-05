package GUI;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class NumberPanel extends JPanel {

    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bAdd, bSub, bMult, bComma, bDiv, bResult, bBackspc, bClearAll, bClearEntry, bExponentiation, bElement, bLn, bSin, bCos,bTan, bPlusMinus, bMod,bEquation;
    GridBagConstraints constraints = new GridBagConstraints();
    JPanel panel;
    static JTextField textField;
    JLabel previous, parameter1, parameter2, parameter3;
    double num, answer, sign;
    int calculation;
    Equation internalFrame;
    JDesktopPane desktopPane = new JDesktopPane();


    public NumberPanel() {

        panel = new JPanel();

        setLayout(new GridBagLayout());

        textField = new JTextField();
        textField.setHorizontalAlignment(JTextField.RIGHT); // text appears on the right side of the textField
        previous = new JLabel();
        previous.setHorizontalAlignment(JTextField.RIGHT);



        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 4;
        constraints.fill = GridBagConstraints.BOTH;
        add(previous, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 4;
        constraints.gridheight = 2; //nie zmienia pola tekstowego
        add(textField, constraints);

        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        createButtons();

        addButtons();

    }


    public void createButtons() {
        b0 = new JButton("0");
        b0.addActionListener(new ReactionToB0());
        b1 = new JButton("1");
        b1.addActionListener(new ReactionToB1());
        b2 = new JButton("2");
        b2.addActionListener(new ReactionToB2());
        b3 = new JButton("3");
        b3.addActionListener(new ReactionToB3());
        b4 = new JButton("4");
        b4.addActionListener(new ReactionToB4());
        b5 = new JButton("5");
        b5.addActionListener(new ReactionToB5());
        b6 = new JButton("6");
        b6.addActionListener(new ReactionToB6());
        b7 = new JButton("7");
        b7.addActionListener(new ReactionToB7());
        b8 = new JButton("8");
        b8.addActionListener(new ReactionToB8());
        b9 = new JButton("9");
        b9.addActionListener(new ReactionToB9());
        bAdd = new JButton("+");
        bAdd.addActionListener(new ReactionTobAdd());
        bSub = new JButton("-");
        bSub.addActionListener(new ReactionTobSubs());
        bMult = new JButton("*");
        bMult.addActionListener(new ReactionTobMult());
        bDiv = new JButton("/");
        bDiv.addActionListener(new ReactionTobDiv());
        bResult = new JButton("=");
        bResult.addActionListener(new ReactionTobResult());
        bBackspc = new JButton("<--");
        bBackspc.addActionListener(new ReactionTobBackspc());
        bComma = new JButton(",");
        bComma.addActionListener(new ReactionTobComma());
        bClearAll = new JButton("C");
        bClearAll.addActionListener(new ReactionTobClearAll());
        bClearEntry = new JButton("CE");
        bClearEntry.addActionListener(new ReactionTobClearEntry());
        bExponentiation = new JButton("<html>x<sup>2</sup></html>");
        bExponentiation.addActionListener(new ReactionTobExponentiation());
        bElement = new JButton('\u221A' + "x");
        bElement.addActionListener(new ReactionTobElement());
        bLn = new JButton("ln");
        bLn.addActionListener(new ReactionTobLn());
        bSin = new JButton("Sin");
        bSin.addActionListener(new ReactionTobSin());
        bCos = new JButton("Cos");
        bCos.addActionListener(new ReactionTobCos());
        bTan = new JButton("Tg");
        bTan.addActionListener(new ReactionTobTan());
        bPlusMinus = new JButton("\u00B1");
        bPlusMinus.addActionListener(new ReactionTobPlusMinus());
        bMod = new JButton("Mod");
        bMod.addActionListener(new ReactionTobMod());
        bEquation = new JButton("Eq");
        bEquation.addActionListener(new ReactionTobEquation());
    }

    public void addButtons() {


        constraints.gridx = 0;
        constraints.gridy = 9;
        add(bPlusMinus,constraints);


        constraints.gridx = 1;
        constraints.gridy = 9;
        add(b0, constraints);


        constraints.gridx = 2;
        constraints.gridy = 9;
        add(bComma, constraints);


        constraints.gridx = 3;
        constraints.gridy = 9;
        add(bResult, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        add(b1, constraints);


        constraints.gridx = 1;
        constraints.gridy = 8;
        add(b2, constraints);


        constraints.gridx = 2;
        constraints.gridy = 8;
        add(b3, constraints);


        constraints.gridx = 3;
        constraints.gridy = 8;
        add(bAdd, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        add(b4, constraints);


        constraints.gridx = 1;
        constraints.gridy = 7;
        add(b5, constraints);


        constraints.gridx = 2;
        constraints.gridy = 7;
        add(b6, constraints);


        constraints.gridx = 3;
        constraints.gridy = 7;
        add(bSub, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;
        add(b7, constraints);


        constraints.gridx = 1;
        constraints.gridy = 6;
        add(b8, constraints);


        constraints.gridx = 2;
        constraints.gridy = 6;
        add(b9, constraints);


        constraints.gridx = 3;
        constraints.gridy = 6;
        add(bMult, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        add(bClearEntry,constraints);


        constraints.gridx = 1;
        constraints.gridy = 5;
        add(bClearAll, constraints);


        constraints.gridx = 2;
        constraints.gridy = 5;
        add(bBackspc, constraints);


        constraints.gridx = 3;
        constraints.gridy = 5;
        add(bDiv, constraints);



        constraints.gridx = 0;
        constraints.gridy = 4;
        add(bElement,constraints);


        constraints.gridx = 1;
        constraints.gridy = 4;
        add(bExponentiation, constraints);


        constraints.gridx = 2;
        constraints.gridy = 4;
        add(bSin,constraints);


        constraints.gridx = 3;
        constraints.gridy = 4;
        add(bCos,constraints);


        constraints.gridx = 0;
        constraints.gridy = 3;
        add(bEquation,constraints);


        constraints.gridx = 1;
        constraints.gridy = 3;
        add(bMod,constraints);

        constraints.gridx = 2;
        constraints.gridy = 3;
        add(bTan,constraints);

        constraints.gridx = 3;
        constraints.gridy = 3;
        add(bLn,constraints);


    }


   // reactions

    class ReactionToB0 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "0");


        }
    }

    class ReactionToB1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "1");


        }
    }

    class ReactionToB2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "2");

        }
    }

    class ReactionToB3 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "3");

        }
    }

    class ReactionToB4 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "4");

        }
    }

    class ReactionToB5 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "5");

        }
    }

    class ReactionToB6 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "6");

        }
    }

    class ReactionToB7 implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "7");
        }

    }

    class ReactionToB8 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "8");


        }
    }

    class ReactionToB9 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            NumberPanel.getTextField().setText(NumberPanel.getTextField().getText() + "9");

        }
    }

    class ReactionTobBackspc implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            int length = getTextField().getText().length();
            int index = length - 1;
            String properFormula;

            if (length > 0) {
                StringBuilder wrongFormula = new StringBuilder(getTextField().getText());
                wrongFormula.deleteCharAt(index);
                properFormula = wrongFormula.toString();
                getTextField().setText(properFormula);

            }

        }
    }

    class ReactionTobClearAll implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            getTextField().setText("");
            getLabel().setText("");

        }
    }

    class ReactionTobClearEntry implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            getTextField().setText("");
        }
    }

    class ReactionTobComma implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            getTextField().setText(getTextField().getText() + ".");

        }
    }

    class ReactionTobAdd implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            /*
                num to jest wartosc wpisanej liczby przed nacisnieciem przycisku dodaj
                calculation jest ustatwione na 1 poto aby przy nacisnieciu "=" wywolalo switcha z dodawaniem
                tekst jest czyszczony aby wprowadzic nowa wartosc
                na label jest ustawiana wwartosc wczesniej wpisanego tekstu i znak dzialania
             */


            num = Double.parseDouble(getTextField().getText());
            calculation = 1;
            getTextField().setText("");
            getLabel().setText(num + " +");

        }
    }

    class ReactionTobSubs implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            num = Double.parseDouble(getTextField().getText());
            calculation = 2;
            getTextField().setText("");
            getLabel().setText(num + " -");

        }
    }

    class ReactionTobMult implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            num = Double.parseDouble(getTextField().getText());
            calculation = 3;
            getTextField().setText("");
            getLabel().setText(num + " *");

        }
    }

    class ReactionTobDiv implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            num = Double.parseDouble(getTextField().getText());
            calculation = 4;
            getTextField().setText("");
            getLabel().setText(num + " /");

        }
    }

    class ReactionTobResult implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            /*
                na label pojawia sie dzialanie przez nas porzadane
                wykonywana jest operacja operations czyli switch
                gdzie do pola answer przypisuje sie konkretne dzialanie i jest ono wyswietane w oknie kalkulatora
             */
            getLabel().setText(getLabel().getText() + " " + getTextField().getText());

            operations();

        }
    }

    class ReactionTobExponentiation implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getLabel().setText(getTextField().getText() + "\u00B2");
            num = Double.parseDouble(getTextField().getText());
            calculation = 5;
            operations();
        }
    }

    class ReactionTobElement implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getLabel().setText('\u221A' + getTextField().getText());
            num = Double.parseDouble(getTextField().getText());
            calculation = 6;
            operations();
        }
    }

    class ReactionTobLn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getLabel().setText("ln" + getTextField().getText());
            num = Double.parseDouble(getTextField().getText());
            calculation = 7;
            operations();
        }
    }

    class ReactionTobSin implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getLabel().setText("Sin(" + getTextField().getText() + ")");
            num = Double.parseDouble(getTextField().getText());
            calculation = 8;
            operations();
        }
    }

    class ReactionTobCos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getLabel().setText("Cos(" + getTextField().getText() + ")");
            num = Double.parseDouble(getTextField().getText());
            calculation = 9;
            operations();
        }
    }

    class ReactionTobTan implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            getLabel().setText("Tan(" + getTextField().getText() + ")");
            num = Double.parseDouble(getTextField().getText());
            calculation = 10;
            operations();

        }
    }

    class ReactionTobPlusMinus implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

            sign = Double.parseDouble(getTextField().getText());
            sign = -sign;
            getTextField().setText(Double.toString(sign));

        }
    }

    class ReactionTobMod implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            num = Double.parseDouble(getTextField().getText());
            calculation = 11;
            getTextField().setText("");
            getLabel().setText(num + "Mod");
        }
    }

    class ReactionTobEquation implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            internalFrame = new Equation();
            desktopPane.add(internalFrame);
            add(desktopPane);

        }
    }




    // operations

    private void operations() {

        switch (calculation) {

            case 1: //addition

                answer = num + Double.parseDouble(getTextField().getText());
                getTextField().setText(Double.toString(answer));

                break;
            case 2: //subtraction

                answer = num - Double.parseDouble(getTextField().getText());
                getTextField().setText(Double.toString(answer));

                break;
            case 3: // multiplication

                answer = num * Double.parseDouble(getTextField().getText());
                getTextField().setText(Double.toString(answer));

                break;
            case 4: //division

                if (Double.parseDouble(getTextField().getText()) == 0) {

                    getTextField().setText("Error");
                }
                else {
                    answer = num / Double.parseDouble(getTextField().getText());
                    getTextField().setText(Double.toString(answer));
                }
                break;

            case 5: // exponentiation

                answer = Math.pow(num, 2);
                getTextField().setText(Double.toString(answer));
                break;
            case 6: //square root

                answer = Math.sqrt(num);
                getTextField().setText(Double.toString(answer));

                break;
            case 7: //natural logarithm

                answer = Math.log(num);
                getTextField().setText(Double.toString(answer));

                break;
            case 8: // sinus

                answer = Math.sin(num);
                getTextField().setText(Double.toString(answer));

                break;
            case 9: //cosinus

                answer = Math.cos(num);
                getTextField().setText(Double.toString(answer));


                break;
            case 10:

                answer = Math.tan(num);
                getTextField().setText(Double.toString(answer));

            case 11:

                answer = num % Double.parseDouble(getTextField().getText());
                getTextField().setText(Double.toString(answer));
                break;
            default:

                break;


        }


    }


    //getters

    public static JTextField getTextField() {
        return textField;
    }

    public JLabel getLabel() {
        return previous;
    }

}

