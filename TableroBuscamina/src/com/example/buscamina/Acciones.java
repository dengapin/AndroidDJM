package com.example.buscamina;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import android.widget.Toast;

public class Acciones {
private Casilla[][] tablero;
private ArrayList<Casilla> bombas;
private boolean finxBomba = false,finxGanar = false;

public Acciones(Casilla[][] tablero, ArrayList<Casilla> bombas){
	this.tablero = tablero;
	this.bombas = bombas;
}
public void ActionUnwrap(Casilla casilla){
	switch(casilla.getNumvalue()){
		case 9:
				if(!casilla.isFlagged() && casilla.isWrapped())
					for(Casilla temp: bombas)
						temp.setWrapped(false);
				this.finxBomba = true;
			break;
		case 0:
				if(!casilla.isFlagged() && casilla.isWrapped())
					casilla.setWrapped(false);
					ActionUnwrapVacios(casilla);
			break;
		default:
			if(!casilla.isFlagged() && casilla.isWrapped())
				casilla.setWrapped(false);
			this.finxGanar = testFinxGanar();
		break;
	}
}
private void ActionUnwrapVacios(Casilla casilla){
	Queue <Casilla> cola = new LinkedList<Casilla>();
	cola.add(casilla);
	Casilla temp;
	while(!cola.isEmpty()){ 
		temp = cola.poll();
			for(int i=temp.getX()-1; i<=temp.getX()+1; i++){
				if(i>=0 && i<this.tablero.length){
					for(int j=temp.getY()-1; j<=temp.getY()+1; j++){
						if(j>=0 && j<this.tablero[0].length){
							if(!tablero[i][j].getId().equals("bomba")&&!tablero[i][j].isFlagged()&&tablero[i][j].isWrapped()){
								tablero[i][j].setWrapped(false);
								if(tablero[i][j].getId().equals("vacio")){
									cola.add(tablero[i][j]);}
							}
						}
					}
				}
			}
			
	}
}
private boolean testFinxGanar(){
	for(int i=0; i<this.tablero.length; i++){
		for(int j=0; j<this.tablero[0].length; j++){
			if(tablero[i][j].isWrapped()){
				if(tablero[i][j].getId().equals("numero") || tablero[i][j].getId().equals("vacio")){
					return false;
				}
			}
		}
	}
	return true;
}
public boolean getFinxGanar(){
	return this.finxGanar;
}
public boolean getFinxBomba(){
	return this.finxBomba;
}
}
