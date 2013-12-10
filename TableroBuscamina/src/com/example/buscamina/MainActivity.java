package com.example.buscamina;

/**
 * Clase principal del Juego Buscamina
 * Contiene el layout donde se forma el tablero
 * El layout que contiene el cronometro y el emoticon
 * Tambien se encuentra el drag and drop
 * @author Jonathan Mendieta
 * @author Dennise Pintado
 * @author Janina Costa
 */

import java.util.ArrayList;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.support.v4.view.MotionEventCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnTouchListener {
	private boolean inicio=true, fin=false;
	private DibujarBoard  board;
	private Tablero tabla;
	private Acciones accion;
	private LinearLayout layout;
	private TextView textView1;
	private TextView textView2;
	private Handler TIMER = new Handler();
        private int CONTADOR = 0;
	private ViewGroup marco;	
	
	private int xDelta;
	private int yDelta;
	private ImageView ima;
	
	
	public static String dificultad="facil";
	
	
     /** 
     * Funcion principal dibuja el tablero de buscamina segun la dificultad que se le manda
     * @param inicio Bandera que corresponde al inicio del juego.
     * @param fin Bandera que corresponde al fin del juego .
     * @param board Posicion en x con respecto al tablero.
     * @param DibujarBoard Pinta el tablero, los numeros y las minas.
     * @param id Valor de la casilla.
     * @param dificultad devuelve el tablero de dimensiones segun su valor
     * @param CONTADOR variable entera que almacena los segundos de juego
     * @param textView1 Titulo del cronometro
     * @param textView2 Cronometro del juego
     * @param CONTADOR variable entera que almacena los segundos de juego
     */
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		textView1 = (TextView) findViewById(R.id.textView1);
		textView2 = (TextView) findViewById(R.id.textView2);

		// EStilo LCD para cronometro
		Typeface lcdFont = Typeface.createFromAsset(getAssets(),
		 "fonts/lcd2mono.ttf");
		textView1.setTypeface(lcdFont);
		textView2.setTypeface(lcdFont);
		
		
		tabla = new Tablero(dificultad);
		comenzarTiempo(); 
		
		
		Imagen unaImagen;
		ArrayList<Imagen>imagenes= new ArrayList<Imagen>();
				
		
		for (int i = 1; i <= 9; i++) {
			
			marco = (ViewGroup)findViewById(R.id.contenedor);
            unaImagen = new Imagen(this);
            unaImagen.setId(1);
            imagenes.add(unaImagen);
           
            marco.addView(unaImagen);
            
            unaImagen.setOnTouchListener(this);
            
            
        }
		/*
		ima = (ImageView)findViewById(R.drawable.bandera);
		marco = (ViewGroup)findViewById(R.id.linearLayout1);
		ima= new ImageView(this);
		ima.setId(1);
		ima.setOnTouchListener(this);
		marco.addView(ima);
			*/
		
		accion = new Acciones(tabla.getTabla(),tabla.getBombas());
		layout = (LinearLayout) findViewById(R.id.layout2);
		
		board = new DibujarBoard (this);
		board.setOnTouchListener(this);
		this.layout.addView(this.board,getTableroWidth(this.tabla.getTabla()[0].length),getTableroHeight(this.tabla.getTabla().length));
		
	
	}	
	
	 public void comenzarTiempo(){
         if (CONTADOR == 0){
                 TIMER.removeCallbacks(updateTimeElasped);
                 TIMER.postDelayed(updateTimeElasped, 1000);
         }
 }
	 
	 public void detenerTiempo(){
         TIMER.removeCallbacks(updateTimeElasped);
 }
	 
     
	 private Runnable updateTimeElasped = new Runnable(){
         public void run(){
                 long MILESIMAS = System.currentTimeMillis();
                 ++CONTADOR;

                 if (CONTADOR < 10){
                         textView2.setText("00" + Integer.toString(CONTADOR));
                 }else if (CONTADOR < 100){
                         textView2.setText("0" + Integer.toString(CONTADOR));
                 }else{
                         textView2.setText(Integer.toString(CONTADOR));
                 }
                 TIMER.postAtTime(this, MILESIMAS);
                 TIMER.postDelayed(updateTimeElasped, 1000);
         }
 };
	
	class DibujarBoard extends View {

		public DibujarBoard (Context context) {
			super(context);}

		protected void onDraw(Canvas canvas) {
			Casilla casilla;
			Typeface tf = Typeface.create(Typeface.SERIF,Typeface.BOLD);
			int tamCuad = 0;
			tamCuad = 37;
			Paint pintar = new Paint();
			Paint pintaNums = new Paint();
			Paint pintaBomb = new Paint();
			pintaNums.setTypeface(tf);
			pintaNums.setTextSize(16);
			pintaBomb.setARGB(255, 0, 0, 0);
			int filaact = 0;
			for (int j = 0; j < tabla.getTabla().length; j++) {
				for (int i = 0; i < tabla.getTabla()[0].length; i++) {
					casilla = tabla.getTabla()[j][i];
					if(inicio){
						pintar.setARGB(153, 204, 204, 204);
						pintar.setStyle(Paint.Style.FILL);
						canvas.drawRect(i * tamCuad, filaact, i * tamCuad + tamCuad - 2, filaact + tamCuad - 2, pintar);
						casilla.fijarxy(i * tamCuad, filaact, tamCuad);
					}
					else{
					pintar.setStyle(Paint.Style.FILL);
					casilla.fijarxy(i * tamCuad, filaact, tamCuad);
					if (casilla.isWrapped()){
						pintar.setARGB(153, 204, 204, 204);
						canvas.drawRect(i * tamCuad, filaact, i * tamCuad + tamCuad - 2, filaact + tamCuad - 2, pintar);}
					else{
						if(casilla.getId().equals("vacio")){
							pintar.setARGB(0, 0, 0, 0);
							canvas.drawRect(i * tamCuad, filaact, i * tamCuad + tamCuad - 2, filaact + tamCuad - 2, pintar);}
						else if(casilla.getId().equals("numero")){
							pintar.setStyle(Style.STROKE);
							pintar.setARGB(200, 204, 204, 204);
							canvas.drawRect(i * tamCuad, filaact, i * tamCuad + tamCuad - 2, filaact + tamCuad - 2, pintar);
							if(casilla.getNumvalue()==1)
								pintaNums.setColor(Color.BLUE);
							else if(casilla.getNumvalue()==2)
								pintaNums.setColor(Color.GREEN);
							else if(casilla.getNumvalue()==3)
								pintaNums.setColor(Color.RED);
							else if(casilla.getNumvalue()==4)
								pintaNums.setARGB(250,160,32,240);
							else if(casilla.getNumvalue()==5)
								pintaNums.setARGB(255,176,48,96);
							else if(casilla.getNumvalue()==6)
								pintaNums.setARGB(255,64,224,208);
							else if(casilla.getNumvalue()==7)
								pintaNums.setColor(Color.BLACK);
							else if(casilla.getNumvalue()==8)
								pintaNums.setColor(Color.GRAY);
							canvas.drawText(casilla.getNumvalue()+"",(i * tamCuad + (tamCuad / 2))-tamCuad/8,(filaact + (tamCuad / 2))+tamCuad/8, pintaNums);
							}
						else if(casilla.getId().equals("bomba")){
							pintar.setARGB(255, 153, 153, 153);
							canvas.drawRect(i * tamCuad, filaact, i * tamCuad + tamCuad - 2, filaact + tamCuad - 2, pintar);
							canvas.drawCircle(i * tamCuad + (tamCuad / 2), filaact + (tamCuad / 2), 8, pintaBomb);
							}
					}
				}
				}
				filaact = filaact + tamCuad;
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
public boolean onTouch(View v, MotionEvent event) {
		
		final int X = (int) event.getRawX();
		final int Y = (int) event.getRawY();
		
		int xDelta = 0;
		int yDelta=0;
		
		if(( v.getId())==1 ){
	
		//EVENTO PARA MOVER LA IMAGEN
		switch(event.getAction() & MotionEvent.ACTION_MASK){
		case (MotionEvent.ACTION_DOWN):
			
			
			//LinearLayout.LayoutParams Params = (LinearLayout.LayoutParams)v.getLayoutParams();
			RelativeLayout.LayoutParams Params = (RelativeLayout.LayoutParams) v.getLayoutParams();
			xDelta = X - Params.leftMargin;
			yDelta = Y - Params.topMargin;
			
			//xDelta = (int) ima.getX();
			//yDelta  =(int) ima.getY();
			
			marco.invalidate();
			
    		break;
		
		    		
		case MotionEvent.ACTION_MOVE:
	          RelativeLayout.LayoutParams layoutParams = 
	          (RelativeLayout.LayoutParams) v.getLayoutParams();
	          layoutParams.leftMargin = X - xDelta;
	          layoutParams.topMargin = Y - yDelta;
	         
	          layoutParams.rightMargin = -100;
	          layoutParams.bottomMargin = -100;
	         
	          v.setLayoutParams(layoutParams);
	          marco.invalidate();
			break;
		}//
		}
		
		//PARA LAS CUADRICULAS
		
		int action = MotionEventCompat.getActionMasked(event);
		if(fin==false){
		switch(action){
		case (MotionEvent.ACTION_DOWN):
			
			Toast.makeText(MainActivity.this , "hice down", Toast.LENGTH_LONG).show();
		
    		break;
		
		case (MotionEvent.ACTION_UP):
				for (int i = 0; i < tabla.getTabla().length; i++) {
		            for (int j = 0; j < tabla.getTabla()[0].length; j++) {
		            	if (tabla.getTabla()[i][j].dentro((int) event.getX(),(int) event.getY())) {
		            		if(inicio){
			            		tabla.llenartablerobombas(i,j);
			            		inicio=false;
			            		accion.ActionUnwrap(tabla.getTabla()[i][j]);
			            		pintarTablero();
			            		return true;
			            		}
		            		else{
		            			accion.ActionUnwrap(tabla.getTabla()[i][j]);
		            			pintarTablero();
		            			fin = accion.testFin();
		            			return true;
		            			}
		                }
		            }
				}}
		
		
		
		return true;
		}
		return false;
	}
	
	
	
	
	
	public void pintarTablero(){
		this.layout.removeView(this.board);
    	this.board = new DibujarBoard(this);
    	this.layout.addView(this.board,getTableroWidth(this.tabla.getTabla()[0].length),getTableroHeight(this.tabla.getTabla().length));
    	this.board.setOnTouchListener(this);
	}
	public int getTableroHeight(int casillasH){
		return 37*casillasH;
	}
	public int getTableroWidth(int casillasW){
		return 37*casillasW;
	}
}
