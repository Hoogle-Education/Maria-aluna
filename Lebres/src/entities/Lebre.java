import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lebre implements Runnable {    
	
	public Thread lebre;	
	private Random numero = new Random();
	
	static final List<String> ranking = new ArrayList<String>(); 
	//Criação de um ArrayList para armazenar o ranking das lebres
	
	static final List<Integer> qtdPulos = new ArrayList<Integer>(); 
	//Lista que armazena a quantidade de pulos das lebres
	
	// Método Construtor
	public Lebre(String nLebre) { 
		//No construtor é imediatamente iniciada a Thread da lebre invocada
		lebre = new Thread(this, nLebre);
		lebre.start();
	}
        
	public void run() {		
		int distancia = 0;
		int qtdPulos  = 1; 
		System.out.println(lebre.getName() + " instanciada");
		
		while (distancia <= 50) {
			int distPulo = (numero.nextInt(3)) + 1; //Gera um número aleatório de 1 a 3
			
			if ((distancia + distPulo) >= 50) {
				//Controle da distância do pulo para verificação se a lebre finalizou a corrida
				distPulo = (50 - distancia); 
				distancia = 50;
				System.out.println(lebre.getName() + " Último pulo de " 
				+ distPulo + " metro(s) de distância " 
				+ "(percorrido " + distancia + " metro(s))");
				break;				
			} else { 
				distancia += distPulo; //Acumulador da distância de pulos
				qtdPulos++;
				try {
					Thread.sleep(100); 
					//Faz a lebre aguardar 10 milissegundos o que permite outra lebre tomar conta da CPU
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
				
				System.out.println(lebre.getName() + " pulou " + distPulo + 
						" metro(s) de distância " + "(percorrido "
						+ distancia + " metros)");
			}			
		}
				
		synchronized(lebre) {
			pontuar(lebre,qtdPulos);		
		}
	}    
	
	public void pontuar(Thread l, int qPulos) {
		System.out.println(lebre.getName() + " está no ambiente sincronizado!");
		ranking.add(l.getName());
		qtdPulos.add(qPulos);
	}	
}
