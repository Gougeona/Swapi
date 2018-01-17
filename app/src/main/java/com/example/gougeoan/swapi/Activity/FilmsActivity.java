package com.example.gougeoan.swapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gougeoan.swapi.Activity.DetailActivity.DetailFilmActivity;
import com.example.gougeoan.swapi.Activity.DetailActivity.DetailSpaceshipActivity;
import com.example.gougeoan.swapi.Adapter.AdapterListFilm;
import com.example.gougeoan.swapi.Data.Film;
import com.example.gougeoan.swapi.Data.Films;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gougeoan on 17/01/18.
 */

public class FilmsActivity extends AppCompatActivity{

    private final ApiServices apiService = ApiServices.Builder.getInstance();
    final String myFilm=null;
    private ListView listView;
    private Films films;
    ArrayList<Film> filmList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.list_view);

        getFilms();
    }

    private final void getFilms(){
        apiService.readFilms().enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                films = response.body();
                for(int i=0; i<films.getFilm().size();i++){
                    filmList.add(films.getFilm().get(i));
                }
                listView.setAdapter(new AdapterListFilm(FilmsActivity.this,filmList));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent detailActivity = new Intent(FilmsActivity.this, DetailFilmActivity.class);
                        detailActivity.putExtra(myFilm,filmList.get(i));
                        startActivity(detailActivity);
                    }
                });
            }


            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                Log.e("TAG", t.getMessage());
                finish();
                Toast.makeText(FilmsActivity.this,"Request Error",Toast.LENGTH_SHORT).show();
            }
        });
    };
}
