package com.schocktopia.systemshock.algebrahellolibrary.presenter;

import com.raizlabs.android.dbflow.sql.language.Select;
import com.schocktopia.systemshock.algebrahellolibrary.model.Books;
import com.schocktopia.systemshock.algebrahellolibrary.model.Books_Table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 20/04/16.
 */
public class DBManager {
    //TODO: all the things

    // hash of data being selected from model. Key = table name, value = table row data
    // allRows hash to hold all rows as individual hashes
    Map<String, List<String>> outboundData = new HashMap<String, List<String>>();
    Map<Long, HashMap<String, List<String>>> allRows =
            new HashMap<Long, HashMap<String, List<String>>>();

    // hash of data being inserted into model. Key = table name, value = table row data
    Map<String, List<String>> inboundData = new HashMap<String, List<String>>();

    public DBManager() {

    }

    // get a number of records in order to loop through the table
    // and fill hashes with data
    public long getNumberOfRecords() {
        long num = 0;

        num = new Select().from(Books.class).count();

        return num;
    }

    public Map<Long, HashMap<String, List<String>>> getAllBooks() {

        for(long i = 0; i < this.getNumberOfRecords(); i++) {
            allRows.put(i, this.getBookData(i + 1));
        }

        return allRows;
    }

    public HashMap<String, List<String>> getBookData(long position) {
        HashMap<String, List<String>> data = new HashMap<String, List<String>>();
        List<String> row = new ArrayList<String>();

        //data.put("book")

        return data;
    }
}
