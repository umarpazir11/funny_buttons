package com.igordeoliveira.funnybuttons;

import java.io.IOException;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	private MediaPlayer mpAiQueDelicia;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// Look up the AdView as a resource and load a request.
	    AdView adView = (AdView)this.findViewById(R.id.adView);
	    //adView.setAdUnitId("ca-app-pub-9328167116045984/6129942756");
	    //adView.setAdSize(AdSize.BANNER);
	    AdRequest adRequest = new AdRequest.Builder().build();
	    
	    adView.loadAd(adRequest);		
		
		mpAiQueDelicia = MediaPlayer.create(getApplicationContext(), R.raw.quedelicia);
		
		ImageButton btnPaiDeFamilia = (ImageButton)findViewById(R.id.btnQueDelicia);
		btnPaiDeFamilia.setOnClickListener(new View.OnClickListener() {
			
			
			
			@Override
			public void onClick(View v) {
				if (!mpAiQueDelicia.isPlaying()) {
					mpAiQueDelicia.start();
					Log.v("FUNNYBUTTONS", "Ai que delicia porra!");
				}
				else {
					mpAiQueDelicia.pause();
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
