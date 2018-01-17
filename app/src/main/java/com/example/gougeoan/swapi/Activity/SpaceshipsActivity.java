package com.example.gougeoan.swapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gougeoan.swapi.Activity.DetailActivity.DetailSpaceshipActivity;
import com.example.gougeoan.swapi.Adapter.AdapterListSpaceship;
import com.example.gougeoan.swapi.Data.Spaceship;
import com.example.gougeoan.swapi.Data.Spaceships;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gougeoan on 17/01/18.
 */

public class SpaceshipsActivity extends AppCompatActivity{

    private final ApiServices apiService = ApiServices.Builder.getInstance();
    final String mySpaceship=null;
    private ListView listView;
    private Spaceships spaceships;
    ArrayList<Spaceship> spaceshipList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.list_view);

        getSpaceships();
    }

    private final void getSpaceships(){
        apiService.readSpaceships().enqueue(new Callback<Spaceships>() {
            @Override
            public void onResponse(Call<Spaceships> call, Response<Spaceships> response) {
                spaceships = response.body();
                for(int i=0; i<spaceships.getSpaceship().size();i++){
                    spaceshipList.add(spaceships.getSpaceship().get(i));
                }
                listView.setAdapter(new AdapterListSpaceship(SpaceshipsActivity.this,spaceshipList));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent detailActivity = new Intent(SpaceshipsActivity.this, DetailSpaceshipActivity.class);
                        detailActivity.putExtra(mySpaceship,spaceshipList.get(i));
                        startActivity(detailActivity);
                    }
                });
            }


            @Override
            public void onFailure(Call<Spaceships> call, Throwable t) {
                Log.e("TAG", t.getMessage());
                finish();
                Toast.makeText(SpaceshipsActivity.this,"Request Error",Toast.LENGTH_SHORT).show();
            }
        });
    };
}
