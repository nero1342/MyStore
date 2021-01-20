package com.apcs.nero.mystore.ui.store;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apcs.nero.mystore.ui.base.BaseFragment;
import com.apcs.nero.mystore.databinding.FragmentStoreBinding;
import com.apcs.nero.mystore.ui.item.Item;
import com.apcs.nero.mystore.ui.item.ItemAdapter;

import java.util.ArrayList;

public class StoreFragment extends BaseFragment<StoreViewModel, FragmentStoreBinding> {
    private ItemAdapter itemAdapter;
    private ArrayList<Item> listItem = new ArrayList<>();


    public StoreFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initComponents() {
        binding.progressbar.setVisibility(View.GONE);
        binding.recyclerViewListItem.setHasFixedSize(true);
        binding.recyclerViewListItem.setLayoutManager(new LinearLayoutManager(getContext()));
        listItem.add(new Item("None", "None", "No description", "None"));
        listItem.add(new Item("None", "None", "No description", "None"));
        listItem.add(new Item("None", "None", "No description", "None"));
        listItem.add(new Item("None", "None", "No description", "None"));
        listItem.add(new Item("None", "None", "No description", "None"));
        itemAdapter = new ItemAdapter(getContext(), getActivity(), listItem);
        binding.recyclerViewListItem.setAdapter(itemAdapter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents();
    }


    @Override
    protected Class<StoreViewModel> getViewModel() {
        return StoreViewModel.class;
    }

    @Override
    protected FragmentStoreBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentStoreBinding.inflate(inflater, container, false);
    }
}