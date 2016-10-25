import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Aplicacao implements ActionListener {
  JLabel left;
  JLabel right;
  JLabel r;
  JButton b;
  JButton end;
  JPanel tela;
  Player player;
  Dealer dealer;
  boolean first = true;


  JLabel card1;
  JLabel card2;
  JLabel card3;
  JLabel card4;
  JLabel card5;
  private int currentcard = 0;
  
  Aplicacao(JLabel card1, JLabel card2, JLabel card3, JLabel card4, JLabel card5, JLabel left, JLabel right, JLabel r, JButton b, JButton end, JPanel tela, Player player, Dealer dealer) {
    this.left = left;
    this.right = right;
    this.r = r;
    this.b = b;
    this.tela = tela;
    this.player = player;
    this.dealer = dealer;
    this.end = end;
    this.card1 = card1;
    this.card2 = card2;
    this.card3 = card3;
    this.card4 = card4;
    this.card5 = card5;
  }
    
  public void actionPerformed(ActionEvent e) {
    if(player.getStatus()){
      first = true;
      player.setStatus(false);
    }

    if (first){
    //JButton end;
    tela.add(end, BorderLayout.PAGE_START);
    end.addActionListener(new EndGame(card1,card2,card3,card4,card5,left,right,r,b,end,tela,player,dealer)); //sets up the stop button
    first = false;
    currentcard = 0;
    card1.setIcon(null);
	card2.setIcon(null);
	card3.setIcon(null);
	card4.setIcon(null);
	card5.setIcon(null);
    player.reset();
    dealer.reset();
    left.setText(" ");
    right.setText(" ");
    //tela.remove(left);
    //tela.remove(right);
    }

    dealer.drawCard();
    player.receiveCard(dealer.giveCard());
    //dealer.deckcheck();//DEBUG ONLY

    r.setText(String.valueOf(player.calcScore())); // shows the player score

    ImageIcon imagem = new ImageIcon("img/" + player.hand.get(currentcard) + ".png");
    currentcard++;
	switch(currentcard){
		case 0:
			card1.setIcon(imagem);
			break;
		case 1:
			card2.setIcon(imagem);
			break;
		case 2:
			card3.setIcon(imagem);
			break;
		case 3:
			card4.setIcon(imagem);
			break;
		case 4:
			card5.setIcon(imagem);
			break;
		default:
			break;
	}
    b.setText("HIT ME");

    //checks for win/lose conditions that doesn't require checking the dealer's hand
    if (player.calcScore() == 21){
     r.setText("YOU WIN [score: " + String.valueOf(player.calcScore()) + "]");
     tela.remove(end);
     //tela.remove(b); 
     b.setText("Play again?");
     player.setStatus(true);    
    } else if (player.calcScore() > 21){
     r.setText("YOU LOSE [score: " + String.valueOf(player.calcScore()) + "]");
     tela.remove(end);
     //tela.remove(b);
     b.setText("Play again?");
     player.setStatus(true);
    }

    tela.repaint();
  }

}