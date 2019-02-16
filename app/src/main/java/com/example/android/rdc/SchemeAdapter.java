package com.example.android.rdc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SchemeAdapter extends RecyclerView.Adapter<SchemeAdapter.MyViewHolder> {
    private Context context;
    private List<SchemeModal> schemeList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView schemeNameTextView, schemeTypeTextView;

        public MyViewHolder(View view){
            super(view);
            schemeNameTextView=view.findViewById(R.id.scheme_name_text_view);
            schemeTypeTextView=view.findViewById(R.id.scheme_type_text_view);
        }
    }
    public SchemeAdapter(Context context,List<SchemeModal> schemeList)
    {
        this.context=context;
        this.schemeList=schemeList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.scheme_card,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        SchemeModal scheme = schemeList.get(i);
        myViewHolder.schemeNameTextView.setText(scheme.getSchemeName());
        myViewHolder.schemeTypeTextView.setText(scheme.getSchemeType());
    }

    @Override
    public int getItemCount() {
        return schemeList.size();
    }
}
