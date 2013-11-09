package com.example.buscamina;

public class Cuadrado {
    public int x,y,ancho;
    public int contenido=0;
    public boolean destapado=false;
    public void fijarxy(int x,int y, int ancho) {
        this.x=x;
        this.y=y;
        this.ancho=ancho;
    }
    
    public boolean dentro(int x,int y) {
        if (x>=this.x && x<=this.x+ancho && y>=this.y && y<=this.y+ancho) 
            return true;
        else
            return false;
    }
}