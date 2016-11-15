import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

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
	JLabel card1d;
	JLabel card2d;
	JLabel card3d;
	JLabel card4d;
	JLabel card5d;
	Filemanager files;
	JPanel buttons;
	private int currentcard = 0;
	private int dealerhandsize = 1;
	ArrayList<String> dealerhand;
	ImageIcon imagemCarta;

	EndGame(
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
    this.end = end;
    this.tela = tela;
    this.player = player;
    this.dealer = dealer;
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

	public void actionPerformed(ActionEvent e){
		buttons.remove(end);
    	b.setText("Play again?");
    	player.setStatus(true);
    	//dealerhandsize++;
		while (dealer.calcScore()<17){ //blackjack end-game basic dealer rule
			dealer.drawCard();
			dealerhandsize++;
		}

    //shows the dealer's and the player's score and hand
		dealerhand = dealer.getHandList();
	    //ImageIcon imagemCarta;
	    while(currentcard<dealerhandsize){
	    	imagemCarta = new ImageIcon("img/" + dealerhand.get(currentcard) + ".png");
			switch(currentcard){
				case 0:
					card1d.setIcon(imagemCarta);
					break;
				case 1:
					card2d.setIcon(imagemCarta);
					break;
				case 2:
					card3d.setIcon(imagemCarta);
					break;
				case 3:
					card4d.setIcon(imagemCarta);
					break;
				case 4:
					card5d.setIcon(imagemCarta);
					break;
				default:
					break;
			}
			currentcard++;
		}
		dealerhandsize = 1;
		currentcard = 0;
		//JLabel left;
		tela.add(left, BorderLayout.LINE_START);
		left.setText("DEALER: " + String.valueOf(dealer.calcScore()));
		//JLabel right;
		tela.add(right, BorderLayout.LINE_END);
		right.setText("YOU: " + String.valueOf(player.calcScore()));

    //checks for win/lose conditions that require comparing the score of the player with the score of the dealer
		if ((player.calcScore()>dealer.calcScore() && player.calcScore()<22) || dealer.calcScore()>21){
			r.setText("YOU WIN");
			//files.addWin();
			//files.writeHistory();
		}
		else if (player.calcScore()<dealer.calcScore() && dealer.calcScore()<22){
			r.setText("YOU LOSE");
			//files.addLoss();
			//files.writeHistory();
		}
		else{
			r.setText("DRAW");
			//files.addDraw();
			//files.writeHistory();
		}
		tela.repaint();
	}
}