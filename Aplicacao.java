import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this is a commit test

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
  ArrayList<String> playerhand;
  ImageIcon imagemCardback = new ImageIcon("img/capa2.png");
  Filemanager files;
  JLabel card1;
  JLabel card2;
  JLabel card3;
  JLabel card4;
  JLabel card5;
  JLabel card1d;
  JLabel card2d;
  JLabel card3d;
  JLabel card4d;
  JLabel card5d;
  //JLabel cardDealer;
  JPanel buttons;
  private int currentcard = 0;

  Aplicacao(
  		Filemanager files,
	  	JPanel buttons,
	  	JLabel card1, JLabel card2, JLabel card3, JLabel card4, JLabel card5,
	    JLabel card1d, JLabel card2d, JLabel card3d, JLabel card4d, JLabel card5d,
	    JLabel left, JLabel right,
	    JLabel r,
	    JButton b, JButton end,
	    JPanel tela,
	    Player player, Dealer dealer) {
    this.files = files;
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
    this.card1d = card1d;
    this.card2d = card2d;
    this.card3d = card3d;
    this.card4d = card4d;
    this.card5d = card5d;
    //this.cardDealer = cardDealer;
    this.buttons = buttons;
  }

  public void actionPerformed(ActionEvent e) {
    if(player.getStatus()){
      first = true;
      player.setStatus(false);
    }

    if (first){
    buttons.add(end);
    end.addActionListener(new EndGame(files, buttons,card1,card2,card3,card4,card5, card1d,card2d,card3d,card4d,card5d, left,right,r,b,end,tela,player,dealer)); //sets up the stop button
    first = false;
    currentcard = 0;
    card1.setIcon(null);
	card2.setIcon(null);
	card3.setIcon(null);
	card4.setIcon(null);
	card5.setIcon(null);
	card1d.setIcon(null);
	card2d.setIcon(null);
	card3d.setIcon(null);
	card4d.setIcon(null);
	card5d.setIcon(null);
    player.reset();
    dealer.reset();
    left.setText(" ");
    right.setText(" ");
    dealer.drawCard();
    //card1d.setIcon(imagemCardback);
    }

    card1d.setIcon(imagemCardback);
    //dealer.drawCard();
    player.receiveCard(dealer.giveCard());
    //dealer.deckcheck();//DEBUG ONLY

    //card1d.setIcon(imagemCardback);
    r.setText(String.valueOf(player.calcScore())); // shows the player score
    playerhand = player.getHandList();
    ImageIcon imagemCarta = new ImageIcon("img/" + playerhand.get(currentcard) + ".png");

	switch(currentcard){
		case 0:
			card1.setIcon(imagemCarta);
			break;
		case 1:
			card2.setIcon(imagemCarta);
			break;
		case 2:
			card3.setIcon(imagemCarta);
			break;
		case 3:
			card4.setIcon(imagemCarta);
			break;
		case 4:
			card5.setIcon(imagemCarta);
			break;
		default:
			break;
	}
	currentcard++;

    b.setText("HIT ME");

    //checks for win/lose conditions that doesn't require checking the dealer's hand
	if (player.calcScore() == 21){
	     r.setText("YOU WIN [score: " + String.valueOf(player.calcScore()) + "]");
	     files.addWin();
	     files.writeHistory();
	     buttons.remove(end);
	     b.setText("Play again?");
	     player.setStatus(true);
	 } else if (player.calcScore() > 21){
	     r.setText("YOU LOSE [score: " + String.valueOf(player.calcScore()) + "]");
	     files.addLoss();
	     files.writeHistory();
	     buttons.remove(end);
	     b.setText("Play again?");
	     player.setStatus(true);
    }

    tela.repaint();
  }

}
