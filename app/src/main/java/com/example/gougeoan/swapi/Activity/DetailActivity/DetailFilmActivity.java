package com.example.gougeoan.swapi.Activity.DetailActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gougeoan.swapi.Activity.MainActivity;
import com.example.gougeoan.swapi.Activity.PlanetsActivity;
import com.example.gougeoan.swapi.Data.Film;
import com.example.gougeoan.swapi.Data.Planet;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

/**
 * Created by gougeoan on 17/01/18.
 */

public class DetailFilmActivity extends AppCompatActivity {
    private ListView listView;
    final String myFilm=null;
    private Button button;
    ArrayList<String> details = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        listView=findViewById(R.id.list_view);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainActivity = new Intent(DetailFilmActivity.this, MainActivity.class);
                startActivity(MainActivity);
            }
        });
        if (getIntent().getSerializableExtra(myFilm)!=null){
            Film film= (Film) getIntent().getSerializableExtra(myFilm);
            TextView title = findViewById(R.id.Field1);
            title.setText("Titre : " + film.getTitle());
            TextView model = findViewById(R.id.Field2);
            model.setText("Numero Episode : " + film.getEpisode_id());
        }

    }
}
