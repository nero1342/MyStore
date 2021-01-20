package com.apcs.nero.mystore.ui.manager.create_item;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.apcs.nero.mystore.databinding.FragmentCreateItemBinding;
import com.apcs.nero.mystore.ui.base.BaseFragment;
import com.apcs.nero.mystore.ui.item.Item;
import com.apcs.nero.mystore.ui.item.ItemAdapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CreateItemFragment extends BaseFragment<CreateItemViewModel, FragmentCreateItemBinding> {
    private static final int REQUEST_IMAGE_CAPTURE = 0x111;
    private ItemAdapter itemAdapter;
    private ArrayList<Item> listItem = new ArrayList<>();


    public CreateItemFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void initComponents() {
        binding.btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
        catch (ActivityNotFoundException e) {
            Log.d("[IMAGE CAPTURE]", "Fail");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents();
    }


    @Override
    protected Class<CreateItemViewModel> getViewModel() {
        return CreateItemViewModel.class;
    }

    @Override
    protected FragmentCreateItemBinding getFragmentBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentCreateItemBinding.inflate(inflater, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap bitmap = (Bitmap) extras.get("data");
                assert bitmap != null;
                String test = String.valueOf(bitmap.getHeight()) + 'x' + String.valueOf(bitmap.getWidth());
                Toast.makeText(getContext(), test, Toast.LENGTH_LONG).show();
                binding.imgCapture.setImageBitmap(bitmap);
            }
        }
    }
}