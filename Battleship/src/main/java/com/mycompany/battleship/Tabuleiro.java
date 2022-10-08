
package com.mycompany.battleship;

import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author jfza
 */
public class Tabuleiro extends javax.swing.JFrame {
    Gameboard jPanel1, jPanel2;
    boolean faseDeEscolha = true;
    boolean gameFinished = false;
    int id, comprimento;
    HashMap<Integer, Integer> naviosPosicionados;
    int naviosLeft1, naviosLeft2;
    ChecaWin manager;
    boolean waitIA;
    
    public Tabuleiro() {
        super("Battleship");
        naviosPosicionados = new HashMap<Integer, Integer>();
        naviosPosicionados.put(5, 1);
        naviosPosicionados.put(4, 2);
        naviosPosicionados.put(3, 3);
        naviosPosicionados.put(2, 4);
        initComponents();
        
        manager = new ChecaWin();
        Thread checa = new Thread(manager);
        checa.start();
        
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabuleiro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //setVisible(true);
            }
        });*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
        jPanel1 = new Gameboard(10);
        jPanel2 = new Gameboard(10);
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
                
        jLabel1.setText("Posição: ");
        jTextField1.setText("");
        jButton1.setText("Enter");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("FASE DE ESCOLHAS \n \nInsira no espaço ao lado, a posição \ndo navio e seu sentido(h ou v)\nExemplo: J-5-h");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(14, 14, 14)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    public void jButton1MouseClicked(MouseEvent e){
        waitIA = false;
        
        if(naviosLeft1 >= 30){
            gameFinished = true;
        }
        if(naviosLeft2 >= 30){
            gameFinished = true;
        }
        
        
        if (faseDeEscolha){
            int positionX = getPositionX(jTextField1.getText());
            int positionY = getPositionY(jTextField1.getText());
            boolean sentido = isHorizontal(jTextField1.getText());
            for (int set:naviosPosicionados.keySet()){
                if (naviosPosicionados.get(set) > 0){
                    placeShip(positionX, positionY, set, sentido);
                    naviosPosicionados.put(set, naviosPosicionados.get(set) - 1);
                    if (!waitIA){
                        IAplaceShip(set);
                        jTextArea1.setText("FASE DE ESCOLHAS \n \nInsira no espaço ao lado, a posição \ndo navio e seu sentido(h ou v)\nExemplo: J-5-h");
                        break;
                    }
                }
            }
        
        } else if (!gameFinished){
            int positionX = getPositionX(jTextField1.getText());
            int positionY = getPositionY(jTextField1.getText());
            try{
                if(!jPanel2.board[positionX][positionY].getFoiAtingido()){
                    jPanel2.board[positionX][positionY].Chosen();
                } else {
                    jTextArea1.setText("FASE DE ESCOLHAS\n \nAlvo inválido!");
                }
            } catch(java.lang.ArrayIndexOutOfBoundsException excep){
                jTextArea1.setText("FASE DE ESCOLHAS\n \nAlvo inválido!");
            } 

            IAPlays();
            if (jPanel2.board[positionX][positionY].isTemNavio() && !gameFinished){
                jTextArea1.setText("FASE DE BATALHA\n \nAlvo atingido!");
                naviosLeft2 += 1;
            } else if (!jPanel2.board[positionX][positionY].isTemNavio() && !gameFinished){
                jTextArea1.setText("FASE DE BATALHA\n \nErrou.\nTente explorar mais o mapa!");
            }
        } else if (gameFinished && naviosLeft1 >= 30){
            jTextArea1.setText("JOGO TERMINADO\n \nPLAYER 2 GANHOU!");
        } else if (gameFinished && naviosLeft2 >= 30){
            jTextArea1.setText("JOGO TERMINADO\n \nPLAYER 1 GANHOU!");
        }
        int u = 0;
        for(int q: naviosPosicionados.values()){
            u += q;  
        }
        if(u == 0 && !gameFinished){
            faseDeEscolha = false;
            jTextArea1.setText("FASE DE BATALHA");
        }
    }
    public void placeShip(int posX, int posY, int type, boolean h){
        try {
            if (!h) {
                for (int x = posX; x < posX + type; x++) {
                    if(jPanel1.board[x][posY].isTemNavio()){
                        clearPlace(x, posX, posY, type, h);
                        jTextArea1.setText("FASE DE ESCOLHAS\n \nAlvo inválido! Escolha outra posição.");
                        waitIA = true;
                        break;
                    } else {
                        jPanel1.board[x][posY].setText("N");
                        jPanel1.board[x][posY].setTemNavio(true);
                    }
                    
                }
            } else {
                for (int y = posY; y < posY + type; y++) {
                    if(jPanel1.board[posX][y].isTemNavio()){
                        clearPlace(y, posX, posY, type, h);
                        
                        break;
                    } else {
                        jPanel1.board[posX][y].setText("N");
                        jPanel1.board[posX][y].setTemNavio(true);
                    }
                }
            }
            
        } catch(java.lang.ArrayIndexOutOfBoundsException e){
            jTextField1.setText("FASE DE ESCOLHAS\n \nAlvo inválido!");
        }
    }
    
    public void clearPlace(int x, int posX, int posY, int type, boolean h){
        naviosPosicionados.put(type, naviosPosicionados.get(type) + 1);
        if(!h){
            for(int clear = posX; clear < x; clear++){
                jPanel1.board[clear][posY].setText("~");
                jPanel1.board[clear][posY].setTemNavio(false);
                
            }
        } else {
            for(int clear = posY; clear < x; clear++){
                jPanel1.board[posX][clear].setText("~");
                jPanel1.board[posX][clear].setTemNavio(false);
                
            }
        }
    }
    
    public void IAplaceShip(int type){
        Random rand = new Random();
        int randX = rand.nextInt(1, 11);
        int randY = rand.nextInt(1, 11);
        boolean horizontal = rand.nextBoolean();
       try{ 
            if (!horizontal) {
                for (int x = randX; x < randX + type; x++) {
                    if(jPanel2.board[x][randY].isTemNavio()){
                        for(int clear = x; clear > randY + type; clear--){
                            jPanel2.board[clear][randY].setText("~");
                            jPanel2.board[clear][randY].setTemNavio(false);
                        }
                        break;
                    } else {
                        jPanel2.board[x][randY].setText("N");
                        jPanel2.board[x][randY].setTemNavio(true);
                    }
                }

            } else {
                for (int y = randY; y < randY + type; y++) {
                    jPanel2.board[randX][y].setText("N");
                    jPanel2.board[randX][y].setTemNavio(true);
                }
            }
       } catch(java.lang.ArrayIndexOutOfBoundsException e){
            
       }
    }
    
   
    public void IAPlays(){
        Random rand = new Random();
        int randX = rand.nextInt(1, 11);
        int randY = rand.nextInt(1, 11);
        try{
            if(!jPanel1.board[randX][randY].foiAtingido){
                    jPanel1.board[randX][randY].Chosen();
                    naviosLeft1 += 1;
                } else {
                    IAPlays();
                }
        } catch(java.lang.ArrayIndexOutOfBoundsException e){
            
        }
    }
     public int getPositionY(String pos){
        String[] parts = pos.split("-");
         if (parts[0].equalsIgnoreCase("A")){
            return 1;
        } else if (parts[0].equalsIgnoreCase("B")){
            return 2;
        } else if (parts[0].equalsIgnoreCase("C")){
            return 3;
        } else if (parts[0].equalsIgnoreCase("D")){
            return 4;
        } else if (parts[0].equalsIgnoreCase("E")){
            return 5;
        } else if (parts[0].equalsIgnoreCase("F")){
            return 6;
        } else if (parts[0].equalsIgnoreCase("G")){
            return 7;
        } else if (parts[0].equalsIgnoreCase("H")){
            return 8;
        } else if (parts[0].equalsIgnoreCase("I")){
            return 9;
        } else if (parts[0].equalsIgnoreCase("J")){
            return 10;
        } else {
            return 0;
        }
        
    }
    public int getPositionX(String pos){
        String[] parts = pos.split("-");
       
        return Integer.valueOf(parts[1]);
    }
    public boolean isHorizontal(String pos) {
        String[] parts = pos.split("-");
        return parts[2].equalsIgnoreCase("h");
    }
    

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea jTextArea1;
    // End of variables declaration                   
}