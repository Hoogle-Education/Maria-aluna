package entities;

import java.util.Random;

import application.Match;

public class Racer implements Runnable {

	public Thread threadRacer;
	public String racerName;
	private int score;
	
	public Racer( String racerName ) {
		this.racerName = racerName;
		threadRacer = new Thread( this, racerName);
		score = 0;
	}
	
	public void run() {
		
		int position = 0;
		int step = (int) Math.floor( Math.random()*(100)) ;
		
		while ( position <= 2000 ) {
			
			// System.out.println( racerName 
			// 										+ " || step = " + step 
			// 										+ " || position  = " + position);
			
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
				constructRank(threadRacer );
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void constructRank( Thread thread ) throws InterruptedException {
		Match.ranking.add( this );
		System.out.println(thread.getName() + " is going to sleep" );
		System.out.println(thread.isAlive());
		threadRacer.wait();
	}


	@Override
	public String toString() {
		return racerName + " -> score=" + score + " points";
	}
	
	
}
