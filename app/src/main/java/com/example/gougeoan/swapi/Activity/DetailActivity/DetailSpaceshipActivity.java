package com.example.gougeoan.swapi.Activity.DetailActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gougeoan.swapi.Activity.MainActivity;
import com.example.gougeoan.swapi.Data.Spaceship;
import com.example.gougeoan.swapi.Data.Spaceships;
import com.example.gougeoan.swapi.R;

import java.util.ArrayList;

/**
 * Created by gougeoan on 17/01/18.
 */

public class DetailSpaceshipActivity extends AppCompatActivity {

    private ListView listView;
    final String mySpaceship=null;
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
                Intent MainActivity = new Intent(DetailSpaceshipActivity.this, com.example.gougeoan.swapi.Activity.MainActivity.class);
                startActivity(MainActivity);
            }
        });
        if (getIntent().getSerializableExtra(mySpaceship)!=null){
            Spaceship mySpaceShip= (Spaceship)getIntent().getSerializableExtra(mySpaceship);
            TextView title = findViewById(R.id.Field1);
            title.setText("Nom : " + mySpaceShip.getName());
            TextView model = findViewById(R.id.Field2);
            model.setText("Modele : " + mySpaceShip.getModel());
        }

    }
}
