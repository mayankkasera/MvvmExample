package com.codeinger.mvvmexample.ui.countrylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.codeinger.mvvmexample.R;
import com.codeinger.mvvmexample.api.pojo.Country;
import com.codeinger.mvvmexample.api.repo.CountryRepository;
import com.codeinger.mvvmexample.databinding.ActivityCountryListBinding;
import com.codeinger.mvvmexample.ui.countrylist.adapter.CountryListAdapter;

import java.util.List;

public class CountryListActivity extends AppCompatActivity {

    ActivityCountryListBinding databinding;
    CountryListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setObservers();
        onClicks();
    }

    private void init() {
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_country_list);
        viewModel = ViewModelProviders.of(this).get(CountryListViewModel.class);
        viewModel.setRepositoryI(new CountryRepository());
        viewModel.getCountryList();
    }

    private void setObservers() {
        viewModel.state.observe(this, new Observer<CountryState>() {
            @Override
            public void onChanged(CountryState countryState) {
                setUiState(countryState);
                if (countryState.getCountryListSuccess())
                    setRecyclerView(countryState.getCountries());
            }
        });
    }

    private void setUiState(CountryState countryState) {
        databinding.setState(countryState);
    }

    private void onClicks() {
        databinding.btnLoadList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.getCountryList();
            }
        });
    }

    private void setRecyclerView(List<Country> countries) {
        databinding.flagListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        databinding.flagListRecyclerView.setAdapter(new CountryListAdapter(countries, this));
    }
}
