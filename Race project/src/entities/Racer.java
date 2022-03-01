package entities;

import application.Match;

public class Racer implements Runnable {

	public Thread threadRacer;
	private String racerName;
	private int score;
	
	public Racer( String racerName ) {
		this.racerName = racerName;
		score = 0;
		threadRacer = new Thread( this , racerName );
		threadRacer.start();
	}

	public Racer (String racerName, int score){
		this.racerName = racerName;
		threadRacer = new Thread( this, racerName );
		this.score = score;
		threadRacer.start(); 
	}
	
	public void run() {
		
		int position = 0;
		int step = (int) Math.floor( Math.random()*(100)) ;
		
		while ( position <= 2000 ) {
			
			if( position + step > 1000 ) {
				score += Match.players.size() - Match.ranking.size();
				position = 0;
				break;
			} else {
				position += step;

				try {
					// allow other race to run
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			
				step = (int)Math.floor( Math.random()*(100)) ;
			}
			
		}
		
		synchronized ( threadRacer ) {
			try {
				constructRank( threadRacer );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void constructRank( Thread thread ) throws InterruptedException {
		System.out.println("Adding " + this);
		Match.ranking.add(this);

	}


	@Override
	public String toString() {
		return racerName + " -> score=" + score + " points";
	}

	public String getRacerName() {
		return racerName;
	}

	public int getScore() {
		return score;
	}	
	
}
