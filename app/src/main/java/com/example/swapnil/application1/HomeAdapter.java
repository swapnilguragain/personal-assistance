package com.example.swapnil.application1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.VH> {

    private final Context context;
    ArrayList<HomeAdapter> homes = new ArrayList<>();

    public  HomeAdapter(Context context) {
        this.context= context;
    }

    @Override
    public HomeAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup viewGroup = null;
        return new VH(LayoutInflater.from(context).inflate(R.layout.each_fragment_home, viewGroup, false ));
    }

    public void addHomes(HomeAdapter object){
        homes.add(object);
        notifyItemInserted(homes.size());
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        final HomeAdapter object= homes.get(position);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VH extends RecyclerView.ViewHolder {
        public VH(View itemView) {
            super(itemView);
        }
    }
}
