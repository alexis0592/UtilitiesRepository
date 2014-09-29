package com.reyesmagos.code.utilities.activities.socialnetwork;

import android.app.Activity;
import android.content.Intent;

public class SocialNetwork extends Activity{

	public void compartirRedSocial(Activity a, String evento) {
		Intent i = new Intent();
		i.setAction(Intent.ACTION_SEND);
		i.setType("text/plain");
		i.putExtra(Intent.EXTRA_TEXT, evento);
		a.startActivity(Intent.createChooser(i, "Compartir"));

	}
}
