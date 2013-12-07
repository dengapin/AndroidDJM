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
        
        
       
        Thread timer = new Thread(){
    
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                  
                    e.printStackTrace();
                }finally{
                   
                	 Intent actividaPrincipalUno  =new Intent("com.example.gridview.pantalla_menu.PRINCIPALUNO");
                     startActivity(actividaPrincipalUno);
                }                
            }
        };
        //ejecuto el thread
        timer.start();
        
       
        
    }
}
