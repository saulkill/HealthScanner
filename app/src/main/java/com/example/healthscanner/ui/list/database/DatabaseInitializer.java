package com.example.healthscanner.ui.list.database;

import android.os.AsyncTask;

public class DatabaseInitializer extends AsyncTask<DataEntity,Void,Void>{
    DataDao dataDao;

    private DatabaseInitializer(DataDao dataDao){
        this.dataDao = dataDao;
    }
    @Override
    protected Void doInBackground(DataEntity... dataEntities) {
        dataDao.insertData(dataEntities[0]);
        return null;
    }
}
