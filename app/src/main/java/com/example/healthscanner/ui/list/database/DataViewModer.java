package com.example.healthscanner.ui.list.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class DataViewModer extends AndroidViewModel {
    private final LiveData<List<DataEntity>> liveData;
    public DataViewModer(@NonNull Application application) {
        super(application);
        liveData = Adddatabase
                .getInstance(getApplication())
                .dataDao()
                .getAllBlogPosts();
    }

    public LiveData<List<DataEntity>> getLiveData() {
        return liveData;
    }


}
