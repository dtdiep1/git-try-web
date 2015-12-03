package com.example.thanh.lab10;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by thanh on 11/25/2015.
 */
public class DoWork extends IntentService{

    public DoWork() {
        super("Hello Intent Service");
    }

    @Override
    protected void onHandleIntent(Intent workIntent) {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
                Intent broadcast = new Intent("broadcast").putExtra("notiID", i);
                LocalBroadcastManager.getInstance(this).sendBroadcast(broadcast);
            } catch (Exception e) {

            }
        }

    }
}
