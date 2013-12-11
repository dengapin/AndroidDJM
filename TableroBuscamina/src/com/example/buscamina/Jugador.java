package com.example.buscamina;

public class Jugador implements Comparable<Jugador>{
	private int puntuacion = 0;
	private String nombre = "";
	
	public Jugador(String nombre, int puntuacion){
		this.puntuacion = puntuacion;
		this.nombre = nombre;
	}
	@Override
	public int compareTo(Jugador jugador2) {
		// TODO Auto-generated method stub
		 Jugador otro = jugador2;

	        if(otro.puntuacion > this.puntuacion)
	        return -1;

	        else if(otro.puntuacion == puntuacion)
	        return 0;

	        else return 1;
	}
	public String getNombre(){
		return this.nombre;
	}
	public int getTiempo(){
		return this.puntuacion;
	}
}

