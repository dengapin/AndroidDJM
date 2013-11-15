package com.example.buscamina;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;


public class MainActivity extends Activity {
	private Casilla[][] cuad;
	private DibujarBoard  board;
	private Tablero tabla;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabla = new Tablero("facil");
		LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
		board = new DibujarBoard (this);		  
		layout.addView(board);
		cuad = tabla.getTabla();
	
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
			int tamCuad = ancho / 8;
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
					if (cuad[j][i].destapado == false)
						pintar.setARGB(153, 204, 204, 204);
					else
						pintar.setARGB(255, 153, 153, 153);
					canvas.drawRect(i * tamCuad, filaact, i * tamCuad + tamCuad - 2, filaact + tamCuad - 2, pintar);
					canvas.drawLine(i* tamCuad, filaact, i * tamCuad 	+ tamCuad, filaact, pintarlinea);
					canvas.drawLine(i * tamCuad + tamCuad - 1, filaact, i * tamCuad + tamCuad - 1, filaact + tamCuad, pintarlinea);

					if (cuad[j][i].contenido >= 1
							&& cuad[j][i].contenido <= 8
							&& cuad[j][i].destapado)
						canvas.drawText(
								String.valueOf(cuad[j][i].contenido), i * tamCuad + (tamCuad / 2) - 8, filaact + tamCuad / 2, pintar2);

					if (cuad[j][i].contenido == 80
							&& cuad[j][i].destapado) {
						Paint bomba = new Paint();
						bomba.setARGB(255,255, 0, 0);
						canvas.drawCircle(i * tamCuad + (tamCuad / 2), filaact + (tamCuad / 2), 8, bomba);
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

}
