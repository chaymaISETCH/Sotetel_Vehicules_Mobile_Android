package com.example.chayma.sotetel_vehicule;



import android.app.ProgressDialog;
import android.content.Intent;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ListMaintenance extends AppCompatActivity {

    // CONNECTION_TIMEOUT and READ_TIMEOUT are in milliseconds
    public static final int CONNECTION_TIMEOUT=20000;
    public static final int READ_TIMEOUT=30000;
    private EditText etLogin;
    private EditText etPassword;
    public static String prod;
    ListView listView;
    TextView tlibelle,tprix;
    String mat;
    public static ArrayList<Maintenance> liste = new ArrayList<Maintenance>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_list);
        Bundle extras = getIntent().getExtras();
        try {
            mat = extras.getString("mat");
            mat = mat.replace(" ", "%20");
        }
        catch(Exception e){mat=null;}
        new AsyncLogin().execute(null,null);


        //*********************************************
    }
        /*  listView.setOnClickListener(new AdapterView.OnClickListener(){

            @Override
            public void onClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Produits.this,"lib->"+lib[i]+"prix->"+prix[i],Toast.LENGTH_SHORT).show();


    }*/

    // Triggers when LOGIN Button clicked


    class AsyncLogin extends AsyncTask<String, String, String>
    {
        ProgressDialog pdLoading = new ProgressDialog(ListMaintenance.this);
        HttpURLConnection conn;
        URL url = null;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
            Toast.makeText(ListMaintenance.this, "pre", Toast.LENGTH_LONG).show();

        }
        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                if(mat == null) {

                    url = new URL("http://192.168.8.101/sotetel_pfe/Maintenance.php");}
                else{
                    url = new URL("http://192.168.8.101/sotetel_pfe/Maintenance.php?mat="+mat);
                }

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
                conn.setRequestMethod("GET");


                // setDoInput and setDoOutput method depict handling of both send and receive
                // conn.setDoInput(true);


                // Append parameters to URL



                // Open connection for sending data

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
                Toast.makeText(ListMaintenance.this, "Something went wrong. Connection Problem."+e.getMessage(), Toast.LENGTH_LONG).show();

                return "exception";

            } finally {
                conn.disconnect();
            }


        }

        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();

            prod=result;


            try {



                Maintenance V = new Maintenance();
                JSONArray data_array=new JSONArray(prod);

                for (int i = 0 ; i < data_array.length() ; i++)
                {
                    JSONObject obj=new JSONObject(data_array.get(i).toString());


                    Maintenance vv = new Maintenance();

                    vv.setMat(obj.getString("matricule"));
                   // {"num":"1","des":"fjhfhjf","date":"2017-12-01","type":"panne","matricule":"tunis1998"}
                   vv.setNum(obj.getInt("num"));
                    vv.setDate(obj.getString("date"));
                    vv.setType(obj.getString("type"));



                    liste.add(vv);
                    Intent intent = new Intent(ListMaintenance.this, Maintenances.class);
                    startActivity(intent);
                    finish();


                }

            } catch (ParseException e1) {
                e1.printStackTrace();
            }

            catch (JSONException e) {
                e.printStackTrace();
            }



        }
    }

}