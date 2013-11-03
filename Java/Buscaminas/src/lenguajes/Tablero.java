/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajes;
import java.util.ArrayList;
import java.util.Random;

public class Tablero{
private Object[][] tabla;
private ArrayList <Bomba> bombas;
private String dificultad;

public Tablero(String dificultad){
    this.dificultad = dificultad;
    this.tabla = creartablero(dificultad);
    bombas = new ArrayList<Bomba>();
    llenartablerobombas(this.tabla, 10);
    llenartableronumeros(tabla);
    Imprimirtablero(tabla);
}
        
private Object[][] creartablero(String dificultad){
	Object[][] tabla = null;
	if(dificultad.equals("facil")){
		tabla = new Object[9][9];	
	}
	else if(dificultad.equals("intermedio")){
		tabla = new Object[16][16];
	}
	else if(dificultad.equals("dificil")){
		tabla = new Object[16][30];
	}
	else
		System.out.println("Internal Error");
	return tabla;}

public void llenartablerobombas(Object[][] tabla, int idboton){
	int cont=0,x=0,y=0;
	Random random = new Random();
        Bomba bomba;
	if(this.dificultad.equals("facil")){
		while(cont<10){
                        x=random.nextInt(9);
			y=random.nextInt(9);
                        if(idboton!=((x*10)+y) && tabla[x][y]==null){
                            bomba = new Bomba(x,y);
                            tabla[x][y]=bomba.getId();
                            bombas.add(bomba);
                            cont++;
                        }
                }
        }
        else if(this.dificultad.equals("intermedio")){
            while(cont<40){
			x=random.nextInt(16);
			y=random.nextInt(16);
			if(idboton!=((x*10)+y) && tabla[x][y]==null){
				bomba = new Bomba(x,y);
                                tabla[x][y]=bomba.getId();
                                bombas.add(bomba);
				cont++;
                        }}}
        else if(this.dificultad.equals("dificil")){
            while(cont<99){
			x=random.nextInt(16);
			y=random.nextInt(30);
			if(idboton!=((x*10)+y) && tabla[x][y]==null){
				bomba = new Bomba(x,y);
                                tabla[x][y]=bomba.getId();
                                bombas.add(bomba);
				cont++;
                        }}
        }
        else
            System.out.println("Internal error");
}

public void llenartableronumeros(Object[][] tablero){
    int x=0,y=0,contx=0,conty=0;
    if(this.dificultad.equals("facil")){
        for(Bomba temp: this.bombas){
            x=temp.getX();
            y=temp.getY();
            contx=conty=0;
            for(int i=x-1;contx<3;i++){
                if(i>=0 && i<9){
                for(int j=y-1;conty<3;j++){
                    if(j>=0 && j<9){
                        if(tablero[i][j]==null){
                            tablero[i][j]=1;
                        }
                        else if(((int)tablero[i][j])!=9){
                            tablero[i][j]=(int)tablero[i][j]+1;
                        }
                    }
                    conty++;
                }conty=0;}
                contx++;
            }
        }
    }
    else if(this.dificultad.equals("intermedio")){
        for(Bomba temp: this.bombas){
            x=temp.getX();
            y=temp.getY();
            contx=conty=0;
            for(int i=x-1;contx<3;i++){
                if(i>=0 && i<16){
                for(int j=y-1;conty<3;j++){
                    if(j>=0 && j<16){
                        if(tablero[i][j]==null){
                            tablero[i][j]=1;
                        }
                        else if(((int)tablero[i][j])!=9){
                            tablero[i][j]=(int)tablero[i][j]+1;
                        }
                    }
                    conty++;
                }conty=0;}
                contx++;
            }
        }
    }
    else if(this.dificultad.equals("dificil")){
        for(Bomba temp: this.bombas){
            x=temp.getX();
            y=temp.getY();
            contx=conty=0;
            for(int i=x-1;contx<3;i++){
                if(i>=0 && i<16){
                for(int j=y-1;conty<3;j++){
                    if(j>=0 && j<30){
                        if(tablero[i][j]==null){
                            tablero[i][j]=1;
                        }
                        else if(((int)tablero[i][j])!=9){
                            tablero[i][j]=(int)tablero[i][j]+1;
                        }
                    }
                    conty++;
                }conty=0;}
                contx++;
            }
        }
    }
}
public void Imprimirtablero(Object[][] tablero){
    for(int i=0;i<16;i++){
        for(int j=0;j<30;j++){
            if(tablero[i][j]==null)
                System.out.print("0 ");
            else
            System.out.print((int)tablero[i][j]+" ");
        }
        System.out.print("\n");}
}
public ArrayList <Bomba> getBombas(){
    return this.bombas;
}

public Object[][] getTabla(){
    return this.tabla;
}
}