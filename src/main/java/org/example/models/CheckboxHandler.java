package org.example.models;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;

public class CheckboxHandler implements ItemListener{
    private Choice ch;
    public CheckboxHandler(ButtonPanel P){
        this.ch = P.Chc;
    }
    public void itemStateChanged(ItemEvent ie){
        ch.setEnabled(ie.getStateChange() == ItemEvent.SELECTED);
    }
}
