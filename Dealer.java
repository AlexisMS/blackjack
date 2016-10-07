import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

class Dealer extends Player{
	private ArrayList<String> deck;

	Dealer(){
		super();
		deck = new ArrayList<String>(52);
	    deck.add("Ac");
	    deck.add("2c");
	    deck.add("3c");
	    deck.add("4c");
	    deck.add("5c");
	    deck.add("6c");
	    deck.add("7c");
	    deck.add("8c");
	    deck.add("9c");
	    deck.add("10c");
	    deck.add("Jc");
	    deck.add("Qc");
	    deck.add("Kc");
	    deck.add("Ad");
	    deck.add("2d");
	    deck.add("3d");
	    deck.add("4d");
	    deck.add("5d");
	    deck.add("6d");
	    deck.add("7d");
	    deck.add("8d");
	    deck.add("9d");
	    deck.add("10d");
	    deck.add("Jd");
	    deck.add("Qd");
	    deck.add("Kd");
	    deck.add("Ah");
	    deck.add("2h");
	    deck.add("3h");
	    deck.add("4h");
	    deck.add("5h");
	    deck.add("6h");
	    deck.add("7h");
	    deck.add("8h");
	    deck.add("9h");
	    deck.add("10h");
	    deck.add("Jh");
	    deck.add("Qh");
	    deck.add("Kh");
	    deck.add("As");
	    deck.add("2s");
	    deck.add("3s");
	    deck.add("4s");
	    deck.add("5s");
	    deck.add("6s");
	    deck.add("7s");
	    deck.add("8s");
	    deck.add("9s");
	    deck.add("10s");
	    deck.add("Js");
	    deck.add("Qs");
	    deck.add("Ks");
	}

	String giveCard(){
		int next = ThreadLocalRandom.current().nextInt(0, deck.size());
		String card = deck.get(next);
		deck.remove(next);
		deck.trimToSize();
		return card;
	}

	void drawCard(){
		hand.add(giveCard());
	}


}