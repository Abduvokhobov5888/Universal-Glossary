package com.codearteam.lugat_v2.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.codearteam.lugat_v2.R;
import com.codearteam.lugat_v2.activity.ActivityAboudWord;
import com.codearteam.lugat_v2.model.TableModel;


public class AdapterWordsList extends PagedListAdapter<TableModel, AdapterWordsList.viewHolder> {

    private final Context context;

    public AdapterWordsList(Context context) {
        super(TableModel.DIFF_CALLBACK);
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_words_list_layout, parent, false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        final TableModel tableModel = getItem(position);

        if (tableModel != null) {
            holder.bindTo(tableModel);
        } else {
            holder.clear();
        }


        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityAboudWord.class);
                intent.putExtra("izoh", tableModel.getIzoh());
                intent.putExtra("atama", tableModel.getAtama());

                context.startActivity(intent);
            }
        });
    }



    public class viewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private TextView titleText;

        viewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.liner_layout_1);
            titleText = itemView.findViewById(R.id.word_title);
        }

        void bindTo(TableModel tableModel) {
            this.titleText.setText(tableModel.getAtama());
        }

        void clear() {
            linearLayout.invalidate();
            itemView.invalidate();
            titleText.invalidate();
        }
    }



}