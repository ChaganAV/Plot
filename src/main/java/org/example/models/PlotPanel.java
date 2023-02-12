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
        }
        private double f(double x){
            return (1+Math.sin(x))/(1+Math.abs(x));
        }
        public Plotter remember(ButtonPanel P){// запоминает настройки
            return new Plotter(P);
        }
        public void plot(Graphics Fig){ // отображение графика и сетки
            int H,W,h,w,s = 20;
            W = getWidth();
            H = getHeight();
            h = H-2*s;
            w = W-2*s;
            Fig.clearRect(0,0,W,H);// очистка области графика
            int nums = 10;
            Fig.setColor(Color.BLACK);
            Fig.drawLine(s,s,s,h+s);
            Fig.drawLine(s,s+h,s+w,s+h);
            for(int k=0; k<=nums; k++) { // отображение засечек на координатных осях
                Fig.drawLine(s+k*w/nums,s+h,s+k*w/nums,s+h+5);
                Fig.drawLine(s-5,s+k*h/nums,s,s+k*h/nums);
                Fig.drawString(Double.toString(Xmin+k*(Xmax-Xmin)/nums),s+k*w/nums-5,s+h+15);
                Fig.drawString(Double.toString(Ymin+k*(Ymax-Ymin)/nums),s-17,s+h-1-k*h/nums);
            }
            if(status){ // отображение сетки
                Fig.setColor(gClr);
                for(int k = 1; k<=nums;k++){
                    Fig.drawLine(s+k*w/nums,s,s+k*w/nums,h+s);
                    Fig.drawLine(s,s+(k-1)*h/nums,s+w,s+(k-1)*h/nums);
                }
            }
            Fig.setColor(clr);
            double dx = (Xmax-Xmin)/w, dy = (Ymax-Ymin)/h; // масштаб на один пиксел по каждой из координат
            double x1,x2,y1,y2; // переменные для записи координат
            int h1,h2,w1,w2; // переменные координат в окне отображения графика
            x1 = Xmin;
            y1 = f(x1);
            w1 = s;
            h1 = h+s-(int)Math.round(y1/dy);
            int step = 5;
            for(int i = step; i <= w; i+=step){ // отображение
                x2 = i*dx;
                y2 = f(x2);
                w2 = s+(int)Math.round(x2/dx);
                h2 = h+s-(int)Math.round(y2/dy);
                Fig.drawLine(w1,h1,w2,h2); // линия
                Fig.drawRect(w1-2,h1-2,4,4); // Базовая точка (квадрат)
                // новые значения
                x1 = x2;
                y1 = y2;
                w1 = w2;
                h1 = h2;
            }
        }
    }
    public PlotPanel(int x, int y, int W, int H, ButtonPanel P){
        G = new Plotter(P);
        setBackground(Color.WHITE);
        setBounds(x,y,W,H);
    }
    public void paint(Graphics g){ // переопределение метода для перерисовки панели
        G.plot(g);
    }
}
