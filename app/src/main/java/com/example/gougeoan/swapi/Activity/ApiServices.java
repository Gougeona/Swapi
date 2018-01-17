package com.example.gougeoan.swapi.Activity;

import com.example.gougeoan.swapi.BuildConfig;
import com.example.gougeoan.swapi.Data.Films;
import com.example.gougeoan.swapi.Data.People;
import com.example.gougeoan.swapi.Data.Planets;
import com.example.gougeoan.swapi.Data.Spaceships;
import com.example.gougeoan.swapi.Data.Species;
import com.example.gougeoan.swapi.Data.Vehicles;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by gougeoan on 17/01/18.
 */

public interface ApiServices {

    @GET("planets")
    Call<Planets> readPlanets();

    @GET("vehicles")
    Call<Vehicles> readVehicles();

    @GET("people")
    Call<People> readPeople();

    @GET("films")
    Call<Films> readFilms();

    @GET("species")
    Call<Species> readSpecies();

    @GET("starships")
    Call<Spaceships> readSpaceships();


    class Builder {
        private static final ApiServices instance = build();

        public static ApiServices getInstance() {
            return instance;
        }

        private static ApiServices build() {
            final Gson gson = new GsonBuilder().create();

            final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(new HttpLoggingInterceptor()
                            .setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {
                            final Request resquest = chain.request().newBuilder()
                                    .addHeader("Accept", "application/json").build();
                            return chain.proceed(resquest);
                        }
                    })
                    .build();

            return new Retrofit.Builder()
                    .baseUrl(" https://swapi.co/api/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
                    .create(ApiServices.class);
        }

    }
}
