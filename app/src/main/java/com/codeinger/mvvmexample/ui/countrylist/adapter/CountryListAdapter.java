package com.codeinger.mvvmexample.ui.countrylist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.codeinger.mvvmexample.R;
import com.codeinger.mvvmexample.api.pojo.Country;
import com.squareup.picasso.Picasso;

import java.util.List;

import io.reactivex.annotations.NonNull;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.CountryListViewHolder> {

    private List<Country> listOfPopulation;
    private Context context;

    public CountryListAdapter(List<Country> listOfPopulation, Context context) {
        this.listOfPopulation = listOfPopulation;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CountryListViewHolder(LayoutInflater.from(context).inflate(R.layout.single_country_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CountryListViewHolder customRecyclerViewHolder, int i) {
        customRecyclerViewHolder.bind(listOfPopulation.get(i));
    }

    @Override
    public int getItemCount() {
        return listOfPopulation.size();
    }

    class CountryListViewHolder extends RecyclerView.ViewHolder{

        View view;
        TextView countryName,countryPopulationCount,countryRank;
        ImageView countryFlag;

        CountryListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.view = itemView;
            countryFlag = view.findViewById(R.id.img_flag);
            countryName = view.findViewById(R.id.txt_country_name);
            countryRank = view.findViewById(R.id.txt_rank);
            countryPopulationCount = view.findViewById(R.id.txt_population);
        }

        void bind(Country country){
            countryName.setText(country.getCountry());
            countryPopulationCount.setText(country.getPopulation());
            countryRank.setText(String.valueOf(country.getRank()));
            Picasso.get().load(country.getFlag()).into(countryFlag);
        }
    }
}
