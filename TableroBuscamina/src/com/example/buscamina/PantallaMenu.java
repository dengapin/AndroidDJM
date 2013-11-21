package com.example.buscamina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class PantallaMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pantalla_menu);
		
		//Intent actividaPrincipal  =new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
        //startActivity(actividaPrincipal);
        
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
            case R.id.configuracion:
                    Toast.makeText(PantallaMenu.this , "Pantalla Configuración", Toast.LENGTH_LONG).show();
                    return true;
            
            case R.id.jugar:
            	//LA OPCION JUGAR MANDARA AL BUSCAMINAS BASICO POR DEFECTO!
            	Toast.makeText(PantallaMenu.this , "Pantalla Jugar", Toast.LENGTH_LONG).show();
                    //setContentView(R.layout.activity_main);
                    Intent actividaPrincipal  =new Intent("com.example.gridview.pantalla_de_inicio.PRINCIPAL");
                    startActivity(actividaPrincipal);
                    return true;
                    
            case R.id.AcercaDe:
                    Toast.makeText(PantallaMenu.this , "Pantalla Acerca De", Toast.LENGTH_LONG).show();
                    setContentView(R.layout.creditos); //llamamos con esto a la respectiva pantalla de este codigo
                    return true;
                    
            default:
                    return super.onOptionsItemSelected(item);
            }

    }
}
