package com.example.buscamina;

import android.os.Bundle;
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
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends Activity implements OnTouchListener {
	private boolean inicio=true, fin=false;
	private DibujarBoard  board;
	private Tablero tabla;
	private Acciones accion;
	private LinearLayout layout;
	private TextView textView1;
	private TextView textView2;
	
	public static String dificultad="facil";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//textView1 = (TextView) findViewById(R.id.textView1);
		//textView2 = (TextView) findViewById(R.id.textView2);

		// set font style for timer and mine count to LCD style
		//Typeface lcdFont = Typeface.createFromAsset(getAssets(),
		//  "fonts/lcd2mono.ttf");
		//textView1.setTypeface(lcdFont);
		//textView2.setTypeface(lcdFont);
		tabla = new Tablero(dificultad);
		accion = new Acciones(tabla.getTabla(),tabla.getBombas());
		layout = (LinearLayout) findViewById(R.id.layout2);
		
		board = new DibujarBoard (this);
		board.setOnTouchListener(this);
		this.layout.addView(this.board,getTableroWidth(this.tabla.getTabla()[0].length),getTableroHeight(this.tabla.getTabla().length));
	}
	

	
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
							pintaNums.setColor(Color.BLUE);
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
	public boolean onTouch(View tablero, MotionEvent event) {
		int action = MotionEventCompat.getActionMasked(event);
		if(fin==false){
		switch(action){
			case (MotionEvent.ACTION_DOWN):
				for (int i = 0; i < tabla.getTabla().length; i++) {
		            for (int j = 0; j < tabla.getTabla()[0].length; j++) {
		            	if (tabla.getTabla()[i][j].dentro((int) event.getX(),(int) event.getY())) {
		            		if(inicio){
			            		tabla.llenartablerobombas(i,j);
			            		inicio=false;
			            		accion.ActionUnwrap(tabla.getTabla()[i][j]);
			            		pintarTablero();
			            		return true;}
		            		else{
		            			accion.ActionUnwrap(tabla.getTabla()[i][j]);
		            			pintarTablero();
		            			fin = accion.testFin();
		            			return true;}
		                }
		            }
				}}}
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
