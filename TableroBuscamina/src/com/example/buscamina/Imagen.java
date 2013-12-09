package com.example.buscamina;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;


public class Imagen extends ImageView{
	private int xDelta=100;
	 private int yDelta;
	 private int valor;
Canvas canvas;
	
	 public Imagen(Context context) {
		super(context);
		setImageResource(R.drawable.ic_launcher);
		
		}
	 
	 public int getValor() {
			return valor;
		}
	 
	 public void setValor(int valor) {
			this.valor = valor;
		}
	public int getxDelta() {
		return xDelta;
	}

	public void setxDelta(int xDelta) {
		this.xDelta = xDelta;
	}

	public int getyDelta() {
		return yDelta;
	}

	public void setyDelta(int yDelta) {
		this.yDelta = yDelta;
	}
}
