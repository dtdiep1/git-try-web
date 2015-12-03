package com.example.thanh.lab10;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, DoWork.class);
        startService(intent);
        IntentFilter filter = new IntentFilter("broadcast");
        LocalBroadcastManager.getInstance(this).registerReceiver(new DoWork_Done_Listener(), filter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
class DoWork_Done_Listener extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra = intent.getExtras();
        int notiID = extra.getInt("notiID");
        NotificationCompat.Builder nBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(android.R.drawable.sym_def_app_icon)
                        .setContentTitle("notification " + String.valueOf(notiID))
                        .setContentText("Notification text");
        NotificationManager mNotification = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotification.notify(notiID, nBuilder.build());
    }
}
