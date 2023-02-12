package org.example.models;
import org.example.models.ButtonPanel;

import java.awt.*;

public class PlotFrame extends Frame{
    public PlotFrame(int H, int W){
        setTitle("График функции");
        setBounds(100,50,W,H); // положение и размеры окна
        setBackground(Color.GRAY);
        setLayout(null); // отключение менеджера компоновки
        Font f = new Font("Arial",Font.BOLD,11);
        setFont(f);
        setResizable(false); // окно фиксированных размеров
        setIconImage(getToolkit().getImage("D:\\Code\\Java\\Plot\\Plot.icon.png"));
        ButtonPanel btnPnl = new ButtonPanel(6,25,W/4,H-30);
        add(btnPnl);
    }
}
