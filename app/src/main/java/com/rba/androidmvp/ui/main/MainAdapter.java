package com.rba.androidmvp.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rba.androidmvp.R;
import com.rba.androidmvp.model.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricardo Bravo on 26/04/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder>{

    private List<UserEntity> userEntities;
    private MainView mainView;

    public MainAdapter(MainView mainView) {
        this.mainView = mainView;
        userEntities = new ArrayList<>();
    }

    public void addData(List<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_type, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.lblName.setText(userEntities.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return userEntities.size();
    }


    class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView lblName;

        public ItemViewHolder(View itemView) {
            super(itemView);
            lblName = (TextView) itemView.findViewById(R.id.lblName);;
        }

        @Override
        public void onClick(View view) {
            mainView.showToast("hola");
        }
    }
}
