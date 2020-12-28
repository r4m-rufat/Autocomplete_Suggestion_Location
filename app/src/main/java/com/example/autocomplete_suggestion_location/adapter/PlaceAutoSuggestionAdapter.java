package com.example.autocomplete_suggestion_location.adapter;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;


import com.example.autocomplete_suggestion_location.models.PlaceApi;

import java.util.ArrayList;

public class PlaceAutoSuggestionAdapter extends ArrayAdapter implements Filterable {

    ArrayList<String> arrayList;
    Context context;
    PlaceApi placeApi = new PlaceApi();

    public PlaceAutoSuggestionAdapter(Context context, int resId) {
        super(context, resId);
        this.context = context;
    }


    @Override
    public int getCount(){

        return arrayList.size();

    }

    @Override
    public String getItem(int position){

        return arrayList.get(position);

    }

    @Override
    public Filter getFilter(){

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null){

                    arrayList = placeApi.autoComplete(constraint.toString());

                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();

                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {

                if (results != null && results.count > 0){

                    notifyDataSetChanged();

                }else {

                    notifyDataSetInvalidated();

                }

            }

        };

        return filter;

    }



}
