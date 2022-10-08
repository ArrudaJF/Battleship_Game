/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.battleship;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author jfza
 */
public final class Gameboard extends JPanel{
    Tile[][] board;
    boolean turn;


    Gameboard(int comprimento) {
        setPreferredSize(new Dimension(164, 164));
        setLayout(new GridLayout(comprimento + 1, comprimento + 1));
        
        board = new Tile[comprimento + 1][comprimento + 1];
        fillBoard(board, comprimento);
    }
    
    public void fillBoard(Tile[][] board, int comprimento){
        for (int i = 0; i < comprimento + 1; i++){
            if (i == 0){
                for(int j = 0; j < comprimento + 1; j++){
                    board[i][j] = new Tile();
                    
                    if (j == 0){
                        board[i][j].setText("-");
                    }
                    if (j == 1){
                        board[i][j].setText("A");
                    }
                    if (j == 2){
                        board[i][j].setText("B");
                    }
                    if (j == 3){
                        board[i][j].setText("C");
                    }
                    if (j == 4){
                        board[i][j].setText("D");
                    }
                    if (j == 5){
                        board[i][j].setText("E");
                    }
                    if (j == 6){
                        board[i][j].setText("F");
                    }
                    if (j == 7){
                        board[i][j].setText("G");
                    }
                    if (j == 8){
                        board[i][j].setText("H");
                    }
                    if (j == 9){
                        board[i][j].setText("I");
                    }
                    if (j == 10){
                        board[i][j].setText("J");
                    }
                    board[i][j].setFoiAtingido(true);
                    add(board[i][j]);
                }
            } else {
                for(int j = 0; j < comprimento + 1; j++){
                   
                    board[i][j] = new Tile();
                    board[i][j].setText("~");
                    
                    if (j == 0){
                        board[i][j].setText(String.valueOf(i));
                        board[i][j].setFoiAtingido(true);
                    }
                    add(board[i][j]);
                    
                }
            }
        }
    }
    
  
}
