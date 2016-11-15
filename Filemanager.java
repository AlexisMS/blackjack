import java.io.PrintWriter;

class Filemanager {
	private int wincount;
	private int drawcount;
	private int losecount;
	private PrintWriter writer;

	Filemanager(){
		wincount = 0;
	    drawcount = 0;
	    losecount = 0;
	}

	public void writeHistory(){
		try{
	    PrintWriter writer = new PrintWriter("history.txt", "UTF-8");
	    writer.println("wins: " + String.valueOf(wincount));
	    writer.println("loses: " + String.valueOf(losecount));
	    writer.println("draws: " + String.valueOf(drawcount));
	    writer.close();
		} catch (Exception e) {
		   // do something
		}
	}

	public void addWin(){
		wincount = wincount+1;
	}

	public void addLoss(){
		losecount = losecount+1;
	}

	public void addDraw(){
		drawcount = drawcount+1;
	}
}