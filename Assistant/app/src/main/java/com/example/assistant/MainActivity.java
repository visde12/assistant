package com.example.assistant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}


	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();

	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	public void callh(View view){
		Intent intent = new Intent(this,Callhistoryactivity.class);
         startActivity(intent);
	}

	public void calla(View view){
		Intent intent = new Intent(this,Analysislistview.class);
		startActivity(intent);
	}

	public void apph(View view){
		Intent intent = new Intent(this,Appusageactivity.class);
		startActivity(intent);
	}

	public void messageh(View view){
		Intent intent = new Intent(this,Messageactivity.class);
		startActivity(intent);
	}
}
