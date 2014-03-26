package com.igordeoliveira.funnybuttons;

import java.io.IOException;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private boolean btnAiQueDeliciaIsRunning = false;
	private MediaPlayer mpAiQueDelicia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mpAiQueDelicia = MediaPlayer.create(getApplicationContext(), R.raw.quedelicia);
		
		ImageButton btnPaiDeFamilia = (ImageButton)findViewById(R.id.btnQueDelicia);
		btnPaiDeFamilia.setOnClickListener(new View.OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				if (!btnAiQueDeliciaIsRunning) {
					try {
						mpAiQueDelicia.prepare();
						mpAiQueDelicia.seekTo(0);
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mpAiQueDelicia.start();
					btnAiQueDeliciaIsRunning = true;
					Log.v("FUNNYBUTTONS", "Ai que delicia porra!");
				}
				else {
					mpAiQueDelicia.pause();
					btnAiQueDeliciaIsRunning = false;
				}
				
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
