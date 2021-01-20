package com.apcs.nero.mystore.ui.manager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apcs.nero.mystore.ui.base.BaseFragment;
import com.apcs.nero.mystore.databinding.FragmentManagerBinding;
import com.apcs.nero.mystore.ui.item.Item;
import com.apcs.nero.mystore.ui.item.ItemAdapter;

import java.util.ArrayList;

public class ManagerFragment extends BaseFragment<ManagerViewModel, FragmentManagerBinding> {
    private ItemAdapter itemAdapter;
    private ArrayList<Item> listItem = new ArrayList<>();


    public ManagerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initComponents() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents();
    }


    @Override
    protected Class<ManagerViewModel> getViewModel() {
        return ManagerViewModel.class;
    }

    @Override
    protected FragmentManagerBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentManagerBinding.inflate(inflater, container, false);
    }
}