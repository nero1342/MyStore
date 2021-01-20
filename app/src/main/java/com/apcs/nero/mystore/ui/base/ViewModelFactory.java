package com.apcs.nero.mystore.ui.base;

import com.apcs.nero.mystore.ui.store.StoreViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StoreViewModel.class)) return (T) new StoreViewModel();
        return super.create(modelClass);
    }
}
