package com.example.android.audiovideoringtonemanager;

import android.app.Activity;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AudioVideoRingtoneManagerActivity extends Activity {
	private Ringtone mCurrentRingtone;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Get the default Phone Ringer RingTone and play it.
		final Button ringtoneButton = (Button) findViewById(R.id.button1);
		ringtoneButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				Uri ringtoneUri = RingtoneManager
						.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
				
				playRingtone(RingtoneManager.getRingtone(
						getApplicationContext(), ringtoneUri));
			}
		});

		// Get the default Notification RingTone and play it.
		final Button notifButton = (Button) findViewById(R.id.button2);
		notifButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Uri notificationUri = RingtoneManager
						.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
				
				playRingtone(RingtoneManager.getRingtone(
						getApplicationContext(), notificationUri));
			}
		});


		// Get the default Alarm RingTone and play it.
		final Button alarmButton = (Button) findViewById(R.id.button3);
		alarmButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Uri alarmUri = RingtoneManager
						.getDefaultUri(RingtoneManager.TYPE_ALARM);
				
				playRingtone(RingtoneManager.getRingtone(
						getApplicationContext(), alarmUri));
			}
		});
	}

	// Shut off current Ringtone and play new one
	private void playRingtone(Ringtone newRingtone) {

		if (null != mCurrentRingtone && mCurrentRingtone.isPlaying())
			mCurrentRingtone.stop();

		mCurrentRingtone = newRingtone;

		if (null != newRingtone) {
			mCurrentRingtone.play();
		}
	}
	
	@Override
	protected void onPause() {
		playRingtone(null);
		super.onPause();
	}



}