import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import acm.*;

class Main {

  public static void main(String[] args) {

    JFrame f;
    f = new JFrame();
    JPanel tela;
    tela = new JPanel();
    f.setContentPane(tela);
    configTela(tela);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(800,600); //lar x alt
    //f.pack();
    f.setVisible(true);
  }

  static void configTela(JPanel tela) {
  	JPanel playarea = new JPanel();
  	playarea.setLayout(new BorderLayout(10,10));

    JLabel r=new JLabel("BLACKJACK", SwingConstants.CENTER);
    r.setVerticalAlignment(SwingConstants.BOTTOM);

    JPanel buttons = new JPanel();
    JPanel centerhand = new JPanel();
    JLabel card1 = new JLabel();
    JLabel card2 = new JLabel();
    JLabel card3 = new JLabel();
    JLabel card4 = new JLabel();
    JLabel card5 = new JLabel();

    JButton b;
    JLabel left = new JLabel("DEALER");
    JLabel right = new JLabel("YOU");
    JButton end = new JButton("STAHP");
    Player player = new Player();
    Dealer dealer = new Dealer();
    tela.setLayout(new BorderLayout(10,10));
    tela.add(playarea,BorderLayout.CENTER);
    playarea.add(r,BorderLayout.CENTER);
    playarea.add(centerhand,BorderLayout.PAGE_END);
    centerhand.add(card1);
    centerhand.add(card2);
    centerhand.add(card3);
    centerhand.add(card4);
    centerhand.add(card5);
    tela.add(buttons,BorderLayout.PAGE_END);
    buttons.add(b=new JButton("play"));
    b.addActionListener(new Aplicacao(buttons,card1,card2,card3,card4,card5,left,right,r,b,end,tela,player,dealer));
  } 
}