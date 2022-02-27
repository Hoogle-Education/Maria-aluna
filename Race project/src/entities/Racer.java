package entities;

import java.util.Random;

import application.Match;

public class Racer implements Runnable {

	public Thread threadRacer;
	private String racerName;
	private int score;
	private Random random; 
	
	public Racer( String racerName ) {
		this.racerName = racerName;
		threadRacer = new Thread( this, racerName);
		score = 0;
	}
	
	public void run() {
		
		int position = 0;
		double step = 100*random.nextDouble();
		
		while ( position <= 2000 ) {
			
			if( position + step > 2000 ) {
				// 
			} else {
				
				position += step;
				try {
					// allow other race to run
					Thread.sleep(100);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		synchronized ( threadRacer ) {
			calculateScore(threadRacer );
		}
		
	}
	
	public void calculateScore( Thread threadRacer ) {
		Match.ranking.add( this );
		// calcular score das posições corretamente
	}


	@Override
	public String toString() {
		return racerName 
				+ "score=" 
				+ score ;
	}
	
	
}
