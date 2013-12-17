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
import android.widget.TextView;

public class Records extends Activity{
	private SharedPreferences memoria;
	private EditText topFacil,topIntermedio,topDificil;
	private TextView titulo, tituloFacil,tituloIntermedio,tituloDificil;
	private LinearLayout layout1;
	private String[] scorelist,splitter;
	private String totalscoreName = "";
	private int remainder, hour, min, sec, cont=1;
	private ArrayList<Jugador> jugadoresFacil,jugadoresIntermedio,jugadoresDificil;
	
	 protected void onCreate(Bundle savedInstanceState) {
	        // TODO Auto-generated method stub
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.records);
	        memoria = getSharedPreferences("GameBuscaminasFacil", Context.MODE_PRIVATE);
	        jugadoresFacil = new ArrayList<Jugador>();
	        jugadoresIntermedio = new ArrayList<Jugador>();
	        jugadoresDificil = new ArrayList<Jugador>();
	        scorelist = new String[memoria.getAll().size()];
	        splitter = new String[2];
	        layout1 = (LinearLayout) findViewById(R.id.layout1);
	        titulo = new TextView(this);
	        tituloFacil = new TextView(this);
	        tituloIntermedio = new TextView(this);
	        tituloDificil = new TextView(this);
	        topFacil = new EditText(this);
	        topIntermedio = new EditText(this);
	        topDificil = new EditText(this);
	        titulo = new TextView(this);
            //Se analiza en memoria top Facil
	        for(int i=0;i<memoria.getAll().size();i++){
	        	scorelist[i] = memoria.getString("score"+i, "");
	        	splitter = scorelist[i].split(",");
	        	jugadoresFacil.add(new Jugador(splitter[0],Integer.parseInt(splitter[1])));
	        }
	        Collections.sort(jugadoresFacil);
	        
	        for(Jugador temp : jugadoresFacil){
	        	hour = temp.getTiempo() / 3600;
	            remainder = (int) temp.getTiempo() - hour * 3600;
	            min = remainder / 60;
	            remainder = remainder - min * 60;
	            sec = remainder;
	            totalscoreName = totalscoreName+cont+"  "+temp.getNombre()+"\n"+hour+":"+min+":"+sec+"\n\n";
	            cont++;
	        }
	        //Se guarda los jugadores para top Facil
	        topFacil.setText(totalscoreName);
	        topFacil.setTextColor(Color.WHITE);
	        topFacil.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
	        topFacil.setTextSize(15);
	        topFacil.setKeyListener(null);
	        //Se analiza en memoria top Intermedio
	        cont=0;
	        memoria = getSharedPreferences("GameBuscaminasIntermedio", Context.MODE_PRIVATE);
	        scorelist = new String[memoria.getAll().size()];
	        
	        for(int i=0;i<memoria.getAll().size();i++){
	        	scorelist[i] = memoria.getString("score"+i, "");
	        	splitter = scorelist[i].split(",");
	        	jugadoresIntermedio.add(new Jugador(splitter[0],Integer.parseInt(splitter[1])));
	        }
	        Collections.sort(jugadoresIntermedio);
	        totalscoreName="";
	        for(Jugador temp : jugadoresIntermedio){
	        	hour = temp.getTiempo() / 3600;
	            remainder = (int) temp.getTiempo() - hour * 3600;
	            min = remainder / 60;
	            remainder = remainder - min * 60;
	            sec = remainder;
	            totalscoreName = totalscoreName+cont+"  "+temp.getNombre()+"\n"+hour+":"+min+":"+sec+"\n\n";
	            cont++;
	        }
	        //Se guarda los jugadores para top Intermedio
	        topIntermedio.setText(totalscoreName);
	        topIntermedio.setTextColor(Color.WHITE);
	        topIntermedio.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
	        topIntermedio.setTextSize(15);
	        topIntermedio.setKeyListener(null);
	        //Se analiza en memoria top Dificil
	        cont=0;
	        memoria = getSharedPreferences("GameBuscaminasDificil", Context.MODE_PRIVATE);
	        scorelist = new String[memoria.getAll().size()];
	        
	        for(int i=0;i<memoria.getAll().size();i++){
	        	scorelist[i] = memoria.getString("score"+i, "");
	        	splitter = scorelist[i].split(",");
	        	jugadoresDificil.add(new Jugador(splitter[0],Integer.parseInt(splitter[1])));
	        }
	        Collections.sort(jugadoresDificil);
	        totalscoreName = "";
	        for(Jugador temp : jugadoresDificil){
	        	hour = temp.getTiempo() / 3600;
	            remainder = (int) temp.getTiempo() - hour * 3600;
	            min = remainder / 60;
	            remainder = remainder - min * 60;
	            sec = remainder;
	            totalscoreName = totalscoreName+cont+"  "+temp.getNombre()+"\n"+hour+":"+min+":"+sec+"\n\n";
	            cont++;
	        }
	        //Se guarda los jugadores para top Dificil
	        topDificil.setText(totalscoreName);
	        topDificil.setTextColor(Color.WHITE);
	        topDificil.setTypeface(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD));
	        topDificil.setTextSize(15);
	        topDificil.setKeyListener(null);
	        
	        titulo.setText("Tabla de posiciones\n");
	        titulo.setTextColor(Color.MAGENTA);
	        titulo.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD);
	        titulo.setTextSize(25);
	        titulo.setGravity(Gravity.CENTER_HORIZONTAL);
	        tituloFacil.setText("Facil\n");
	        tituloFacil.setTextColor(Color.YELLOW);
	        tituloFacil.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD);
	        tituloFacil.setTextSize(20);
	        tituloFacil.setGravity(Gravity.CENTER_HORIZONTAL);
	        tituloIntermedio.setText("Intermedio\n");
	        tituloIntermedio.setTextColor(Color.YELLOW);
	        tituloIntermedio.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD);
	        tituloIntermedio.setTextSize(20);
	        tituloIntermedio.setGravity(Gravity.CENTER_HORIZONTAL);
	        tituloDificil.setText("Dificil\n");
	        tituloDificil.setTextColor(Color.YELLOW);
	        tituloDificil.setTypeface(Typeface.SANS_SERIF,Typeface.BOLD);
	        tituloDificil.setTextSize(20);
	        tituloDificil.setGravity(Gravity.CENTER_HORIZONTAL);
	        layout1.addView(titulo);
	        layout1.addView(tituloFacil);
	        layout1.addView(topFacil);
	        layout1.addView(tituloIntermedio);
	        layout1.addView(topIntermedio);
	        layout1.addView(tituloDificil);
	        layout1.addView(topDificil);
	        
	    }
}
