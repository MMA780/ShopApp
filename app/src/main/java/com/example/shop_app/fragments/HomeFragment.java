package com.example.shop_app.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shop_app.BestItemsAdapter;
import com.example.shop_app.R;
import com.example.shop_app.SliderAdapter;


import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // داده‌های فیک برای اسلایدر
        List<Integer> sliderImages = Arrays.asList(R.drawable.image, R.drawable.image, R.drawable.image);

        // تنظیم ViewPager2 برای اسلایدر
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPagerSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(sliderImages);
        viewPager2.setAdapter(sliderAdapter);

        // داده‌های فیک برای بهترین‌ها
        List<String> bestItems = Arrays.asList("محصول ۱", "محصول ۲", "محصول ۳", "محصول ۴");

        // تنظیم RecyclerView برای بهترین‌ها
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewBestItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        BestItemsAdapter bestItemsAdapter = new BestItemsAdapter(bestItems);
        recyclerView.setAdapter(bestItemsAdapter);

        return view;
    }
}
