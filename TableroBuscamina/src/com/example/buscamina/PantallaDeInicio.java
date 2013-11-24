package com.example.buscamina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class PantallaDeInicio extends Activity {
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_inicio);
        
        
        //Vamos a declarar un nuevo thread
        Thread timer = new Thread(){
            //El nuevo Thread exige el metodo run
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                    //Si no puedo ejecutar el sleep muestro el error
                    e.printStackTrace();
                }finally{
                    //Llamo a la nueva actividad
                    //startActivity recibe por parametro un objeto del tipo Intent
                    //El Intent recibibe por parametro el NAME de la actividad que vamos a invocar
                    //Es el mismo que colocamos en el manifiesto
                	 Intent actividaPrincipalUno  =new Intent("com.example.gridview.pantalla_menu.PRINCIPALUNO");
                     startActivity(actividaPrincipalUno);
                }                
            }
        };
        //ejecuto el thread
        timer.start();
        
       
        
    }
}
