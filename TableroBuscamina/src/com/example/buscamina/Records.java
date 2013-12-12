package com.example.buscamina;

/**
 * Clase que contiene el archivo con los records del juego
 * @author Jonathan Mendieta
 * @author Dennise Pintado
 * @author Janina Costa
 */

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

public class Records extends Activity{
	private SharedPreferences memoria;
	private EditText texto1, titulo;
	private LinearLayout layout1;
	private String[] scorelist,splitter;
	private String totalscoreName = "";
	private int remainder, hour, min, sec, cont=1;
	private ArrayList<Jugador> jugadores;
	
	 protected void onCreate(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.records);
	        memoria = getSharedPreferences("GameBuscaminas", Context.MODE_PRIVATE);
	        jugadores = new ArrayList<Jugador>();
	        scorelist = new String[memoria.getAll().size()];
	        splitter = new String[2];
	        layout1 = (LinearLayout) findViewById(R.id.layout1);
	        texto1 = new EditText(this);
	        titulo = new EditText(this);
            
	        for(int i=0;i<memoria.getAll().size();i++){
	        	scorelist[i] = memoria.getString("score"+i, "");
	        	splitter = scorelist[i].split(",");
	        	jugadores.add(new Jugador(splitter[0],Integer.parseInt(splitter[1])));
	        }
	        Collections.sort(jugadores);
	        
	        for(Jugador temp : jugadores){
	        	hour = temp.getTiempo() / 3600;
	            remainder = (int) temp.getTiempo() - hour * 3600;
	            min = remainder / 60;
	            remainder = remainder - min * 60;
	            sec = remainder;
	            totalscoreName = totalscoreName+cont+"  "+temp.getNombre()+"\n"+hour+":"+min+":"+sec+"\n\n";
	            cont++;
	        }
	        texto1.setText(totalscoreName);
	        texto1.setTextColor(Color.BLACK);
	        texto1.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
	        texto1.setTextSize(15);
	        texto1.setKeyListener(null);
	        titulo.setText("Tabla de posiciones\n");
	        titulo.setTextColor(Color.BLUE);
	        titulo.setTypeface(Typeface.SANS_SERIF);
	        titulo.setTextSize(20);
	        titulo.setGravity(Gravity.CENTER_HORIZONTAL);
	        titulo.setKeyListener(null);
	        layout1.addView(titulo);
	        layout1.addView(texto1);
	        
	    }
}
