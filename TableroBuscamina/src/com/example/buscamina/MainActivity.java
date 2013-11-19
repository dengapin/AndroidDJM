package com.example.buscamina;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;


public class MainActivity extends Activity implements OnTouchListener {
	private Casilla[][] cuad;
	private int [][] posicion;
	private DibujarBoard  board;
	private Tablero tabla;
	private Acciones accion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabla = new Tablero("facil");
		accion = new Acciones(tabla.getTabla(),tabla.getBombas());
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
		cuad = tabla.getTabla();
		accion.ActionUnwrap(cuad[1][1]);
		board = new DibujarBoard (this);
		board.setOnTouchListener(this);
		layout.addView(board);
		
	}
	class DibujarBoard extends View {

		public DibujarBoard (Context context) {
			super(context);
		}

		protected void onDraw(Canvas canvas) {
			
			int ancho = 0;
			if (canvas.getWidth() < canvas.getHeight())
				ancho = board.getWidth();
			else
			ancho = board.getHeight();
			int tamCuad = ancho / 9;
			Paint pintar = new Paint();
			pintar.setTextSize(20);
			Paint pintar2 = new Paint();
			pintar2.setTextSize(20);
			Paint pintarlinea = new Paint();
			pintarlinea.setARGB(255, 255, 255, 255);
			int filaact = 0;
			for (int j = 0; j < 9; j++) {
				for (int i = 0; i < 9; i++) {
					cuad[j][i].fijarxy(i * tamCuad, filaact, tamCuad);
					if (cuad[j][i].getId().equals("numero") && cuad[j][i].isWrapped())
						pintar.setARGB(153, 204, 204, 204);
					else if(cuad[j][i].getId().equals("numero") && !cuad[j][i].isWrapped())
						pintar.setARGB(255, 255, 0, 0);
					if (cuad[j][i].getId().equals("bomba") && cuad[j][i].isWrapped())
						pintar.setARGB(255, 153, 153, 153);
					else if(cuad[j][i].getId().equals("bomba") && !cuad[j][i].isWrapped())
						pintar.setARGB(255, 255, 255, 255);
					if (cuad[j][i].getId().equals("vacio") && cuad[j][i].isWrapped())
						pintar.setARGB(200, 0, 153, 0);
					else if(cuad[j][i].getId().equals("vacio") && !cuad[j][i].isWrapped())
						pintar.setARGB(0, 0, 0, 0);
					canvas.drawRect(i * tamCuad, filaact, i * tamCuad + tamCuad - 2, filaact + tamCuad - 2, pintar);
					//canvas.drawLine(i* tamCuad, filaact, i * tamCuad 	+ tamCuad, filaact, pintarlinea);
					//canvas.drawLine(i * tamCuad + tamCuad - 1, filaact, i * tamCuad + tamCuad - 1, filaact + tamCuad, pintarlinea);
				    /*if (cuad[j][i].contenido >= 1
							&& cuad[j][i].contenido <= 8
							&& cuad[j][i].isWrapped())
						canvas.drawText(
								String.valueOf(cuad[j][i].contenido), i * tamCuad + (tamCuad / 2) - 8, filaact + tamCuad / 2, pintar2);
					*//*
					if (cuad[j][i].contenido == 80
							&& cuad[j][i].isWrapped()) {
						Paint bomba = new Paint();
						bomba.setARGB(255,255, 0, 0);
						canvas.drawCircle(i * tamCuad + (tamCuad / 2), filaact + (tamCuad / 2), 8, bomba);
					}*/

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
		for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                if (cuad[f][c].dentro((int) event.getX(),
                        (int) event.getY())) {
                    cuad[f][c].setWrapped(false);
                    System.out.println("PRUEBA");}}}
		return true;
	}
	

}
