package com.codearteam.lugat_v2.model;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

public class TableModel {
    private int id;
    private String atama;
    private String izoh;


    public TableModel(String atama, String izoh) {
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

    public static DiffUtil.ItemCallback<TableModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<TableModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull TableModel oldItem, @NonNull TableModel newItem) {
            return oldItem.id == newItem.id;
        }


        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull TableModel oldItem, @NonNull TableModel newItem) {
            return oldItem.equals(newItem);
        }
    };
}
