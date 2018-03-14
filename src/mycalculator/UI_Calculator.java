package mycalculator;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class UI_Calculator implements ActionListener {

    private JFrame mainFrame;
    private JPanel controlPanel;
    private JTextArea text;
    private JButton button[], butAdd, butMinus, butMultiply, butDivide,
            butEqual, butSquare, butCancle, butSquareRoot, butBackSpace,
            butDode;

    private final String[] butValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    double result, number1, number2;
    boolean add, sub, multi, div, square, squareR;

    public UI_Calculator() {
        prepareUI();
        menu();
        init();

    }

    public void prepareUI() {
        mainFrame = new JFrame("Calulator");
        mainFrame.setResizable(false);
        controlPanel = new JPanel(new FlowLayout());
        button = new JButton[10];

        text = new JTextArea(3, 21);
        text.setFont(new Font("Tahoma", Font.BOLD, 15));
        for (int i = 0; i < 10; i++) {
            button[i] = new JButton(String.valueOf(i));
            button[i].setFont(new Font("Tahoma", Font.BOLD, 15));

        }
        butAdd = new JButton("+");
        butAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
        butMinus = new JButton("-");
        butMinus.setFont(new Font("Tahoma", Font.BOLD, 15));
        butMultiply = new JButton("*");
        butAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
        butDivide = new JButton("/");
        butMultiply.setFont(new Font("Tahoma", Font.BOLD, 15));
        butEqual = new JButton("=");
        butEqual.setFont(new Font("Tahoma", Font.BOLD, 15));
        butSquare = new JButton("x^2");
        butSquare.setFont(new Font("Tahoma", Font.BOLD, 15));
        butSquareRoot = new JButton("√");
        butSquareRoot.setFont(new Font("Tahoma", Font.BOLD, 15));
        butBackSpace = new JButton("←");
        butBackSpace.setFont(new Font("Tahoma", Font.BOLD, 15));
        butCancle = new JButton("C");
        butCancle.setFont(new Font("Tahoma", Font.BOLD, 15));
        butDode = new JButton(".");
        butDode.setFont(new Font("Tahoma", Font.BOLD, 15));

    }

    private void menu() {
        JMenuBar menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);
        final JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        final JMenu view = new JMenu("View");
         view.setMnemonic(KeyEvent.VK_V);
        final JMenu edit = new JMenu("Edit");
         edit.setMnemonic(KeyEvent.VK_E);
        final JMenu help = new JMenu("Help");
         help.setMnemonic(KeyEvent.VK_H);
        menuBar.add(file);
        menuBar.add(view);
        menuBar.add(edit);
        menuBar.add(help);
        JMenuItem open = new JMenuItem("Open file");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(open);
        file.add(exit);
        

    }

    public void init() {
        mainFrame.setVisible(true);
        mainFrame.setSize(300, 350);
        controlPanel.add(text);
        mainFrame.add(controlPanel);
        JPanel panel = new JPanel();
        panel.setBackground(Color.GRAY);
        panel.setSize(200, 200);

        GridLayout layout = new GridLayout(5, 4);
        layout.setHgap(5);
        layout.setVgap(5);
        panel.setLayout(layout);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < 10; i++) {
            panel.add(button[i]);
            button[i].addActionListener(this);

        }
        panel.add(butDode);
        panel.add(butAdd);
        panel.add(butMinus);
        panel.add(butMultiply);
        panel.add(butDivide);
        panel.add(butSquare);
        panel.add(butSquareRoot);
        panel.add(butCancle);
        panel.add(butBackSpace);
        panel.add(butEqual);

        butAdd.addActionListener(this);
        butMinus.addActionListener(this);
        butMultiply.addActionListener(this);
        butDivide.addActionListener(this);
        butEqual.addActionListener(this);
        butBackSpace.addActionListener(this);
        butSquare.addActionListener(this);
        butSquareRoot.addActionListener(this);
        butCancle.addActionListener(this);
        butDode.addActionListener(this);
        controlPanel.add(panel);
       

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Object source = e.getSource();
       
        for (int i = 0; i < 10; i++) {
            if (source == button[i]) {
                text.replaceSelection(butValue[i]);
                return;
            }
        }

        if (source == butAdd) {
            number1 = Double.parseDouble(text.getText());
            text.setText("");
            add = true;

        }
        if (source == butMinus) {
            number1 = Double.parseDouble(text.getText());
            text.setText("");
            sub = true;

        }
        if (source == butMultiply) {
            number1 = Double.parseDouble(text.getText());
            text.setText("");
            multi = true;

        }
        if (source == butDivide) {
            number1 = Double.parseDouble(text.getText());
            text.setText("");
            div = true;

        }
        if (source == butSquare) {
            number1 = Double.parseDouble(text.getText());
            result = number1 * number1;
            String anser = String.format("%.2f", result);
            text.setText(anser);
            square = true;

        }
        if (source == butSquareRoot) {
            number1 = Double.parseDouble(text.getText());
            result = Math.sqrt(number1);
            String anser = String.format("%.2f", result);
            text.setText(anser);
            squareR = true;

        }

        if (source == butEqual) {
            String anser;
            number2 = Double.parseDouble(text.getText());
            if (add) {
                result = number1 + number2;
                anser = String.format("%.2f", result);
                text.setText(anser);
                add = false;
            }
            if (sub) {
                result = number1 - number2;
                anser = String.format("%.2f", result);
                text.setText(anser);
                sub = false;
            }
            if (multi) {
                result = number1 * number2;
                anser = String.format("%.2f", result);
                text.setText(anser);
                multi = false;
            }
            try {
                if (div) {
                    result = number1 / number2;
                    anser = String.format("%.2f", result);
                    text.setText(anser);
                    div = false;

                }
            } catch (Exception e1) {

            }

        }

        if (source == butCancle) {
            text.setText("");

        }
        if (source == butBackSpace) {
            String backSpace = null;
            if (text.getText().length() > 0) {
                StringBuilder strB = new StringBuilder(text.getText());
                strB.deleteCharAt(text.getText().length() - 1);
                backSpace = strB.toString();
                text.setText(backSpace);
            }
        }
        if (source == butDode) {
            text.append(".");

        }

    }
}
