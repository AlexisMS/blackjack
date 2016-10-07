import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Aplicacao implements ActionListener {
  JLabel r;
  JButton b;
  JPanel tela;
  Player player;
  Dealer dealer;
  //ArrayList<String> playerhand = new ArrayList<String>();
  
  
  Aplicacao(JLabel r, JButton b, JPanel tela, Player player, Dealer dealer) {
    this.r = r;
    this.b = b;
    this.tela = tela;
    this.player = player;
    this.dealer = dealer;
  }
  
  private void deckcheck(ArrayList deck){
    for(int i=0; i<deck.size(); i++ ){
      System.out.println(deck.get(i));
    }
   System.out.println("===");
   System.out.println(deck.size());
   System.out.println("===");
  }
  
  public void actionPerformed(ActionEvent e) {
    JButton end;
    tela.add(end = new JButton("STAHP"), BorderLayout.PAGE_START);
    end.addActionListener(new EndGame(r,b,end,tela,player,dealer));
    dealer.drawCard();
    player.receiveCard(dealer.giveCard());                             //adds the card to the player's hand
    //this.deckcheck(deck);//DEBUG ONLY
    r.setText(String.valueOf(player.calcScore()) + " : " + player.getHand());
    b.setText("HIT ME");
    if (player.calcScore() == 21){
     r.setText("YOU WIN");
     tela.remove(b);
     tela.remove(end);
    } else if (player.calcScore() > 21){
     r.setText("YOU LOSE");
     tela.remove(b);
     tela.remove(end);
    }
    tela.repaint();

  }

}