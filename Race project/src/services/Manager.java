package services;

import java.util.List;

import application.Match;
import entities.Racer;

public class Manager{
  
  public static void addPlayers( int n ) {
		for(int i=1; i<=n; i++) {
			String aux = "Racer #" + i;
			Match.players.add( new Racer(aux) );
		}
	}
	
	public static void startRace() throws InterruptedException {

		for(Racer r: Match.players){
			printRacerState(r);
			r.threadRacer.join();
		} 

	}

	public static void remakeRace() {
		List <Racer> copy = Match.players;
		Match.ranking.clear();
		for(Racer copiedRacer : copy ){
			Match.players.add( copiedRacer );
		}
	}

	
	public static void showResult(){
		System.out.println(" ============ RESULT ============");
		Match.ranking.forEach( System.out::println );
	}

  	// TODO this delete after
	public static void printRacerState(Racer r) {
		System.out.println("[main]" 
											+ r.getRacerName() 
											+ " " 
											+ r.threadRacer.getState() );
	}

}
