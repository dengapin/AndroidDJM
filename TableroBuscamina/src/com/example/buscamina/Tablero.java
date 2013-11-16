package com.example.buscamina;
import java.util.ArrayList;
import java.util.Random;

public class Tablero{
private Casilla[][] tabla;
private ArrayList <Casilla> bombas;
private ArrayList <Casilla> vacios;
private String dificultad;
private Acciones accion;

public Tablero(String dificultad){
	this.bombas = new ArrayList<Casilla>();
    this.vacios = new ArrayList<Casilla>();
	this.dificultad = dificultad;
    this.tabla = creartablero(dificultad);
    llenartablerobombas(10);
    llenartableronumeros();
    llenartablerovacios();
}
        
private Casilla[][] creartablero(String dificultad){
	Casilla[][] tabla = null;
	if(dificultad.equals("facil")){
		tabla = new Casilla[9][9];	
	}
	else if(dificultad.equals("intermedio")){
		tabla = new Casilla[16][16];
	}
	else if(dificultad.equals("dificil")){
		tabla = new Casilla[16][30];
	}
	else
		System.out.println("Internal Error");
	return tabla;}

public void llenartablerobombas(int idboton){
	int cont=0,x=0,y=0;
	Random random = new Random();
    Casilla bomba;
	if(this.dificultad.equals("facil")){
		while(cont<10){
            x=random.nextInt(9);
			y=random.nextInt(9);
            	if(idboton!=((x*10)+y) && this.tabla[x][y]==null){
            		bomba = new Casilla(x,y,"bomba");
            		bomba.setNumvalue(9);
                    this.tabla[x][y]=bomba;
                    bombas.add(bomba);
                    cont++;
                        }
                }
        }
        else if(this.dificultad.equals("intermedio")){
            while(cont<40){
			x=random.nextInt(16);
			y=random.nextInt(16);
			if(idboton!=((x*10)+y) && this.tabla[x][y]==null){
				bomba = new Casilla(x,y,"bomba");
				bomba.setNumvalue(9);
                this.tabla[x][y]=bomba;
                bombas.add(bomba);
				cont++;
                        }}}
        else if(this.dificultad.equals("dificil")){
            while(cont<99){
			x=random.nextInt(16);
			y=random.nextInt(30);
			if(idboton!=((x*10)+y) && this.tabla[x][y]==null){
				bomba = new Casilla(x,y,"bomba");
				bomba.setNumvalue(9);
                this.tabla[x][y]=bomba;
                bombas.add(bomba);
				cont++;
                        }}
        }
        else
            System.out.println("Internal error");
}

public void llenartableronumeros(){
    int x=0,y=0,contx=0,conty=0;
    Casilla numero;
        for(Casilla temp: this.bombas){
            x=temp.getX();
            y=temp.getY();
            contx=conty=0;
            for(int i=x-1;contx<3;i++){
                if(i>=0 && i<this.tabla.length){
                for(int j=y-1;conty<3;j++){
                    if(j>=0 && j<this.tabla[0].length){
                        if(this.tabla[i][j]==null){
                        	numero = new Casilla(i,j,"numero");
                        	numero.setNumvalue(1);
                            this.tabla[i][j]=numero;
                        }
                        else if((this.tabla[i][j].getNumvalue())!=9){
                        	this.tabla[i][j].setNumvalue(this.tabla[i][j].getNumvalue()+1);
                        }
                    }
                    conty++;
                }conty=0;}
                contx++;
            }
        }
}
public void llenartablerovacios(){
	Casilla vacio;
		for(int i=0;i<this.tabla.length;i++){
			for(int j=0;j<this.tabla[0].length;j++){
				if(this.tabla[i][j]==null){
					vacio = new Casilla(i,j,"vacio");
					vacio.setNumvalue(0);
					this.tabla[i][j]=vacio;
					vacios.add(vacio);}}}
}

public ArrayList <Casilla> getBombas(){
    return this.bombas;
}

public ArrayList <Casilla> getVacios(){
    return this.vacios;
}

public Casilla[][] getTabla(){
    return this.tabla;
}
}