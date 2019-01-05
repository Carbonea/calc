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

        

    }


    public void createButtons() {
        buttonFactory("\u00B1",new ReactionTobPlusMinus(),0,9);
        buttonFactory("0",new ReactionToB0(),1,9);
        buttonFactory(",",new ReactionTobComma(),2,9);
        buttonFactory("=",new ReactionTobResult(),3,9);
        buttonFactory("1",new ReactionToB1(),0,8);
        buttonFactory("2",new ReactionToB2(),0,8);
        buttonFactory("3",new ReactionToB3(),1,8);
        buttonFactory("+",new ReactionTobAdd(),2,9);
        buttonFactory("4",new ReactionToB4(),3,9);
        buttonFactory("5",new ReactionToB5(),0,7);
        buttonFactory("6",new ReactionToB6(),1,7);
        buttonFactory("-",new ReactionTobSubs(),2,7);
        buttonFactory("7",new ReactionToB7(),3,7);
        buttonFactory("8",new ReactionToB8(),0,6);
        buttonFactory("9" ,new ReactionToB9(),1,6);
        buttonFactory("*" ,new ReactionTobMult(),2,6);
        buttonFactory("CE",new ReactionTobClearEntry(),0,5);
        buttonFactory("C" ,new ReactionTobClearAll(),1,5);
        buttonFactory("<<",new ReactionTobBackspc(),2,5);
        buttonFactory("/",new ReactionTobDiv(),3,5);
        buttonFactory('\u221A' + "x" ,new ReactionTobElement(),0,4);
        buttonFactory("<html>x<sup>2</sup></html>",new ReactionTobExponentiation(),1,4);
        buttonFactory("Sin",new ReactionTobSin(),2,4);
        buttonFactory("Cos",new ReactionTobCos(),3,4);
        buttonFactory("Eq",new ReactionTobEquation(),0,3);
        buttonFactory("Mod" ,new ReactionTobMod(),1,3);
        buttonFactory("Tan",new ReactionTobTan(),2,3);
        buttonFactory("ln",new ReactionTobLn(),3,3);







    }




    public void buttonFactory(String text, ActionListener cos, int x, int y){

        JButton button = new JButton(text);
        constraints.gridx = x;
        constraints.gridy = y;
        button.addActionListener(cos);

        panel.add(button,constraints);




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

