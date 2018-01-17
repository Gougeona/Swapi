package com.example.gougeoan.swapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gougeoan.swapi.Activity.DetailActivity.DetailPeopleActivity;
import com.example.gougeoan.swapi.Activity.DetailActivity.DetailPlanetActivity;
import com.example.gougeoan.swapi.Adapter.AdapterListPlanet;
import com.example.gougeoan.swapi.Data.Planet;
import com.example.gougeoan.swapi.Data.Planets;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gougeoan on 17/01/18.
 */

public class PlanetsActivity extends AppCompatActivity{

    private final ApiServices apiService = ApiServices.Builder.getInstance();
    final String myPlanet=null;
    private ListView listView;
    private Planets planets;
    ArrayList<Planet> planetsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.list_view);

        getPlanets();
    }

    private final void getPlanets(){
        apiService.readPlanets().enqueue(new Callback<Planets>() {
            @Override
            public void onResponse(Call<Planets> call, Response<Planets> response) {
                planets = response.body();
                for(int i=0; i<planets.getPlanet().size();i++){
                    planetsList.add(planets.getPlanet().get(i));
                }
                listView.setAdapter(new AdapterListPlanet(PlanetsActivity.this,planetsList));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent detailActivity = new Intent(PlanetsActivity.this, DetailPlanetActivity.class);
                        detailActivity.putExtra(myPlanet,planetsList.get(i));
                        startActivity(detailActivity);
                    }
                });
            }


            @Override
            public void onFailure(Call<Planets> call, Throwable t) {
                Log.e("TAG", t.getMessage());
                finish();
                Toast.makeText(PlanetsActivity.this,"Request Error",Toast.LENGTH_SHORT).show();
            }
        });
    };
}
