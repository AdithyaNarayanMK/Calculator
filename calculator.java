package com.adithya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static javax.swing.JFrame.*;

public class calculator  implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[10];
    JButton addB,subB,mulB,divB,powB;
    JButton decB,equB,delB,clrB,negB;
    JPanel panel;
    Font myfont = new Font("Ink Free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    calculator(){
        frame = new JFrame("Calculator");
       //frame.getDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(480,580);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(100,25,300,50);
        textField.setFont(myfont);
        textField.setEditable(false);



        addB = new JButton("+");
        subB = new JButton("-");
        mulB = new JButton("*");
        divB = new JButton("/");
        decB = new JButton(".");
        equB = new JButton("=");
        delB = new JButton("del");
        clrB = new JButton("AC");
        negB = new JButton("(-)");
        powB = new JButton("^");


        functionButtons[0]=addB;
        functionButtons[1]=subB;
        functionButtons[2]=mulB;
        functionButtons[3]=divB;
        functionButtons[4]=decB;
        functionButtons[5]=equB;
        functionButtons[6]=delB;
        functionButtons[7]=clrB;
        functionButtons[8]=negB;
        functionButtons[9]=powB;

        for (int i=0;i<10;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }
        for (int i=0;i<10;i++){
            numberButtons[i] =new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);

        }
        powB.setBounds(50,430,100,50);
        negB.setBounds(150,430,100,50);
        delB.setBounds(250,430,100,50);
        clrB.setBounds(350,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,400,400);
        panel.setLayout(new GridLayout(5,5,10,10));
        //panel.setBackground(Color.BLACK);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addB);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subB);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulB);
        panel.add(decB);
        panel.add(numberButtons[0]);
        panel.add(equB);
        panel.add(divB);
        panel.add(powB);
        panel.add(negB);
        panel.add(delB);
        panel.add(clrB);

        frame.add(panel);

        frame.add(textField);
        frame.setVisible(true);

    }


    public static void main(String[] args) {
        calculator calc = new calculator();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
           if(e.getSource() == numberButtons[i]){
               textField.setText(textField.getText().concat(String.valueOf(i)));
           }
        }
        if(e.getSource() == decB){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addB){
            num1 = Double.parseDouble(textField.getText());
            operator ='+';
            textField.setText("");
        }
        if(e.getSource() == subB){
            num1 = Double.parseDouble(textField.getText());
            operator ='-';
            textField.setText("");
        }
        if(e.getSource() == mulB){
            num1 = Double.parseDouble(textField.getText());
            operator ='*';
            textField.setText("");
        }
        if(e.getSource() == divB){
            num1 = Double.parseDouble(textField.getText());
            operator ='/';
            textField.setText("");
        }
        if(e.getSource() == equB){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1= result;
        }
        if(e.getSource() == clrB){
            textField.setText("");
        }
        if(e.getSource() == delB){
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource() == negB){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
        if(e.getSource() == powB){
            double temp = Double.parseDouble(textField.getText());
            temp = temp * temp;
            textField.setText(String.valueOf(temp));
        }
    }
}
