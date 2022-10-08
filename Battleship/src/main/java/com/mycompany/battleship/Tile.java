/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.battleship;

import javax.swing.JLabel;

/**
 *
 * @author jfza
 */
public class Tile extends JLabel{
    boolean foiAtingido, temNavio;
    int type;
    
    public Tile(){
        this.setText("~");
    }
    
    public void Chosen(){
        if(!temNavio){
            setText("O");
        } else {
            setText("X");
        }
        foiAtingido = true;
    }
    
    
    
    public void setFoiAtingido(boolean t){
        foiAtingido = t;
    }
    public boolean getFoiAtingido() {
        return foiAtingido;
    }

    public boolean isTemNavio() {
        return temNavio;
    }

    public void setTemNavio(boolean temNavio) {
        this.temNavio = temNavio;
    }
    
}
