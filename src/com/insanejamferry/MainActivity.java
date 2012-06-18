package com.insanejamferry;

import com.insane.jam.ferry.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button createButton = (Button) findViewById(R.id.createLogEntry);
        createButton.setOnClickListener(new ChangeActivity(this));
        
        Button viewButton = (Button) findViewById(R.id.viewLogEntries);
        viewButton.setOnClickListener(new ChangeActivity(this));
        
	}
	
	public static class ChangeActivity implements OnClickListener {
		
		private Activity activity;
		
		public ChangeActivity(Activity activity) {
			this.activity = activity;
		}

		@Override
		public void onClick(View v) {
			Intent i;
		
			switch(v.getId()) {
			case R.id.createLogEntry:
				i = new Intent(activity, LogBookEntryActivity.class);
				activity.startActivity(i);
				break;
			
			case R.id.viewLogEntries:
				i = new Intent(activity, ViewEntriesActivity.class);
				activity.startActivity(i);
				break;
			}
		}
		
	}

}
