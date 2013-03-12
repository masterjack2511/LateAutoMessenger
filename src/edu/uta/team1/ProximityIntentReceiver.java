package edu.uta.team1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.widget.Toast;

public class ProximityIntentReceiver extends BroadcastReceiver {
	  public void onReceive(Context context, Intent intent) {
	    String key = LocationManager.KEY_PROXIMITY_ENTERING;

	    Boolean entering = intent.getBooleanExtra(key, false);
	    if (entering) {
	     
	      try {
	    	 // alert = intent.getParcelableExtra("current");
	        //alert = new ProximityAlert(intent.getStringExtra("current"));
	    	  String name = intent.getStringExtra("name");
	    	  String descr = intent.getStringExtra("descr");
	    	  if(descr!=null && descr.length()>0)
	    	  {
		        Toast.makeText(context, "entered " + name +"\n\n"+descr,Toast.LENGTH_LONG).show();
		        Intent i = new Intent( );
		        i.setClass(context, ReminderDisplay.class);
		        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		        i.putExtra("name", name);
		        i.putExtra("descr", descr);
		        context.startActivity(i);
	    	  }
	    	  
	    	  final MediaPlayer player = MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
				
				
				if(player!=null)
				{
					player.start();
					Toast.makeText(context, "ringtone playing", Toast.LENGTH_LONG).show();
					 new CountDownTimer(10000, 10000) {  
						 public void onTick(long millisUntilFinished) {  
							 
							 }    
						 public void onFinish() {  
							player.stop();
							 }  
						 }.start(); 
				}
	        //NotifierHelper.vibrate(context);
	      } catch (Exception ex) {
	        ex.printStackTrace();
	      }
	    }
	  }
	}
