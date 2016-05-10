package com.schocktopia.systemshock.myrecyclerviewtutorial01.presenter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.schocktopia.systemshock.myrecyclerviewtutorial01.R;

import java.util.List;
import java.util.Map;

/**
 * Created by systemshock on 16/03/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
	//dataset that provides data for the views in RecyclerView
	private Map<Integer, String> bookDataset;
	private Map<Integer, String> authorDataset;
	private List<List<String>> dataset;

	//a class that holds access to the required Views
	public static class ViewHolder extends RecyclerView.ViewHolder {
		public CardView cardView;
		public ViewHolder(View v) {
			super(v);
			cardView = (CardView)v;
		}
	}

//	public MyAdapter(Map<Integer, String> dataset, Map<Integer, String> authors){
//		bookDataset = dataset;
//		authorDataset = authors;
//	}

	public MyAdapter(List<List<String>> data){
		dataset = data;
	}

	//creating Views as invoked by LayoutManager
	@Override
	public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.my_text_view, parent, false);

		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	//replacing a View's content, invoked by LayoutManager
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		//get data from dataset at this position and replace the target
		TextView tv = (TextView)holder.cardView.getChildAt(0);
		TextView tv2 = (TextView)holder.cardView.getChildAt(1);
//
//		tv.setText(bookDataset.get(position));
//		tv2.setText(authorDataset.get(position));

		tv.setText(dataset.get(position).get(0));
		tv2.setText(dataset.get(position).get(1));

	}

	//return the size of the dataset, needed by LayoutManager
	@Override
	public int getItemCount() {
		return dataset.size();
	}
}
