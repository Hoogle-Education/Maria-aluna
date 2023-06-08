import entities.Lebre;

public class Program {    
    public static void main(String[] args) {        
        System.out.println("\nCorrida de Lebres\n");		
        //Cria as instâncias das lebres
		Lebre lebre1 = new Lebre("Lebre 1");
		Lebre lebre2 = new Lebre("Lebre 2");
		Lebre lebre3 = new Lebre("Lebre 3");
		Lebre lebre4 = new Lebre("Lebre 4");
		Lebre lebre5 = new Lebre("Lebre 5");
		
		//join() - A thread principal aguarda todas as outras threads finalizarem
		try {
			lebre1.lebre.join();
			lebre2.lebre.join();
			lebre3.lebre.join();
			lebre4.lebre.join();
			lebre5.lebre.join();			
		} catch (InterruptedException ie) {
			System.out.println("Corrida Interrompida");
		}
		
		System.out.println("\nFinal da corrida\n");
		
		System.out.println("RESULTADO FINAL: ");
		for (int i=0; i<ExerLebre.ranking.size(); i++) {
			System.out.println((i+1)+ "º lugar: "+ 
			ExerLebre.ranking.get(i)+ " ("+ ExerLebre.qtdPulos.get(i)+ " pulos)");
		}		
		
		//ExerLebre.ranking.stream()
		//	.forEach(System.out::println);
		
		System.out.println("\n### FIM ###");
	}    
 }
    
