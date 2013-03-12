package edu.uta.team1;

import edu.uta.team1.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReminderDisplay extends Activity {
	private TextView descrT;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		Intent intent = getIntent();
		
		String descr = intent.getStringExtra("descr");
		String name = intent.getStringExtra("name");
		
		if(name !=null && descr !=null)
		{
			descrT = (TextView) findViewById(R.id.descrT);
			descrT.setText("Location: "+name+"\n\n"+descr);
		}
		
	}

}
