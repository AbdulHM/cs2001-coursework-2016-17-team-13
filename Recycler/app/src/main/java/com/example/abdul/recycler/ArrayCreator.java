package com.example.abdul.recycler;

import java.util.ArrayList;

/**
 * Created by Abdul on 25/02/2017.
 */

public class ArrayCreator {
    final ArrayList<String> numbers = new ArrayList<>();

    public ArrayList<String> createArray(){

        numbers.add("Michael");
        numbers.add("Dave");
        numbers.add("James");
        numbers.add("Abdul");
        numbers.add("Horse");


        return numbers;

    }
}
