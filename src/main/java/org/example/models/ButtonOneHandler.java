package org.example.models;
import java.awt.*;
import java.awt.event.*;

public class ButtonOneHandler implements ActionListener{
    private ButtonPanel BP;
    private PlotPanel PP;
    public ButtonOneHandler(ButtonPanel bp, PlotPanel pp){
        this.BP = bp;
        this.PP = pp;
    }
    public void actionPerformed(ActionEvent ae){ // обработка нажатия кнопки
        PP.G = PP.G.remember(BP);
        PP.G.plot(PP.getGraphics());
    }
}
