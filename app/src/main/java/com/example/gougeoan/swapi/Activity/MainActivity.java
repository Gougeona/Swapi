package com.example.gougeoan.swapi.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.gougeoan.swapi.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton planets;
    private ImageButton vehicles;
    private ImageButton people;
    private ImageButton spaceships;
    private ImageButton films;
    private ImageButton species;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        planets = findViewById(R.id.imageButtonPlanets);
        vehicles = findViewById(R.id.imageButtonVehicles);
        people = findViewById(R.id.imageButtonPeople);
        spaceships = findViewById(R.id.imageButtonSpaceships);
        films = findViewById(R.id.imageButtonFilms);
        species= findViewById(R.id.imageButtonSpecies);

        planets.setOnClickListener(OnPlanetButtonClicked);
        vehicles.setOnClickListener(OnVehiclesButtonClicked);
        people.setOnClickListener(OnPeopleButtonClicked);
        spaceships.setOnClickListener(OnSpaceshipsButtonCLicked);
        films.setOnClickListener(OnFilmsButtonClicked);
        species.setOnClickListener(OnSpeciesButtonClicked);
    }


    private final View.OnClickListener OnPlanetButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent planetActivity = new Intent(MainActivity.this, PlanetsActivity.class);
            startActivity(planetActivity);
        }
    };
    private final View.OnClickListener OnVehiclesButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent planetActivity = new Intent(MainActivity.this, VehiclesActivity.class);
            startActivity(planetActivity);
        }
    };
    private final View.OnClickListener OnPeopleButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent planetActivity = new Intent(MainActivity.this, PeopleActivity.class);
            startActivity(planetActivity);
        }
    };

    private final View.OnClickListener OnSpaceshipsButtonCLicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent planetActivity = new Intent(MainActivity.this, SpaceshipsActivity.class);
            startActivity(planetActivity);
        }
    };

    private final View.OnClickListener OnFilmsButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent planetActivity = new Intent(MainActivity.this, FilmsActivity.class);
            startActivity(planetActivity);
        }
    };

    private final View.OnClickListener OnSpeciesButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent planetActivity = new Intent(MainActivity.this, SpeciesActivity.class);
            startActivity(planetActivity);
        }
    };
}
