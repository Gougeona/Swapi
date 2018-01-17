package com.example.gougeoan.swapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gougeoan.swapi.Activity.DetailActivity.DetailPlanetActivity;
import com.example.gougeoan.swapi.Activity.DetailActivity.DetailSpeciesActivity;
import com.example.gougeoan.swapi.Adapter.AdapterListPlanet;
import com.example.gougeoan.swapi.Adapter.AdapterListSpecie;
import com.example.gougeoan.swapi.Data.Planet;
import com.example.gougeoan.swapi.Data.Planets;
import com.example.gougeoan.swapi.Data.Specie;
import com.example.gougeoan.swapi.Data.Species;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gougeoan on 17/01/18.
 */

public class SpeciesActivity extends AppCompatActivity{

    private final ApiServices apiService = ApiServices.Builder.getInstance();
    final String mySpecie=null;
    private ListView listView;
    private Species species;
    ArrayList<Specie> speciesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.list_view);

        getSpecies();
    }

    private final void getSpecies(){
        apiService.readSpecies().enqueue(new Callback<Species>() {
            @Override
            public void onResponse(Call<Species> call, Response<Species> response) {
                species = response.body();
                for(int i=0; i<species.getSpecie().size();i++){
                    speciesList.add(species.getSpecie().get(i));
                }
                listView.setAdapter(new AdapterListSpecie(SpeciesActivity.this,speciesList));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent detailActivity = new Intent(SpeciesActivity.this, DetailSpeciesActivity.class);
                        detailActivity.putExtra(mySpecie,speciesList.get(i));
                        startActivity(detailActivity);
                    }
                });
            }


            @Override
            public void onFailure(Call<Species> call, Throwable t) {
                Log.e("TAG", t.getMessage());
                finish();
                Toast.makeText(SpeciesActivity.this,"Request Error",Toast.LENGTH_SHORT).show();
            }
        });
    };
}
