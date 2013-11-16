package com.example.buscamina;

import java.util.ArrayList;

public class Acciones {
private Casilla[][] tablero;
private ArrayList<Casilla> bombas, vacios;

public Acciones(Casilla[][] tablero, ArrayList<Casilla> bombas, ArrayList<Casilla> vacios){
	this.tablero = tablero;
	this.bombas = bombas;
	this.vacios = vacios;
}
public void ActionUnwrap(Casilla casilla){
	switch(casilla.getNumvalue()){
		case 9:
				if(!casilla.isFlagged())
					for(Casilla temp: bombas)
						temp.setWrapped(false);
			break;
		case 0:
				if(!casilla.isFlagged())
					ActionUnwrapVacios(casilla);
			break;
		default:
			if(!casilla.isFlagged())
				casilla.setWrapped(false);
		break;
	}
}
public void ActionUnwrapVacios(Casilla casilla){
	
}
}
