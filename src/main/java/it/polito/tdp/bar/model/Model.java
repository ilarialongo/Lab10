package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Model {
	private Simulator sim;
	
	public String simulazione() {
		sim= new Simulator();

		sim.setTavolo(10,2);
		sim.setTavolo(8, 4);
		sim.setTavolo(6, 4);
		sim.setTavolo(4, 5);
		
		sim.run();
		int totClienti= sim.getNum_TotClienti();
		int clientiSoddisfatti= sim.getNum_Clienti_Soddisfatti();
		int clientiInsoddisfatti= sim.getNum_Clienti_Insoddisfatti();
		return "Numero totale clienti: "+totClienti+"\nNumero clienti soddisfatti: "+clientiSoddisfatti+"\nNumero clienti insoddisfatti: "+clientiInsoddisfatti;
		
	}
	

}
