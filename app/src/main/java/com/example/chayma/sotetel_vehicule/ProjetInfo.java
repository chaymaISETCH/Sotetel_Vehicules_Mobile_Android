package com.example.chayma.sotetel_vehicule;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.widget.ImageView;
        import android.widget.TextView;


public class ProjetInfo extends AppCompatActivity {
    Projet v = Projets.projet;
    TextView code,lib,duree,date_deb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projet_info);

       code=(TextView) findViewById(R.id.code);
        lib=(TextView) findViewById(R.id.lib);
        duree=(TextView) findViewById(R.id.duree);
        date_deb=(TextView) findViewById(R.id.date_deb);


        code.setText(" "+v.getCode());
        lib.setText(" "+v.getLib());
        duree.setText(""+v.getDuree());
        date_deb.setText(" "+v.getDate_deb());


    }
}


