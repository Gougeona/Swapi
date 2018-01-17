package com.example.gougeoan.swapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gougeoan.swapi.Activity.DetailActivity.DetailFilmActivity;
import com.example.gougeoan.swapi.Activity.DetailActivity.DetailPeopleActivity;
import com.example.gougeoan.swapi.Adapter.AdapterListCharactere;
import com.example.gougeoan.swapi.Adapter.AdapterListFilm;
import com.example.gougeoan.swapi.Data.Charactere;
import com.example.gougeoan.swapi.Data.Film;
import com.example.gougeoan.swapi.Data.Films;
import com.example.gougeoan.swapi.Data.People;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by gougeoan on 17/01/18.
 */

public class PeopleActivity extends AppCompatActivity{

    private final ApiServices apiService = ApiServices.Builder.getInstance();
    final String myPeople=null;
    private ListView listView;
    private People people;
    ArrayList<Charactere> charactereList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView=findViewById(R.id.list_view);

        getPeople();
    }

    private final void getPeople(){
        apiService.readPeople().enqueue(new Callback<People>() {
            @Override
            public void onResponse(Call<People> call, Response<People> response) {
                people = response.body();
                for(int i=0; i<people.getCharactere().size();i++){
                    charactereList.add(people.getCharactere().get(i));
                }
                listView.setAdapter(new AdapterListCharactere(PeopleActivity.this,charactereList));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent detailActivity = new Intent(PeopleActivity.this, DetailPeopleActivity.class);
                        detailActivity.putExtra(myPeople,charactereList.get(i));
                        startActivity(detailActivity);
                    }
                });
            }

            @Override
            public void onFailure(Call<People> call, Throwable t) {
                Log.e("TAG", t.getMessage());
                finish();
                Toast.makeText(PeopleActivity.this,"Request Error",Toast.LENGTH_SHORT).show();
            }
        });
    };
}
