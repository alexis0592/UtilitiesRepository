package com.reyesmagos.code.utilities.activities.controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

public abstract class AbstractController {
	private Activity activity;
	private ProgressDialog progressDialog;

	public AbstractController(Activity activity) {
		super();
		this.activity = activity;
	}

	public void showAlertMessage(String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

		builder.setTitle(title);

		builder.setMessage(message).setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				});

		AlertDialog dialog = builder.show();
		dialog.show();
	}

	public void showProgressDialog(String title, String message) {
		this.progressDialog = new ProgressDialog(getActivity());
		this.progressDialog.setCancelable(false);
		this.progressDialog.setTitle(title);
		this.progressDialog.setMessage(message);
		this.progressDialog.show();
	}

	public void dissmissProgressDialog() {
		this.progressDialog.dismiss();

	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public ProgressDialog getProgressDialog() {
		return progressDialog;
	}

	public void setProgressDialog(ProgressDialog progressDialog) {
		this.progressDialog = progressDialog;
	}

	public void changeActivity(Class<?> destinyClass) {
		Intent i = new Intent(getActivity(), destinyClass);
		getActivity().startActivity(i);
	}
}
