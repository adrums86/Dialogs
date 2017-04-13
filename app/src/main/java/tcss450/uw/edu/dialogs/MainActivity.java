package tcss450.uw.edu.dialogs;

import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;


import android.support.v4.app.NotificationCompat;

import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    int mNotificationID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launch(View v) {
        DialogFragment fragment = null;
        if (v.getId() == R.id.fire_missiles_button) {
            fragment = new FireMissilesDialogFragment();
        } else if (v.getId() == R.id.list_button) {
            fragment = new ListDialogFragment();
        } else if (v.getId() == R.id.multi_list_button) {
            fragment = new MultiListDialogFragment();
        } else if (v.getId() == R.id.custom_button) {
            fragment = new CustomDialogFragment();
        } else if (v.getId() == R.id.time_button) {
            fragment = new TimePickerDialogFragment();
        } else if (v.getId() == R.id.date_button) {
            fragment = new DatePickerDialogFragment();
        } else if (v.getId() == R.id.notification_button) {
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
            mBuilder.setSmallIcon(R.drawable.ic_stat_name);
            mBuilder.setContentTitle("Notification title");
            mBuilder.setContentText("Notification content");
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(mNotificationID, mBuilder.build());
            mNotificationID ++;
        }

        if (fragment != null)
            fragment.show(getSupportFragmentManager(), "launch");
    }

}
