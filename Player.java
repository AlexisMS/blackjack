import java.util.*;

class Player{
	ArrayList<String> hand;
	protected int score;
	boolean resetStatus = false;

	Player(){
		hand = new ArrayList<String>();
		score = 0;
	}

	void receiveCard (String card){
		hand.add(card);
	}

	private int simpleScore(int current_score){ //checks score when the A rule doesn't come up
		for(int i=0; i<hand.size(); i++){
				switch (hand.get(i)){
					case "Ac" : case "Ad" : case "Ah" : case "As" :
						current_score += 1;
						break;
					case "2c" : case "2d" : case "2h" : case "2s" :
						current_score += 2;
						break;
					case "3c" : case "3d" : case "3h" : case "3s" :
						current_score += 3;
						break;
					case "4c" : case "4d" : case "4h" : case "4s" :
						current_score += 4;
						break;
					case "5c" : case "5d" : case "5h" : case "5s" :
						current_score += 5;
						break;
					case "6c" : case "6d" : case "6h" : case "6s" :
						current_score += 6;
						break;
					case "7c" : case "7d" : case "7h" : case "7s" :
						current_score += 7;
						break;
					case "8c" : case "8d" : case "8h" : case "8s" :
						current_score += 8;
						break;
					case "9c" : case "9d" : case "9h" : case "9s" :
						current_score += 9;
						break;
					case "10c" : case "10d" : case "10h" : case "10s" :
						current_score += 10;
						break;
					case "Jc" : case "Jd" : case "Jh" : case "Js" :
						current_score += 10;
						break;
					case "Qc" : case "Qd" : case "Qh" : case "Qs" :
						current_score += 10;
						break;
					case "Kc" : case "Kd" : case "Kh" : case "Ks" :
						current_score += 10;
						break;
					default : System.out.println("ERROR: invalid card value");
						break;

				}
			}
		return current_score;
	}

	int calcScore(){
		score = 0;
		score = this.simpleScore(score);
		if(hand.contains("Ac") || hand.contains("Ad") || hand.contains("Ah") || hand.contains("As")){ //aditional calculation required for when the A rule comes up (A can be either 1 or 11)
			int temp_score = score + 10;
			if (temp_score < 22)
				score = temp_score;
		}
		return score;
	}

	String getHand(){
		return hand.toString();
	}

	void reset(){
		hand.clear();
		score = 0;
	}

	boolean getStatus(){
		return resetStatus;
	}

	void setStatus(boolean state){
		resetStatus = state;
	}
}