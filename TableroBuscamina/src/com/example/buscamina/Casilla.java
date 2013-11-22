package com.example.buscamina;


public class Casilla{
    private int x,y,ancho,numvalue=0;
    public int contenido=0,posx,posy;
    private boolean wrapped=true,flagged;
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
    public String getId(){
    	return this.id;
    }
    public int getX(){
    	return this.x;
    }
    public int getY(){
    	return this.y;
    }
    public int getPosX(){
    	return this.posx;
    }
    public int getPosY(){
    	return this.posy;
    }
    public int getAncho(){
    	return this.ancho;
    }
    public int getNumvalue(){
    	return this.numvalue;
    }
    public boolean isWrapped(){
    	return this.wrapped;
    }
    public boolean isFlagged(){
    	return this.flagged;
    }
    public void setWrapped(boolean value){
    	this.wrapped = value;
    }
    public void setFlagged(boolean value){
    	this.flagged = value;
    }
    public void setNumvalue(int newValue){
    	this.numvalue = newValue;
    }
    public void setId(String id){
    	this.id = id;
    }
}
