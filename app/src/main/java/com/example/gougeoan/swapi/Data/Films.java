package com.example.gougeoan.swapi.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gougeoan on 17/01/18.
 */

public class Films {
    private int count;
    private String next;
    private String previous;
    private ArrayList<Film> results;

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

    public ArrayList<Film> getFilm() {
        return results;
    }

    public void setFilm(ArrayList<Film> results) {
        this.results = results;
    }
}
