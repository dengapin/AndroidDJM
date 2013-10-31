package com.example.listadesplegable;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    Spinner lista;
    String[] datos={"lista", "opcion1", "opcion2"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lista =(Spinner)findViewById(R.id.lista1);
		ArrayAdapter<String> adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,datos);
		lista.setAdapter(adaptador);
		
		//para que ocurra el evento al presionar
		lista.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int i, long l) {
				switch(i){
					
				case 1:
					Toast to= Toast.makeText(getApplicationContext(), "Nivel Intermedio", Toast.LENGTH_LONG);
					to.show();
					break;
				case 2:
					Toast t= Toast.makeText(getApplicationContext(), "Nivel Avanzado", Toast.LENGTH_LONG);
					t.show();
					break;
				}
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

