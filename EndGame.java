import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EndGame implements ActionListener{
	JLabel r;
	JButton b;
	JButton end;
	JPanel tela;
	Player player;
	Dealer dealer;

	EndGame(JLabel r, JButton b, JButton end, JPanel tela, Player player, Dealer dealer) {
	    this.r = r;
	    this.b = b;
	    this.end = end;
	    this.tela = tela;
	    this.player = player;
	    this.dealer = dealer;
  	}

  	public void actionPerformed(ActionEvent e){
  		//int dealerScore = dealer.calcScore();
  		tela.remove(b);
  		while (dealer.calcScore()<17){
  			dealer.drawCard();
  		}
  		JLabel left;
  		tela.add(left = new JLabel("temp"), BorderLayout.LINE_START);
  		left.setText("DEALER: " + String.valueOf(dealer.calcScore()) + " : " + dealer.getHand());
  		JLabel right;
  		tela.add(right = new JLabel("temp"), BorderLayout.LINE_END);
  		right.setText("YOU: " + String.valueOf(player.calcScore()) + " : " + player.getHand());
  		if ((player.calcScore()>dealer.calcScore() && player.calcScore()<22) || dealer.calcScore()>21)
  			r.setText("YOU WIN");
  		else if (player.calcScore()<dealer.calcScore() && dealer.calcScore()<22)
  			r.setText("YOU LOSE");
  		else
  			r.setText("DRAW");
  		tela.remove(end);
  		tela.repaint();
  	}
}