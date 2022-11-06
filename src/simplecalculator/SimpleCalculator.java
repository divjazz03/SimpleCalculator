/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplecalculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SimpleCalculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton, decButton, clrButton, equalButton, delButton, negButton;
    JPanel panel;
    
    Font myFont = new Font("Ink Free", Font.BOLD, 30);
    double num1 = 0;
    double num2 = 0;
    double result;
    char operator;

    public SimpleCalculator() {
        frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);
       
        frame.setResizable(Boolean.FALSE);
        
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);
        
        addButton = new JButton("+");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        subButton = new JButton("-");
        decButton = new JButton(".");
        equalButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");
        
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = clrButton;
        functionButtons[7]= delButton;
        functionButtons[8] = negButton;
        
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        
        for (int i = 0; i < 10; i++) {
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].addActionListener(this);
        }
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
        
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.gray);
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);
                
                
        
        
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(clrButton);
        frame.add(delButton);
        frame.add(textField);
        frame.setVisible(true);
                

    }
    
    
    public static void main(String[] args) {
        SimpleCalculator calc = new SimpleCalculator();
    }

    @Override
    public void actionPerformed(ActionEvent e)  {
       
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
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
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            textField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1; i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        try{try{if (e.getSource() == negButton) {
           double temp = Double.parseDouble(textField.getText());
           temp*=-1;
           textField.setText(String.valueOf(temp));
        }}catch(NumberFormatException ex){
        textField.setText("no value");
        Thread.sleep(3000);
        textField.setText("");}}
        catch(InterruptedException interruptedException){}
    }
}
