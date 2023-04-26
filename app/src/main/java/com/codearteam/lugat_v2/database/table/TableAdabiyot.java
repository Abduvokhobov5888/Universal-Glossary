package com.codearteam.lugat_v2.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TableAdabiyot {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "atama")
    private String atama;

    @ColumnInfo(name = "izoh")
    private String izoh;

    public TableAdabiyot(String atama, String izoh) {
        this.atama = atama;
        this.izoh = izoh;
    }

    public int getId() {
        return id;
    }

    public String getAtama() {
        return atama;
    }

    public String getIzoh() {
        return izoh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAtama(String atama) {
        this.atama = atama;
    }

    public void setIzoh(String izoh) {
        this.izoh = izoh;
    }
}
