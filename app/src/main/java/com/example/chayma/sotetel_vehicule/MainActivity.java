package com.example.chayma.sotetel_vehicule;

import android.content.SharedPreferences;
import android.net.ParseException;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;



import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;


public class MainActivity extends AppCompatActivity  {
    public static final int CONNECTION_TIMEOUT=10000;
    public static final int READ_TIMEOUT=15000;
    private EditText etLogin;
    private EditText etPassword;
    private TextView t1;
    private Button b;
    private String recup1, recup2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get Reference to variables
        etLogin = (EditText) findViewById(R.id.login);
        etPassword = (EditText) findViewById(R.id.password);
        b=(Button)findViewById(R.id.button);




        b.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (etLogin.getText().length()==0){
                    etLogin.setError("Remplir ce champ");}
                else if (etPassword.getText().length()==0){
                    etPassword.setError("Remplir ce champ");
                }
                else{


                    checkLogin();
                }
            }       });
    }



    // Triggers when LOGIN Button clicked
    public void checkLogin() {

        // Get text from email and passord fieldgetDraw);
        final String login = etLogin.getText().toString();
        final String password = etPassword.getText().toString();

        // Initialize  AsyncLogin() class with email and password
        new AsyncLogin().execute(login,password);

    }

    private class AsyncLogin extends AsyncTask<String, String, String>
    {public String login;
        public String pass;
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);
        HttpURLConnection conn;
        URL url = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }
        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL("http://192.168.8.101/sotetel_pfe/login.php?login="+params[0]+"&password="+params[1]);
login=params[0];
                pass=params[1];

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection)url.openConnection();

                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("login", params[0])
                        .appendQueryParameter("password", params[1]);
                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return(result.toString());

                }else{

                    return("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Something went wrong. Connection Problem."+e.getMessage(), Toast.LENGTH_LONG).show();

                return "exception";

            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {



            pdLoading.dismiss();
            if(! result.equalsIgnoreCase("false"))
            {  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("login",login);
                editor.putString("pass",pass);

                //********************************************************************************


                try {


                    JSONArray data_array=new JSONArray(result);

                    for (int i = 0 ; i < data_array.length() ; i++)
                    {
                        JSONObject obj=new JSONObject(data_array.get(i).toString());

                        editor.putString("fonction", obj.getString("fonction"));

                        editor.commit();


                        String f = preferences.getString("fonction", "");
//String f = obj.getString("fonction");
if(f.equalsIgnoreCase("Chef Projet")) {
    Intent intent_next = new Intent(MainActivity.this, MenuChefProjet.class);
    startActivity(intent_next);
    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    finish();
}
                     else   if(f.equalsIgnoreCase("Chef Parc")) {
                            Intent intent_next = new Intent(MainActivity.this, MenuChefParc.class);
                            startActivity(intent_next);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                            finish();
                        }
                     else   if(f.equalsIgnoreCase("responsable RH")) {
                            Intent intent_next = new Intent(MainActivity.this, MenuRH.class);
                            startActivity(intent_next);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                            finish();
                        }
                     else   if(f.equalsIgnoreCase("Directeur")) {
                            Intent intent_next = new Intent(MainActivity.this, MenuDirecteur.class);
                            startActivity(intent_next);
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                            finish();
                        }


                    }

                } catch (ParseException e1) {
                    e1.printStackTrace();
                }

                catch (JSONException e) {
                    e.printStackTrace();
                }































                //*********************************************************************************













            }else if (result.equalsIgnoreCase("false")){

                Toast.makeText(MainActivity.this, "Invalid login or password", Toast.LENGTH_LONG).show();

            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(MainActivity.this, "Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();

            }
        }

    }


}

