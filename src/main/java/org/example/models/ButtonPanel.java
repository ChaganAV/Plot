package org.example.models;
import java.awt.*;
import java.awt.event.*;

public class ButtonPanel extends Panel{
    public Label[] L;
    public CheckboxGroup CbxGrp;
    public Checkbox[] Cbx;
    public Choice Chc; // раскрывающийся список
    public TextField TxtFld;
    public Button B1, B2;
    public ButtonPanel(int x, int y, int W, int H){
        setLayout(null);
        setBounds(x,y,W,H);
        setBackground(Color.LIGHT_GRAY);
        L = new Label[3];
        L[0] = new Label("Выбор цвета: ",Label.CENTER);
        L[0].setFont(new Font("Arial",Font.BOLD,12));
        L[0].setBounds(5,5,getWidth()-10,30);// Размеры метки
        add(L[0]);
        CbxGrp = new CheckboxGroup();
        Cbx = new Checkbox[4];
        Cbx[0] = new Checkbox(" красный ",CbxGrp,true);
        Cbx[1] = new Checkbox(" синий ",CbxGrp,false);
        Cbx[2] = new Checkbox(" черный ",CbxGrp, false);
        Cbx[3] = new Checkbox(" Сетка ", true);
        for(int i=0; i<4; i++){
            Cbx[i].setBounds(5,30+i*25,getWidth()-10,30);
            add(Cbx[i]);
        }
        Chc = new Choice(); // Раскрывающийся список для определения цвета сетки
        Chc.add("Зеленый");
        Chc.add("Желтый");
        Chc.add("Серый");
        Chc.setBounds(20,140,getWidth()-25,30); // Размеры и положение
        add(Chc);

        L[1] = new Label("Интервал по x: ",Label.CENTER);
        L[1].setFont(new Font("Arial",Font.BOLD,12));
        L[1].setBounds(5,220,getWidth()-10,30);
        add(L[1]);

        L[2] = new Label("От x=0 до x=", Label.LEFT);
        L[2].setBounds(5,250,70,20);
        add(L[2]);
        TxtFld = new TextField("10"); // Поле для ввода верхней границы диапазона
        TxtFld.setBounds(75,250,45,20);
        add(TxtFld);
        B1 = new Button("Нарисовать");
        B2 = new Button("Закрыть");
        B1.setBounds(5,getHeight()-75,getWidth()-10,30);
        B2.setBounds(5,getHeight()-35,getWidth()-10,30);
        add(B1);
        add(B2);
    }
}
