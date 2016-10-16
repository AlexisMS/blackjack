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
  
  
  Aplicacao(JLabel r, JButton b, JButton end, JPanel tela, Player player, Dealer dealer) {
    this.r = r;
    this.b = b;
    this.tela = tela;
    this.player = player;
    this.dealer = dealer;
    this.end = end;
  }
    
  public void actionPerformed(ActionEvent e) {
    if(player.getStatus()){
      first = true;
      player.setStatus(false);
      
    }

    if (first){
    //JButton end;
    tela.add(end, BorderLayout.PAGE_START);
    end.addActionListener(new EndGame(r,b,end,tela,player,dealer)); //sets up the stop button
    first = false;
    player.reset();
    dealer.reset();
    b.setText("HIT ME");
    }

    dealer.drawCard();
    player.receiveCard(dealer.giveCard());
    //dealer.deckcheck();//DEBUG ONLY

    r.setText(String.valueOf(player.calcScore()) + " : " + player.getHand()); // shows the player score and hand
    

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