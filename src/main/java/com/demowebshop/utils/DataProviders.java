package com.demowebshop.utils;

import com.demowebshop.models.User;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider
    public Iterator<Object[]> registretionUserWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/Names.csv")));

        String line = reader.readLine();
        while (line!=null){
            String[] strings = line.split(",");
            list.add(new Object[]{strings[0],strings[1],strings[2],strings[3],strings[4]});

            line = reader.readLine();}

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> newRegistrationData(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Oliver", "Kan", "kan656@gmail.com", "Aa11111!", "Aa11111!"});
        list.add(new Object[]{"Sergey", "Perlov", "sergius656@gmail.com", "Aa95111!", "Aa95111!"});
        list.add(new Object[]{"Alex", "Man", "aman656@gmail.com", "Aa16611!", "Aa16611!"});
        return list.iterator();
    }
}
