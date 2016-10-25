import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EndGame implements ActionListener{
	JLabel left;
	JLabel right;
	JLabel r;
	JButton b;
	JButton end;
	JPanel tela;
	Player player;
	Dealer dealer;
	JLabel card1;
	JLabel card2;
	JLabel card3;
	JLabel card4;
	JLabel card5;
	JPanel buttons;

	EndGame(JPanel buttons, JLabel card1, JLabel card2, JLabel card3, JLabel card4, JLabel card5, JLabel left, JLabel right, JLabel r, JButton b, JButton end, JPanel tela, Player player, Dealer dealer) {
    this.left = left;
    this.right = right;
    this.r = r;
    this.b = b;
    this.end = end;
    this.tela = tela;
    this.player = player;
    this.dealer = dealer;
    this.card1 = card1;
    this.card2 = card2;
    this.card3 = card3;
    this.card4 = card4;
    this.card5 = card5;
    this.buttons = buttons;
	}

	public void actionPerformed(ActionEvent e){
		buttons.remove(end);
    	b.setText("Play again?");
    	player.setStatus(true);
    	card1.setIcon(null);
    	card2.setIcon(null);
    	card3.setIcon(null);
    	card4.setIcon(null);
    	card5.setIcon(null);
    
		while (dealer.calcScore()<17){ //blackjack end-game basic dealer rule
			dealer.drawCard();
		}

    //shows the dealer's and the player's score and hand
		//JLabel left;
		tela.add(left, BorderLayout.LINE_START);
		left.setText("DEALER: " + String.valueOf(dealer.calcScore()) + " : " + dealer.getHand());
		//JLabel right;
		tela.add(right, BorderLayout.LINE_END);
		right.setText("YOU: " + String.valueOf(player.calcScore()) + " : " + player.getHand());

    //checks for win/lose conditions that require comparing the score of the player with the score of the dealer
		if ((player.calcScore()>dealer.calcScore() && player.calcScore()<22) || dealer.calcScore()>21)
			r.setText("YOU WIN");
		else if (player.calcScore()<dealer.calcScore() && dealer.calcScore()<22)
			r.setText("YOU LOSE");
		else
			r.setText("DRAW");
		tela.repaint();
	}
}