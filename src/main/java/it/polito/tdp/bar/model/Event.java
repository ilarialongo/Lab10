package it.polito.tdp.bar.model;

import java.time.LocalTime;


public class Event implements Comparable<Event> {
	public enum EventType {
		ARRIVO_CLIENTE, USCITA_CLIENTE
	}
	private LocalTime time;
	private EventType type;
	private Tavolo tavolo;
	private Cliente cliente;
	
	public Tavolo getTavolo() {
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	
	public Event(LocalTime time, EventType type, Tavolo tavolo, Cliente cliente) {
		super();
		this.time = time;
		this.type = type;
		this.tavolo = tavolo;
		this.cliente = cliente;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public int compareTo(Event other) {
		return this.time.compareTo(other.time);
	}
	@Override
	public String toString() {
		return "[time=" + time + ", type=" + type + ", tavolo="+tavolo+ ", cliente=" + cliente.getNumeroPersone()+ " "+cliente.getTolleranza()+"]";
	}
	
	
	
}
