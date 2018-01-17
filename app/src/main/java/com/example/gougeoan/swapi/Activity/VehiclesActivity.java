package com.example.gougeoan.swapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gougeoan.swapi.Activity.DetailActivity.DetailSpeciesActivity;
import com.example.gougeoan.swapi.Activity.DetailActivity.DetailVehiclesActivity;
import com.example.gougeoan.swapi.Adapter.AdapterListPlanet;
import com.example.gougeoan.swapi.Adapter.AdapterListSpecie;
import com.example.gougeoan.swapi.Adapter.AdapterListVehicle;
import com.example.gougeoan.swapi.Data.Planet;
import com.example.gougeoan.swapi.Data.Planets;
import com.example.gougeoan.swapi.Data.Specie;
import com.example.gougeoan.swapi.Data.Species;
import com.example.gougeoan.swapi.Data.Vehicle;
import com.example.gougeoan.swapi.Data.Vehicles;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gougeoan on 17/01/18.
 */

public class VehiclesActivity extends AppCompatActivity{

    private final ApiServices apiService = ApiServices.Builder.getInstance();
    final String myVehicule=null;
    private ListView listView;
    private Vehicles vehicles;
    ArrayList<Vehicle> vehiclesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.list_view);

        getVehicles();
    }

    private final void getVehicles(){
        apiService.readVehicles().enqueue(new Callback<Vehicles>() {
            @Override
            public void onResponse(Call<Vehicles> call, Response<Vehicles> response) {
                vehicles = response.body();
                for(int i=0; i<vehicles.getVehicles().size();i++){
                    vehiclesList.add(vehicles.getVehicles().get(i));
                }
                listView.setAdapter(new AdapterListVehicle(VehiclesActivity.this,vehiclesList));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent detailActivity = new Intent(VehiclesActivity.this, DetailVehiclesActivity.class);
                        detailActivity.putExtra(myVehicule,vehiclesList.get(i));
                        startActivity(detailActivity);
                    }
                });
            }


            @Override
            public void onFailure(Call<Vehicles> call, Throwable t) {
                Log.e("TAG", t.getMessage());
                finish();
                Toast.makeText(VehiclesActivity.this,"Request Error",Toast.LENGTH_SHORT).show();
            }
        });
    };
}
