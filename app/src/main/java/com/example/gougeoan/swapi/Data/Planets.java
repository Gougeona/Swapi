package com.example.gougeoan.swapi.Data;

import com.example.gougeoan.swapi.Data.Planet;

import java.util.ArrayList;

/**
 * Created by gougeoan on 17/01/18.
 */

public class Planets {

    private int count;
    private String next;
    private String previous;
    private ArrayList<Planet> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<Planet> getPlanet() {
        return results;
    }

    public void setPlanet(ArrayList<Planet> planet) {
        results = planet;
    }
}
