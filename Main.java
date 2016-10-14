import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {

  public static void main(String[] args) {

    JFrame f;
    f = new JFrame();
    JPanel tela;
    tela = new JPanel();
    f.setContentPane(tela);
    configTela(tela);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(500,400); //lar x alt
    //f.pack();
    f.setVisible(true);
  }

  static void configTela(JPanel tela) {
    JLabel r;
    JButton b;
    JButton end = new JButton("STAHP");
    Player player = new Player();
    Dealer dealer = new Dealer();
    tela.setLayout(new BorderLayout(10,10));
    tela.add(r=new JLabel("BLACKJACK", SwingConstants.CENTER),BorderLayout.CENTER);
    tela.add(b=new JButton("play"),BorderLayout.PAGE_END);
    b.addActionListener(new Aplicacao(r,b,end,tela,player,dealer));
  } 
}
