package org.example.models;
import java.awt.*;
import java.awt.event.*;

public class PlotPanel extends Panel{
    public Plotter G;
    class Plotter{ // Внутренний класс для реализации графика
        private double Xmin = 0, Xmax, Ymin = 0, Ymax=1.0;
        private boolean status; // состояние опции отображения сетки
        private Color clr; // цвет графика
        private Color gClr; // цвет линии сетки
        Plotter(ButtonPanel P){
            try{
                Xmax = Double.parseDouble(P.TxtFld.getText());
            }
            catch (NumberFormatException e){
                P.TxtFld.setText("10");
                Xmax = 10;
            }
            status = P.Cbx[3].getState();
            switch (P.Chc.getSelectedIndex()){
                case 0:
                    gClr = Color.GREEN;
                    break;
                case 1:
                    gClr = Color.YELLOW;
                    break;
                default:
                    gClr = Color.GRAY;
            }
            String name = P.CbxGrp.getSelectedCheckbox().getLabel();// цвет линии графика
            if(name.equalsIgnoreCase(" красный ")){
                clr = Color.RED;
            } else{
                if(name.equalsIgnoreCase(" синий ")){
                    clr = Color.BLUE;
                }else{
                    clr = Color.BLACK;
                }
            }
            // стр 445, после Цвета линии графика
        }

    }
}
