package org.example.models;
import org.example.models.ButtonPanel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
        ButtonPanel BtnPnl = new ButtonPanel(6,25,W/4,H-30);
        add(BtnPnl);
        PlotPanel PltPnl = new PlotPanel(W/4+10,25,3*W/4-15,H-120,BtnPnl);
        add(PltPnl);
        HelpPanel HlpPnl = new HelpPanel(W/4+10,H-90,3*W/4-15,85);
        add(HlpPnl);
        addWindowFocusListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        BtnPnl.B1.addActionListener(new ButtonOneHandler(BtnPnl,PltPnl));
        BtnPnl.B2.addActionListener(new ButtonTwoHandler());
        BtnPnl.Cbx[3].addItemListener(new CheckboxHandler(BtnPnl));
        setVisible(true);

    }
}
