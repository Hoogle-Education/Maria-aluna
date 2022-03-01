package entities;

import java.util.Random;

import application.Match;
import services.Manager;

public class Racer implements Runnable, Comparable<Racer> {

	public Thread thread;
	private String racerName;
	private int score;
	public static volatile int maxPoints ;
	public static volatile int count = 0;
	
	public Racer( String racerName ) {
		this.racerName = racerName;
		thread = new Thread( this, racerName);
		score = 0;
	}

	public Racer( String racerName , int score) {
		this.racerName = racerName;
		thread = new Thread( this, racerName);
		this.score = score;
	}
	
	public void run() {
		
		int position = 0;
		int step = (int) Math.floor( Math.random()*(100)) ;
		
		while ( position <= 1000 ) {
			
			if( position + step > 1000 ) {
				score += maxPoints;
				maxPoints--;
				count++;
				if(count == Match.ranking.size()){
					count = 0;
					maxPoints = Match.ranking.size();
				}
				position = 0;
				break;
			} else {
				position += step;

				try {
					// allow other race to run
					Thread.sleep(200);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			
				step = (int)Math.floor( Math.random()*(100)) ;
			}
			
		}
		
	}
	
	@Override
	public String toString() {
		return racerName + " -> score=" + score + " points";
	}

	public Thread getThread() {
		return thread;
	}

	public String getRacerName() {
		return racerName;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Racer other) {
		return -1*(this.getScore() - other.getScore()) ;
	}
	
}
