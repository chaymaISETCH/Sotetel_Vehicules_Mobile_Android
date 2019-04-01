package com.example.chayma.sotetel_vehicule;
  import android.os.Bundle;
import android.os.Handler;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
  import android.view.KeyEvent;
  import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    public class MyReceiver extends BroadcastReceiver {
        public static final String ACTION_RESP = "com.myapp.intent.action.TEXT_TO_DISPLAY";

        @Override
        public void onReceive(Context context, Intent intent) {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Main2Activity.this);

            String f = preferences.getString("fonction", "");

            if(f.equalsIgnoreCase("Chef Parc") || f.equalsIgnoreCase("Directeur")) {
                Intent msgIntent = new Intent(context, ServiceNotif.class);

                msgIntent.putExtra(ServiceNotif.URL, "http://10.0.2.2/test/i.php");

                context.startService(msgIntent);

                Intent msgIntent2 = new Intent(context, ServiceNotifVisite.class);

                msgIntent.putExtra(ServiceNotif.URL, "http://10.0.2.2/test/i.php");

                context.startService(msgIntent2);
            }







        }
    }

    private MyReceiver receiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);









        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(Main2Activity.this);

                String login = preferences.getString("login", "");
                String f = preferences.getString("fonction", "");
                String pass = preferences.getString("pass", "");
                Toast.makeText(Main2Activity.this, login + " " + pass, Toast.LENGTH_LONG).show();
                if (login.equals("")) {
                    Intent intent_next = new Intent(Main2Activity.this, MainActivity.class);
                    startActivity(intent_next);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                    finish();
                } else {
                    //*********************************************************
                    if(f.equalsIgnoreCase("Chef Projet")) {
                        Intent intent_next = new Intent(Main2Activity.this, MenuChefProjet.class);
                        startActivity(intent_next);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                        finish();
                    }
                    else   if(f.equalsIgnoreCase("Chef Parc")) {
                        Intent intent_next = new Intent(Main2Activity.this, MenuChefParc.class);
                        startActivity(intent_next);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                        finish();
                    }
                    else   if(f.equalsIgnoreCase("responsable RH")) {
                        Intent intent_next = new Intent(Main2Activity.this, MenuRH.class);
                        startActivity(intent_next);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                        finish();
                    }
                    else   if(f.equalsIgnoreCase("Directeur")) {
                        Intent intent_next = new Intent(Main2Activity.this, MenuDirecteur.class);
                        startActivity(intent_next);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                        finish();
                    }




                    //*************************************************************

                }
            }
        }, 2500);















    }
}
//*************************************************************

