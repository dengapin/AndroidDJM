package com.example.buscamina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Configuracion extends Activity{
	private Button boton1, boton2, boton3;


	public static final String DEBUG_TAG = "GesturesActivity";
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.configuracion);
		
		boton1 = (Button) findViewById(R.id.idbotonfacil);
        boton1.setOnTouchListener(new View.OnTouchListener() {
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
            
            int action = MotionEventCompat.getActionMasked(event);
            Intent actividaPrincipal1 = new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
            
            switch (action) {
            
            case (MotionEvent.ACTION_DOWN):
            
                Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                Toast.makeText(Configuracion.this , "START!!", Toast.LENGTH_LONG).show();
             	startActivity(actividaPrincipal1);
                return true;
            default:
            	MainActivity.dificultad="facil";
                return true;
                
            }
        } });
        
        
        boton2 = (Button) findViewById(R.id.idbotonintermedio);
        boton2.setOnTouchListener(new View.OnTouchListener() {
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
           
            int action = MotionEventCompat.getActionMasked(event);
            Intent actividaPrincipal1 = new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
            
            switch (action) {
            
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                Toast.makeText(Configuracion.this , "START!!", Toast.LENGTH_LONG).show();
                //op.nivel=2;
             	startActivity(actividaPrincipal1);
                //setContentView(R.layout.creditos);
                return true;
                
            	
            default:
            	MainActivity.dificultad="intermedio";
                return true;
            }
        } });
        
        
        boton3 = (Button) findViewById(R.id.idbotonavanzado);
        boton3.setOnTouchListener(new View.OnTouchListener() {
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
           
            int action = MotionEventCompat.getActionMasked(event);
            Intent actividaPrincipal1 = new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
            
            switch (action) {
            
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                Toast.makeText(Configuracion.this , "START!!", Toast.LENGTH_LONG).show();
                
             	startActivity(actividaPrincipal1);
           
                return true;
                
            	
            default:
            	MainActivity.dificultad="dificil";
                return true;
            }
        } });
	
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		}
}
