package com.example.chayma.sotetel_vehicule;
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
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class SpinnerAct extends Activity implements OnItemSelectedListener{
    Spinner spinner;
  public static   String c,s,m;
    public  static  String item;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Bundle extras = getIntent().getExtras();
        try {
            c = extras.getString("carte");
            s = extras.getString("solde");
            m = extras.getString("matC");
        }
        catch(Exception e){c=null;}
        TextView t1 = (TextView) findViewById(R.id.num);
        TextView t2 = (TextView) findViewById(R.id.solde);
        t1.setText(c);
        t2.setText(s + " DT");


Button b  = (Button) findViewById(R.id.val);




        // Spinner element
         spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> vehicules = ListMat.liste;


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, vehicules);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
        Toast.makeText(SpinnerAct.this,m+ "Selected: " + ListMat.liste.indexOf(m), Toast.LENGTH_LONG).show();

      spinner.setSelection(ListMat.liste.indexOf(m));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
spinner.setSelection(position);
        // Showing selected spinner item
        Button b  = (Button) findViewById(R.id.val);
        b.setClickable(true);
SpinnerAct.item=item;

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SpinnerAct.this, "Selected: " + SpinnerAct.item, Toast.LENGTH_LONG).show();
                try {

                    SpinnerAct.item = SpinnerAct.item.replace(" ", "%20");
                }
                catch(Exception e){}
                new AsyncLogin().execute(SpinnerAct.c, SpinnerAct.item);
            }
        });


        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }









    private class AsyncLogin extends AsyncTask<String, String, String>
    {public String login;
        public String pass;
        ProgressDialog pdLoading = new ProgressDialog(SpinnerAct.this);
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
                url = new URL("http://192.168.8.102/sotetel_pfe/affecter_carte.php?num="+params[0]+"&mat="+params[1]);
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

                conn.setReadTimeout(5000);
                conn.setConnectTimeout(5000);
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
                Toast.makeText(SpinnerAct.this, "Something went wrong. Connection Problem."+e.getMessage(), Toast.LENGTH_LONG).show();

                return "exception";

            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {



            pdLoading.dismiss();
            if(result.equalsIgnoreCase("true"))
            {
                Toast.makeText(SpinnerAct.this, "Opération effectuée avec succès", Toast.LENGTH_LONG).show();




            }else if (result.equalsIgnoreCase("false")){

                Toast.makeText(SpinnerAct.this, "", Toast.LENGTH_LONG).show();

            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(SpinnerAct.this, "Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();

            }
        }

    }


}