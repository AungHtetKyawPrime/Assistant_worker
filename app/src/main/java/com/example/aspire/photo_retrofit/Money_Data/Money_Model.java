package com.example.aspire.photo_retrofit.Money_Data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Money")
public class Money_Model implements Serializable{
    @PrimaryKey(autoGenerate = true)
    private int id;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ColumnInfo(name = "date")

    String date;
    @ColumnInfo(name = "content")
    String content;
    @ColumnInfo(name = "income")
    String income;
    @ColumnInfo(name = "outcome")
    String outcome;

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @Ignore
    public Money_Model(int id){
        this.id=id;
    }

    public Money_Model(String content,String date,String income,String outcome){
        this.content=content;
        this.date=date;
        this.income=income;
        this.outcome=outcome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
