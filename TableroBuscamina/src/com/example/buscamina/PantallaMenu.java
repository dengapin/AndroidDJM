package com.example.buscamina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class PantallaMenu extends Activity  {
	public static final String DEBUG_TAG = "PantallaMenu";
	private Button boton, boton1, boton2, boton3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_menu);
		
		//Intent actividaPrincipal  =new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
        //startActivity(actividaPrincipal);
		
		
		boton1 = (Button) findViewById(R.id.botonMenu1);
        boton1.setOnTouchListener(new View.OnTouchListener() {
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub

            int action = MotionEventCompat.getActionMasked(event);
            Intent actividaPrincipal1  =new Intent("com.example.gridview.configuracion.PRINCIPAL");
            
            switch (action) {
            
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                Toast.makeText(PantallaMenu.this , "CONFIGURACIONES", Toast.LENGTH_LONG).show();
             	startActivity(actividaPrincipal1);
                //setContentView(R.layout.creditos);
                return true;
                
                
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "La acción ha sido MOVER");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE ", Toast.LENGTH_LONG).show();
            	startActivity(actividaPrincipal1);
            	//setContentView(R.layout.creditos);
                return true;
                
            case (MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG, "La acción ha sido ARRIBA");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "La accion ha sido CANCEL");
            	//Toast.makeText(PantallaMenu.this , "Pantalla jugar", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(DEBUG_TAG,"La accion ha sido fuera del elemento de la pantalla");
            	//Toast.makeText(PantallaMenu.this , "Pantalla Jugar", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            	
            default:
                return true;
            }
        }
    });
		
		
	
		
		boton2 = (Button) findViewById(R.id.botonMenu2);
        boton2.setOnTouchListener(new View.OnTouchListener() {
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub

            int action = MotionEventCompat.getActionMasked(event);
            Intent actividaPrincipal2  =new Intent("com.example.gridview.creditos.PRINCIPAL");
            
            switch (action) {
            
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                Toast.makeText(PantallaMenu.this , "ACERCA DE", Toast.LENGTH_LONG).show();
             	startActivity(actividaPrincipal2);
                //setContentView(R.layout.creditos);
                return true;
                
                
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "La acción ha sido MOVER");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE ", Toast.LENGTH_LONG).show();
            	startActivity(actividaPrincipal2);
            	//setContentView(R.layout.creditos);
                return true;
                
            case (MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG, "La acción ha sido ARRIBA");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "La accion ha sido CANCEL");
            	//Toast.makeText(PantallaMenu.this , "Pantalla jugar", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(DEBUG_TAG,"La accion ha sido fuera del elemento de la pantalla");
            	//Toast.makeText(PantallaMenu.this , "Pantalla Jugar", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            	
            default:
                return true;
            }
        }
    });
		
		
		
        boton3 = (Button) findViewById(R.id.botonMenu3);
        boton3.setOnTouchListener(new View.OnTouchListener() {
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub

            int action = MotionEventCompat.getActionMasked(event);
            Intent actividaPrincipal3  =new Intent("com.example.gridview.instrucciones.PRINCIPAL");
            
            switch (action) {
            
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                Toast.makeText(PantallaMenu.this , "ACERCA DE", Toast.LENGTH_LONG).show();
             	startActivity(actividaPrincipal3);
                //setContentView(R.layout.creditos);
                return true;
                
                
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "La acción ha sido MOVER");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE ", Toast.LENGTH_LONG).show();
            	startActivity(actividaPrincipal3);
            	//setContentView(R.layout.creditos);
                return true;
                
            case (MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG, "La acción ha sido ARRIBA");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "La accion ha sido CANCEL");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(DEBUG_TAG,"La accion ha sido fuera del elemento de la pantalla");
            	//Toast.makeText(PantallaMenu.this , "ACERCA DE", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            	
            default:
                return true;
            }
        }
    });
		

		
		boton = (Button) findViewById(R.id.botonMenu4);
        boton.setOnTouchListener(new View.OnTouchListener() {
        	
        	@Override
            public boolean onTouch(View v, MotionEvent event) {
            // TODO Auto-generated method stub

            int action = MotionEventCompat.getActionMasked(event);
            Intent actividaPrincipal  =new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
            
            switch (action) {
            
            case (MotionEvent.ACTION_DOWN):
                Log.d(DEBUG_TAG, "La accion ha sido ABAJO");
                Toast.makeText(PantallaMenu.this , "Pantalla Jugar", Toast.LENGTH_LONG).show();
             	startActivity(actividaPrincipal);
                return true;
                
                
            case (MotionEvent.ACTION_MOVE):
                Log.d(DEBUG_TAG, "La acción ha sido MOVER");
            	//Toast.makeText(PantallaMenu.this , "Pantalla Jugar", Toast.LENGTH_LONG).show();
            	startActivity(actividaPrincipal);
                return true;
                
            case (MotionEvent.ACTION_UP):
                Log.d(DEBUG_TAG, "La acción ha sido ARRIBA");
            	Toast.makeText(PantallaMenu.this , "Pantalla Jugar", Toast.LENGTH_LONG).show();
            	startActivity(actividaPrincipal);
            	return true;
            
            case (MotionEvent.ACTION_CANCEL):
                Log.d(DEBUG_TAG, "La accion ha sido CANCEL");
            	//Toast.makeText(PantallaMenu.this , "Pantalla jugar", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            case (MotionEvent.ACTION_OUTSIDE):
                Log.d(DEBUG_TAG,"La accion ha sido fuera del elemento de la pantalla");
            	//Toast.makeText(PantallaMenu.this , "Pantalla Jugar", Toast.LENGTH_LONG).show();
            	//startActivity(actividaPrincipal);
            	return true;
            	
            	
            default:
                return true;
            }
        }
    });
	
	}	
	@Override
   
	public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            MenuInflater inflater= getMenuInflater();
            inflater.inflate(R.menu.main, menu);
            return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item){
            switch(item.getItemId()){
            case R.id.op_menu_principal:
                    Toast.makeText(PantallaMenu.this , "Configuracion", Toast.LENGTH_LONG).show();
                    setContentView(R.layout.pantalla_menu);
                    return true;
            
            case R.id.jugar:
            	//LA OPCION JUGAR MANDARA AL BUSCAMINAS BASICO POR DEFECTO!
            	Toast.makeText(PantallaMenu.this , "JUGAR", Toast.LENGTH_LONG).show();
                    //setContentView(R.layout.activity_main);
                    Intent actividaPrincipal  =new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
                    startActivity(actividaPrincipal);
                    return true;
                    
            case R.id.AcercaDe:
                    Toast.makeText(PantallaMenu.this , "Acerca De", Toast.LENGTH_LONG).show();
                    setContentView(R.layout.creditos); //llamamos con esto a la respectiva pantalla de este codigo
                    return true;
                    
            default:
                    return super.onOptionsItemSelected(item);
            }

    }

  
}