package com.example.android.jsonparsingpractice;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by sandeep on 1/13/2017.
 */

public class OkHttpHandler extends AsyncTask<String, Void, String> {

    /*ProgressDialog dialog;
    @Override
    protected void onPreExecute() {
        this.dialog.setMessage("Progress start");
        this.dialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        };
    }*/

    OkHttpClient client = new OkHttpClient();

    @Override
    protected String doInBackground(String... params) {

        Request.Builder builder = new Request.Builder();
        builder.url(params[0]);

        Request request = builder.build();

        try {

            Response response = client.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
        }

        return null;
    }
}
