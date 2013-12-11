package com.example.buscamina;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class PantallaDeInicio extends Activity implements OnCompletionListener{
	
	MediaPlayer player;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_de_inicio);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        AssetManager manager = this.getAssets();
        MediaPlayer player = new MediaPlayer();
        try{
        	AssetFileDescriptor descriptor =manager.openFd("musica_juego");
        	player.setDataSource(descriptor.getFileDescriptor(),descriptor.getStartOffset(),descriptor.getLength());
        	player.prepare();
        	
        	//reproduccion
        	player.start();
        	player.setOnCompletionListener(this);
        }catch(Exception e){};
       ///
        Thread timer = new Thread(){
    
            public void run(){
                try{
                    sleep(3000);
                }catch(InterruptedException e){
                  
                    e.printStackTrace();
                }finally{
                   
                	 Intent actividaPrincipalUno  =new Intent("com.example.gridview.pantalla_menu.PRINCIPALUNO");
                     startActivity(actividaPrincipalUno);
                }                
            }
        };
        //ejecuto el thread
        timer.start();
        
       
        
    }

	@Override
	public void onCompletion(MediaPlayer mp) {
		player.stop();
		
	}
}
