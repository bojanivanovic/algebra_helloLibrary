package com.schocktopia.systemshock.algebrahellolibrary.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by root on 15/04/16.
 */
@Table(database = MainLibraryDatabase.class)
public class BooksAuthors extends BaseModel {

    @Column
    @PrimaryKey(autoincrement = true)
    int id;

    @Column
    @ForeignKey(saveForeignKeyModel = true)
    Books books;

    @Column
    @ForeignKey(saveForeignKeyModel = true)
    Authors authors;

    public void setBooks(Books books) {
        this.books = books;
    }

    public void setAuthors(Authors authors) {
        this.authors = authors;
    }
}
