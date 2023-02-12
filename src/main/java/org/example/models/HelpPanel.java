package org.example.models;
import java.awt.*;
import java.awt.event.*;

public class HelpPanel extends Panel{
    public  Label L;
    public TextArea TxtA;
    public HelpPanel(int x, int y, int W, int H){
        setBackground(Color.LIGHT_GRAY);
        setBounds(x,y,W,H);
        setLayout(null);
        L = new Label("Справка",Label.CENTER);
        L.setBounds(0,0,W,20);
        add(L);
        TxtA = new TextArea(" График функции y(x)=(1+sin(x))/(1+|x|)");
        TxtA.setFont(new Font("Serif",Font.PLAIN,15));
        TxtA.setBounds(5,20,W-10,60);
        TxtA.setEditable(false); // область недоступна для редактирования
        add(TxtA);
    }
}
