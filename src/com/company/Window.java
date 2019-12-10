package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

class Window extends JFrame {
    HashMap<String, String> data = EquationGenerator.generateEquation();

    JLabel res1 = new JLabel(data.get("result1"));
    JLabel res2 = new JLabel(data.get("result2"));
    JLabel res3 = new JLabel(data.get("result3"));
    JLabel res4 = new JLabel(data.get("result4"));

    int round = 1;
    int score = 0;
    JLabel fake = new JLabel("12345");
    JLabel fakeEq = new JLabel("dsaijadsjadssssssssssssssssssadsjasdjnadsnj");
    JLabel equation = new JLabel(data.get("equation"), SwingConstants.CENTER);
    Dimension size = fake.getPreferredSize();
    Dimension equationSize = fakeEq.getPreferredSize();
    Game panel = new Game();
    Container cp = getContentPane();
    int height = 100;
    Timer timer = new Timer(1, null);

    public Window() {
//        cp.add(rect);
        cp.add(panel);
        res1.setForeground(Color.WHITE);
        res2.setForeground(Color.WHITE);
        res3.setForeground(Color.WHITE);
        res4.setForeground(Color.WHITE);
        equation.setForeground(Color.WHITE);
        res1.setFont(new Font("Serif", Font.BOLD, 22));
        res2.setFont(new Font("Serif", Font.BOLD, 22));
        res3.setFont(new Font("Serif", Font.BOLD, 22));
        res4.setFont(new Font("Serif", Font.BOLD, 22));
        fakeEq.setFont(new Font("Serif", Font.BOLD, 22));
        fake.setFont(new Font("Serif", Font.BOLD, 22));
        equation.setFont(new Font("Serif", Font.BOLD, 22));
        size = fake.getPreferredSize();
        equationSize = fakeEq.getPreferredSize();
        res1.setBounds(100, height, size.width, size.height);
        res2.setBounds(300, height, size.width, size.height);
        res3.setBounds(500, height, size.width, size.height);
        res4.setBounds(700, height, size.width, size.height);
        equation.setBounds(400 - (equationSize.width / 2), 15, equationSize.width, equationSize.height);
//        rect.setBounds(0, 550, 800, 30);
        panel.setLayout(null);
        panel.add(res1);
        panel.add(res2);
        panel.add(res3);
        panel.add(res4);
        panel.add(equation);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        res1.setBounds(100, 100, size.width, size.height);
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (round < 4) {
                    height += 1;
                } else if (round < 8) {
                    height += 2;
                } else if (round < 11) {
                    height += 4;

                }
                res1.setBounds(100, height, size.width, size.height);
                res2.setBounds(300, height, size.width, size.height);
                res3.setBounds(500, height, size.width, size.height);
                res4.setBounds(700, height, size.width, size.height);
                if (round == 11) {
                    timer.stop();
                }
                if (height == 540 && res1.getX() + size.width >= panel.x && res1.getX() <= panel.x + 100) {
                    height = 20;
                    res1.setBounds(100, height, size.width, size.height);
                    res2.setBounds(300, height, size.width, size.height);
                    res3.setBounds(500, height, size.width, size.height);
                    res4.setBounds(700, height, size.width, size.height);

                    if (data.get("result1").equals(data.get("score"))) {
                        System.out.println("trafiony 1");
                        score++;
                        panel.changeColorSuccess();
                    } else {
                        panel.changeColorFail();
                    }
                    nextRound();
                } else if (height == 540 && res2.getX() + size.width >= panel.x && res2.getX() <= panel.x + 100) {
                    height = 20;
                    res1.setBounds(100, height, size.width, size.height);
                    res2.setBounds(300, height, size.width, size.height);
                    res3.setBounds(500, height, size.width, size.height);
                    res4.setBounds(700, height, size.width, size.height);
                    if (data.get("result2").equals(data.get("score"))) {
                        System.out.println("trafiony 2");
                        score++;
                        panel.changeColorSuccess();
                    } else {
                        panel.changeColorFail();
                    }
                    nextRound();
                } else if (height == 540 && res3.getX() + size.width >= panel.x && res3.getX() <= panel.x + 100) {
                    height = 20;
                    res1.setBounds(100, height, size.width, size.height);
                    res2.setBounds(300, height, size.width, size.height);
                    res3.setBounds(500, height, size.width, size.height);
                    res4.setBounds(700, height, size.width, size.height);
                    if (data.get("result3").equals(data.get("score"))) {
                        System.out.println("trafiony 3");
                        score++;
                        panel.changeColorSuccess();
                    } else {
                        panel.changeColorFail();
                    }
                    nextRound();
                } else if (height == 540 && res4.getX() + size.width >= panel.x && res4.getX() <= panel.x + 100) {
                    height = 20;
                    res1.setBounds(100, height, size.width, size.height);
                    res2.setBounds(300, height, size.width, size.height);
                    res3.setBounds(500, height, size.width, size.height);
                    res4.setBounds(700, height, size.width, size.height);
                    if (data.get("result4").equals(data.get("score"))) {
                        System.out.println("trafiony 4");
                        score++;
                        panel.changeColorSuccess();
                    } else {
                        panel.changeColorFail();
                    }
                    nextRound();
                }
                if (height == 540) {
                    nextRound();
                }
            }
        };


        timer = new Timer(15, taskPerformer);
        timer.start();


    }

    private void nextRound() {
        if (round == 10) {
            timer.stop();
            JOptionPane.showMessageDialog(null, "Your score is " + score + "/" + round);
        } else {
            data = EquationGenerator.generateEquation();
            equation.setText(data.get("equation"));
            res1.setText(data.get("result1"));
            res2.setText(data.get("result2"));
            res3.setText(data.get("result3"));
            res4.setText(data.get("result4"));
            round++;
            height = 20;
            res1.setBounds(100, height, size.width, size.height);
            res2.setBounds(300, height, size.width, size.height);
            res3.setBounds(500, height, size.width, size.height);
            res4.setBounds(700, height, size.width, size.height);
        }
    }
}