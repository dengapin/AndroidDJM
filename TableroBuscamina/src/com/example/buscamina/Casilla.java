package com.example.buscamina;

public class Casilla {
    private int x,y,ancho,numvalue=0;
    public int contenido=0,posx,posy;
    public boolean destapado=false;
    private String id;
    
    public Casilla(int x, int y, String id){
    	this.x = x;
    	this.y = y;
    	this.id = id;
    }
    
    public void fijarxy(int x,int y, int ancho) {
        this.posx=x;
        this.posy=y;
        this.ancho=ancho;
    }
    
    public boolean dentro(int x,int y) {
        if (x>=this.posx && x<=this.posx+ancho && y>=this.posy && y<=this.posy+ancho) 
            return true;
        else
            return false;
    }
    
    public int getX(){
    	return this.x;
    }
    public int getY(){
    	return this.y;
    }
    public int getNumvalue(){
    	return this.numvalue;
    }
    public void setNumvalue(int newValue){
    	this.numvalue = newValue;
    }
}
