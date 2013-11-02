package lenguajes.buscaminas;

import java.util.Random;
public class Tablero{
public int[][] tabla;
	public Tablero(String dificultad){
		this.tabla = creartablero(dificultad);
		llenartablerobombas(this.tabla, dificultad);
	}
private int[][] creartablero(String dificultad){
	int[][] tabla = null;
	if(dificultad.equals("facil")){
		tabla = new int[9][9];	
	}
	else if(dificultad.equals("intermedio")){
		tabla = new int[16][16];
	}
	else if(dificultad.equals("dificil")){
		tabla = new int[16][30];
	}
	else
		System.out.println("Internal Error");
	return tabla;}
private void llenartablerobombas(int[][] tabla, String dificultad){
	int cont=0,x=0,y=0;
        double bombpos=0;
	Random random = new Random();
	if(dificultad.equals("facil")){
		while(cont<10){
			bombpos=random.nextInt(81);
			x=(int)Math.floor(bombpos/9);
			y=(int)(((bombpos/9)%1)*10);
			if(tabla[x][y]==0){
				tabla[x][y]=10;
				cont++;
                        }}}
        else if(dificultad.equals("intermedio")){
            while(cont<40){
			x=random.nextInt(16);
			y=random.nextInt(16);
			if(tabla[x][y]==0){
				tabla[x][y]=10;
				cont++;
                        }}}
        else if(dificultad.equals("dificil")){
            while(cont<99){
			x=random.nextInt(16);
			y=random.nextInt(30);
			if(tabla[x][y]==0){
				tabla[x][y]=10;
				cont++;
                        }}
        }
}

}
