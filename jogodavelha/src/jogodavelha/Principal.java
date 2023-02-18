package jogodavelha;

import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JOptionPane;


public class Principal extends javax.swing.JFrame {
 //Variáveis   
    int qtde;
    int jogador;
    int C;
    int L;
    int mat[][] = new int [3][3];  //Matriz Posição
    int Bot[] =new int[8];
    
    JButton b[] = new JButton[9]; //Vetor Botão
    JButton Mec[][] = new JButton[3][3]; //Vetor Botão
    
    String ganhador;
    String jogador1;
    String jogador2;
    String escolha;
    String[] poss={"Multiplayer","Solo"};
    String jg; 
    
    Random v = new Random();
    Scanner sc = new Scanner(System.in);

    public Principal() {
        C=0;
        initComponents();
        escolha = (String)JOptionPane.showInputDialog(null,"Modo de jogo","Modos",JOptionPane.QUESTION_MESSAGE, null,poss,poss[0] );
        jogador1=JOptionPane.showInputDialog(null,"Insira o nome do jogador");
        jogador2="Bot";
        
        if(escolha == "Multiplayer"){
            jogador2 = JOptionPane.showInputDialog(null,"insira o nome do jogador 2");  
        }
        
        jogador  = 1;
        jg= "";
        
        qtde = 1;
        
        Mec[0][0]= bt0;
        Mec[0][1]= bt1;
        Mec[0][2]= bt2;
        Mec[1][0]= bt3;
        Mec[1][1]= bt4;
        Mec[1][2]= bt5;
        Mec[2][0]= bt6;
        Mec[2][1]= bt7;
        Mec[2][2]= bt8;          
    }
    

    public void jogada (JButton b, int x, int y){
       b.setEnabled(false);
       //Funcionalidade de cada jogar.
        if(escolha == "Multiplayer"){
            if(jogador == 1){
                mat[x][y]=1;
                b.setText("X");
                jogador=2;
                checarjogada(1);
                qtde++;
                empate();
                jg = jogador2; 
            }
       
        else {
            mat[x][y]=2;
            b.setText("O");
            jogador=1;      
            checarjogada(2);
            qtde++;
            empate();
            jg  = jogador1; 
            }
        }
        
        if(escolha=="Solo"){ 
            if(jogador == 1){
                mat[x][y]=1;
                b.setText("X");
                checarjogada(1);
                qtde++;
                empate();
                jg = jogador2; 
                jogador=2;
            }
       
        if(jogador == 2){
           Robo();     
           checarjogada(2);
           qtde++;
           empate();
           jogador=1; 
           jg  = jogador1;
            }
        }
       //Continuar jogada//
    }
    
    //Checa cada jogada feita por jogador.
    public void checarjogada(int x){  
       
    if(vitoria(x)==true){
        JOptionPane.showMessageDialog(null,"Jogador: "+ jg + " Venceu! ");
        fimjogo();     
        for(int i=0;i<9;i++){
        b[i].setEnabled(true);
        b[i].setText("");
            }   
        }
    }
   
   
   public void Robo(){ //Funcionalidade do bot.
        
    int x = v.nextInt(3);
    int y = v.nextInt(3);
            
    if(Mec[x][y].isEnabled()){
        Mec[x][y].setText("O");
        Mec[x][y].setEnabled(false);
        mat[x][y]= 2; 
    }
    
    else{
        Robo();
    }
       
   }
   
    //Vitórias.
    public boolean vitoria(int x){
   
    //Posições de jogo.
    for(int i=0;i<mat.length;i++) {
        if(mat[1][0] == x && mat[1][1]== x && mat[1][2]==x){
            return true;
        }
        if(mat[1][1]== x && mat[2][1]== x && mat[0][1]==x){
            return true;
        }
        if(mat[0][0]== x && mat[1][0]== x && mat[2][0]==x){
            return true;
        }
        if(mat[0][2]== x && mat[1][2]== x && mat[2][2]==x){
            return true;
        }
        if(mat[0][0]== x && mat[0][1]== x && mat[0][2]==x){
            return true;
        }
        if(mat[2][0]== x && mat[2][1]== x && mat[2][2]==x){
            return true;
        }
        if(mat[0][0]== x && mat[1][1]== x && mat[2][2]==x){
            return true;
        }
        if(mat[0][2]== x && mat[1][1]== x && mat[2][0]==x){
            return true;
        }   
    }
    return false;
    }
   
   //Metódo empate.
    public boolean empate(){
      
       if(qtde == 10){
           JOptionPane.showMessageDialog(null,"Empate");
           fimjogo();
           return true;
       }  
    return false;
    }  
   
   //Termino.
    public void fimjogo(){
       qtde=1;
       for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                Mec[x][y].setEnabled(false);         
            }          
        }
    }
    
    //Reset do Jogo.
    public void limpar(){
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
            Mec[x][y].setEnabled(true);
            Mec[x][y].setText("");
            }
        }
        
        for(int x=0;x<3;x++){
            for(int y=0;y<3;y++){
                mat[x][y]=0;             
            }          
        }
        jogador=1;
        ganhador="";
    }

    @SuppressWarnings("unchecked")
                //Interface
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        bt0 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
      
        Limpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bt0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt0.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt0ActionPerformed(evt);
            }
        });

        bt1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });

        bt2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt2ActionPerformed(evt);
            }
        });

        bt3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt3ActionPerformed(evt);
            }
        });

        bt4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt4ActionPerformed(evt);
            }
        });

        bt5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt5ActionPerformed(evt);
            }
        });

        bt6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt6ActionPerformed(evt);
            }
        });

        bt7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt7ActionPerformed(evt);
            }
        });

        bt8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        bt8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        bt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt8ActionPerformed(evt);
            }
        });
        
        
        Limpar.setText("Jogar Novamente");
        Limpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Limpar)
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                           )))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                
                .addComponent(Limpar)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>                        

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        jogada(bt1,0,1);
    }                                   

    private void bt0ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        jogada(bt0,0,0);
    }                                   

    private void bt3ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        jogada(bt3,1,0);
    }                                   

    private void bt4ActionPerformed(java.awt.event.ActionEvent evt) {                                    
     jogada(bt4,1,1);
    }                                   

    private void bt5ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        jogada(bt5,1,2);
    }                                   

    private void bt6ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        jogada(bt6,2,0);
    }                                   

    private void bt7ActionPerformed(java.awt.event.ActionEvent evt) {                                    
     jogada(bt7,2,1);
    }                                   

    private void bt8ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        jogada(bt8,2,2);
    }                                   

    private void bt2ActionPerformed(java.awt.event.ActionEvent evt) {                                    
        jogada(bt2,0,2);
    }                                   

    private void LimparActionPerformed(java.awt.event.ActionEvent evt) {                                       
        limpar();
    }                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify                     
    private javax.swing.JButton Limpar;
    private javax.swing.JButton bt0;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
  
    private javax.swing.JPanel jPanel1;
    // End of variables declaration                   
}

