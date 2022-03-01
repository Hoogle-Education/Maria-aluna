package services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Racer;
import application.Match;

public class Manager {
	
	public static List<Racer> addPlayers( int n ) {
		List <Racer> tmp = new ArrayList<>();
		
		for(int i=1; i<=n; i++) {
			String aux = "Racer #" + i;
			tmp.add( new Racer(aux) );
		}

		return tmp;
	}
	
	public static void updateRanking( int n , List<Racer> players) {
		System.out.println("size of ranking: " + Match.ranking.size());
		if( !(Match.ranking.size() == n) ){
			for(int i=1; i<=n; i++) {
				String aux = "Racer #" + i;
				Match.ranking.add( new Racer(aux) );
			}
			System.out.println("size of ranking: " + Match.ranking.size() + " now ranking is filled");
		}else{
			for(int i=0; i<n; i++){
				
				String racerId = players.get(i).getRacerName();
				int newScore = Match.ranking.get(i).getScore() + players.get(i).getScore();
				
				System.out.println(racerId 
													+ ": ActualScore = " 
													+  Match.ranking.get(i).getScore() 
													+ " || Score to add = " 
													+ players.get(i).getScore() 
													+ " || new Score = " 
													+ newScore);

				Match.ranking.set(i, new Racer( racerId, newScore) );
			}
		}
	}

	synchronized public static void startRace(int numberOfPlayers) throws InterruptedException {

		List <Racer> players = addPlayers(numberOfPlayers);

		updateRanking(numberOfPlayers, players);
		Racer.maxPoints	= Match.ranking.size();
		
		List <Thread> list = new ArrayList<>();
		for(Racer r: players){
			list.add(r.thread);
		} 

		list.forEach(Thread::start);
		Thread.sleep(5000);

		updateRanking(numberOfPlayers, players);

	}

	public static void printThreadState(String local, Racer r) {
		System.out.println("[ " 
											+ local 
											+ " ] -> "
											+ r
											+ " : "
											+ r.thread.getState() );
	}

	public static void showRanking( List <Racer> ranking ){
		Collections.sort(ranking);
		ranking.forEach(System.out::println);
	}

}
