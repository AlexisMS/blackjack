import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Aplicacao implements ActionListener {
  JLabel r;
  JButton b;
  JButton end;
  JPanel tela;
  Player player;
  Dealer dealer;
  boolean first = true;
  //ArrayList<String> playerhand = new ArrayList<String>();
  
  
  Aplicacao(JLabel r, JButton b, JButton end, JPanel tela, Player player, Dealer dealer) {
    this.r = r;
    this.b = b;
    this.tela = tela;
    this.player = player;
    this.dealer = dealer;
    this.end = end;
  }
  
  private void deckcheck(ArrayList deck){ //DEBUG ONLY
    for(int i=0; i<deck.size(); i++ ){
      System.out.println(deck.get(i));
    }
   System.out.println("===");
   System.out.println(deck.size());
   System.out.println("===");
  }
  
  public void actionPerformed(ActionEvent e) {
    if (first){
    //JButton end;
    tela.add(end, BorderLayout.PAGE_START);
    end.addActionListener(new EndGame(r,b,end,tela,player,dealer)); //sets up the stop button
    first = false;
    }

    dealer.drawCard();
    player.receiveCard(dealer.giveCard());
    //this.deckcheck(deck);//DEBUG ONLY

    r.setText(String.valueOf(player.calcScore()) + " : " + player.getHand()); // shows the player score and hand
    b.setText("HIT ME");

    //checks for win/lose conditions that doesn't require checking the dealer's hand
    if (player.calcScore() == 21){
     r.setText("YOU WIN [score: " + String.valueOf(player.calcScore()) + "]");
     tela.remove(end);
     tela.remove(b);     
    } else if (player.calcScore() > 21){
     r.setText("YOU LOSE [score: " + String.valueOf(player.calcScore()) + "]");
     tela.remove(end);
     tela.remove(b);
    }

    tela.repaint();
  }

}
