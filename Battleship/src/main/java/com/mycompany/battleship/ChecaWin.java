/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.battleship;

/**
 *
 * @author jfza
 */
public class ChecaWin implements Runnable{
    int naviosLeft1, naviosLeft2;
    boolean gameFinished;
    @Override
    public void run(){
            
            if(naviosLeft1 >= 30){
                gameFinished = true;
                Thread.currentThread().interrupt();
            }
            if(naviosLeft2 >= 30){
                gameFinished = true;
                Thread.currentThread().interrupt();
            }
            
    }
}
