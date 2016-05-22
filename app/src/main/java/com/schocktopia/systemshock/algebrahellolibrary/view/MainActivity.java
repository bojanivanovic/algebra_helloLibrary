package com.schocktopia.systemshock.algebrahellolibrary.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.schocktopia.systemshock.algebrahellolibrary.model.Authors;
import com.schocktopia.systemshock.algebrahellolibrary.model.Books;
import com.schocktopia.systemshock.algebrahellolibrary.model.BooksAuthors;
import com.schocktopia.systemshock.algebrahellolibrary.model.MainLibraryDatabase;
import com.schocktopia.systemshock.algebrahellolibrary.presenter.RecyclerViewAdapter;
import com.schocktopia.systemshock.algebrahellolibrary.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	// define recyclerview objects
	private RecyclerView recyclerView;
	private RecyclerView.Adapter adapter;
	private RecyclerView.LayoutManager layoutManager;

	// define dataset variables
	private List<List<String>> data;
	private List<String> books;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FlowManager.init(new FlowConfig.Builder(this).build());
		setContentView(R.layout.activity_main);

		data = new ArrayList<List<String>>();
		books = new ArrayList<String>(2);

		books.add(0, "Lord of the Rings");
		books.add(1, "J.R.R. Tolkien");
		

		data.add(new ArrayList<String>(books));

		books.set(0, "The Martian");
		books.set(1, "Andy Weird");

		data.add(new ArrayList<String>(books));

		books.set(0, "Do Androids Dream of Electric Sheep");
		books.set(1, "Philip K. Dick");

		data.add(new ArrayList<String>(books));

		books.set(0, "Fallen Angels");
		books.set(1, "Mike Lee");

		data.add(new ArrayList<String>(books));

		books.set(0, "The Wizard of Earthsea");
		books.set(1, "Ursula K. Le Guin");

		data.add(new ArrayList<String>(books));

		books.set(0, "Guards! Guards!");
		books.set(1, "Terry Pratchett");

		data.add(new ArrayList<String>(books));

		books.set(0, "Foundation");
		books.set(1, "Isaac Asimov");

		data.add(new ArrayList<String>(books));

		books.set(0, "Look to Windward");
		books.set(1, "Iain M. Banks");

		data.add(new ArrayList<String>(books));

		books.set(0, "Consider Phlebas");

		data.add(new ArrayList<String>(books));

		books.set(0, "Armageddon Rag");
		books.set(1, "George R.R. Martin");

		data.add(new ArrayList<String>(books));

		Books book1 = new Books();
		book1.setName("Foundation and Empire");
		book1.save();

		Authors author1 = new Authors();
		author1.setFirstName("Isaac");
		author1.setLastName("Asimov");
		author1.save();

		BooksAuthors bookAuthor1 = new BooksAuthors();
		bookAuthor1.setBooks(book1);
		bookAuthor1.setAuthors(author1);
		bookAuthor1.save();

		List<Books> booksList = new Select().from(Books.class).queryList();
		List<Authors> authorsList = new Select().from(Authors.class).queryList();

		for (Books book: booksList) {
			System.out.println(book.getName());
		}

		for (Authors author: authorsList) {
			System.out.println(author.getFirstName() + " " + author.getLastName());
		}

        DatabaseDefinition database = FlowManager.getDatabase(MainLibraryDatabase.class);
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                called.set(true);
            }
        }).build();

        transaction.execute();

		FlowQueryList<Books> booksTable = SQLite.select()
                .from(Books.class)
                .flowQueryList();

        Log.d("flowquerylist", booksTable.get(0).toString() + booksTable.get(1).toString());

		recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
		recyclerView.setHasFixedSize(true);
		layoutManager = new LinearLayoutManager(this);
		recyclerView.setLayoutManager(layoutManager);
		adapter = new RecyclerViewAdapter(data);
		recyclerView.setAdapter(adapter);
	}


}
