package com.example.healthscanner.ui.list.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(tableName = "user_health")
public class DataEntity {
    @PrimaryKey(autoGenerate = true)
    public int hid;

    @ColumnInfo(name = "data-name")
    public String title; //데이터 이름
    @ColumnInfo(name = "generation-date")
    public int date; //생성날짜

    @ColumnInfo(name = "height-cm")
    public int height; //키
    @ColumnInfo(name = "weight-kg")
    public int weight;  //몸무게

    @ColumnInfo(name = "blood-pressure-systoic")
    public int bloodPressureSystoic;  //저혈압 mmHg
    @ColumnInfo(name = "blood-pressure-Diastolic")
    public int bloodPressure;  //고혈압 mmHg

    @ColumnInfo(name = "urine-protein")
    public String urineProtein;  //요단백

    @ColumnInfo(name = "hemoglobin-g/dL")
    public int hemoglobin;  //혈색소

}
