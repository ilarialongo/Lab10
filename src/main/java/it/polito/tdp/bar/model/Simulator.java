package it.polito.tdp.bar.model;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import it.polito.tdp.bar.model.Event.EventType;

public class Simulator {
	// Coda degli eventi
	private PriorityQueue<Event> queue= new PriorityQueue();
	
	// Parametri di simulazione
	
	private List<Tavolo> tavoli= new ArrayList<>(this.popolaTavoli());
	private final LocalTime oraApertura= LocalTime.of(16, 00);
	private final LocalTime oraChiusura= LocalTime.of(23, 00);
	
	//Modello del mondo
	private int num_tavoli_disponibili;
	private Duration durata;
	
	// valori da calcolare
	private int num_TotClienti;
	private int num_Clienti_Soddisfatti;
	private int num_Clienti_Insoddisfatti;
	
	
	
	// metodi per impostare i parametri
	public List <Tavolo> popolaTavoli() {
		List<Tavolo> tavoli=new ArrayList<>();
		tavoli.add(new Tavolo (10, true));
		tavoli.add(new Tavolo (10, true));
		tavoli.add(new Tavolo (8, true));
		tavoli.add(new Tavolo (8, true));
		tavoli.add(new Tavolo (8, true));
		tavoli.add(new Tavolo (8, true));
		tavoli.add(new Tavolo (6, true));
		tavoli.add(new Tavolo (6, true));
		tavoli.add(new Tavolo (6, true));
		tavoli.add(new Tavolo (6, true));
		tavoli.add(new Tavolo (4, true));
		tavoli.add(new Tavolo (4, true));
		tavoli.add(new Tavolo (4, true));
		tavoli.add(new Tavolo (4, true));
		tavoli.add(new Tavolo (4, true));
		return tavoli;
	}
	
	
	public void setTavolo(int posti, int numeroTavoli) {
		for (int i=0; i<numeroTavoli; i++) {
			tavoli.add(new Tavolo(posti, true));
		}	
	}
	
	
	

	//metodi per restituire i risultati
	public int getNum_TotClienti() {
		return num_TotClienti;
	}


	public int getNum_Clienti_Soddisfatti() {
		return num_Clienti_Soddisfatti;
	}


	public int getNum_Clienti_Insoddisfatti() {
		return num_Clienti_Insoddisfatti;
	}
	
	//simulazione vera
	
	public void run() {
		num_tavoli_disponibili=this.tavoli.size();
		this.num_TotClienti=this.num_Clienti_Soddisfatti=this.num_Clienti_Insoddisfatti=0;
		this.queue.clear();
		LocalTime oraArrivoCliente=this.oraApertura;
		do {
			Event e= new Event(oraArrivoCliente, EventType.ARRIVO_CLIENTE, null, new Cliente ((int) (Math.random()*11),(float) (Math.random()) ));
			this.queue.add(e);
			durata= Duration.of((long) (Math.random()*11),ChronoUnit.MINUTES);
			oraArrivoCliente=oraArrivoCliente.plus(this.durata);
		} while (oraArrivoCliente.isBefore(oraChiusura));
		
		while(!this.queue.isEmpty()) {
			Event e=this.queue.poll();
			System.out.println(e.toString());
			processEvent(e);
		}
	}


	private void processEvent(Event e) {
		switch (e.getType()) {
		case ARRIVO_CLIENTE:
			if (num_tavoli_disponibili>0) {
				Collections.sort(tavoli);
				
				for (Tavolo t: this.tavoli) {
					/*if (t.getNum_Posti()==num_Persone && t.isIs_Libero()==true) {
						t.setIs_Libero(false);
						num_TotClienti+=num_Persone;
						num_Clienti_Soddisfatti+=num_Persone;
						num_tavoli_disponibili--;
						Duration permanenza= Duration.of((long)(Math.random()*61+60), ChronoUnit.MINUTES);
						Event nuovo= new Event ( e.getTime().plus(permanenza), EventType.USCITA_CLIENTE);
						this.queue.add(nuovo);
						break;	
					}*/
					if (e.getCliente().getNumeroPersone()<=t.getNum_Posti() && t.isIs_Libero()==true) {
						if (e.getCliente().getNumeroPersone()>=(t.getNum_Posti()/2)) {
							t.setIs_Libero(false);
							num_TotClienti+=e.getCliente().getNumeroPersone();
							num_Clienti_Soddisfatti+=e.getCliente().getNumeroPersone();
							num_tavoli_disponibili--;
							Duration permanenza= Duration.of((long)(Math.random()*61+60), ChronoUnit.MINUTES);
							Event nuovo= new Event (e.getTime().plus(permanenza), EventType.USCITA_CLIENTE,t, e.getCliente());
							this.queue.add(nuovo);
							break;	
						}
						else {
							double random= Math.random();
							if (e.getCliente().getTolleranza()>=random) {
							 num_TotClienti+=e.getCliente().getNumeroPersone();
							 num_Clienti_Soddisfatti+=e.getCliente().getNumeroPersone();
							 break;
							}
							else {
								 num_TotClienti+=e.getCliente().getNumeroPersone();
								 num_Clienti_Insoddisfatti+=e.getCliente().getNumeroPersone();
								 break;
							}
					}
					}
		 		}
					}
			
			
			else {
				double random= Math.random();
				if (e.getCliente().getTolleranza()>=random) {
				 num_TotClienti+=e.getCliente().getNumeroPersone();
				 num_Clienti_Soddisfatti+=e.getCliente().getNumeroPersone();
				}
	
				else {
					 num_TotClienti+=e.getCliente().getNumeroPersone();
					 num_Clienti_Insoddisfatti+=e.getCliente().getNumeroPersone();
					
				}
				
				}
		break;
			
	case USCITA_CLIENTE:
		e.getTavolo().setIs_Libero(true);
		num_tavoli_disponibili++;
		break;
	
	}
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
