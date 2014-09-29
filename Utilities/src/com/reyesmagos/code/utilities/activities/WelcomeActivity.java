package com.reyesmagos.code.utilities.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.reyesmagos.code.utilities.R;

public class WelcomeActivity extends Activity {

	final int WELCOME = 25;
	TextView supportLine;
	ProgressBar progressBar;
	int progress = 0;
	int paso = 500;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.welcome_activity);

		progressBar = (ProgressBar) findViewById(R.id.progressbar);
		supportLine = (TextView) findViewById(R.id.bienvenida);
	}

	@Override
	protected void onResume() {
		super.onResume();

		supportLine.setText("Cargando...");
		cuentaAtras(3000);
	}

	public void cuentaAtras(long milisegundos) {
		CountDownTimer mCountDownTimer;
		progressBar.setMax((int) milisegundos);
		progressBar.setProgress(paso);

		mCountDownTimer = new CountDownTimer(milisegundos, paso) {

			@Override
			public void onTick(long arg0) {
				Log.v("Log_tag", "Tick of progress" + progress + arg0);
				progress += paso;
				progressBar.setProgress(progress);

			}

			@Override
			public void onFinish() {
				Toast.makeText(getApplicationContext(), "Bienvenido",
						Toast.LENGTH_LONG).show();
				progress += paso;
				progressBar.setProgress(progress);
				progressBar.setVisibility(View.INVISIBLE);
				//TODO: Colocar el nombre del paquete y cambiar el manifest
				Intent i = new Intent(
						"Poner el paquete de la clase que inicia despu�s de la pantalla de Bienvenida");
				startActivityForResult(i, WELCOME);
			}
		};

		mCountDownTimer.start();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == WELCOME)
			finish();
		else
			super.onActivityResult(requestCode, resultCode, data);
	}

}
