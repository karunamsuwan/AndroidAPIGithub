package com.example.applicationgithub;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.applicationgithub.model.datalist;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    public List<datalist> data;
    public Context context;

    public Adapter(Context context, List<datalist> dataset) {
        this.data = dataset;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_user, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        datalist item = data.get(position);

        viewHolder.id.setText("Id:"+item.actor.getId());
        viewHolder.login.setText("Login:"+item.actor.getLogin());
        viewHolder.display_login.setText("DL.:"+item.actor.getDisplay_login());
        viewHolder.gravatar_id.setText("GI.:"+item.actor.getGravatar_id());
        viewHolder.url.setText("Url:"+item.actor.getUrl());

        Glide.with(this.context).load(item.actor.getAvatar_url()).into(viewHolder.avatar_url);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id, login, display_login, gravatar_id, url;
        public ImageView avatar_url;

        public ViewHolder(View view) {
            super(view);

            id = (TextView) view.findViewById(R.id.id);
            login = (TextView) view.findViewById(R.id.login);
            display_login = (TextView) view.findViewById(R.id.display_login);
            gravatar_id = (TextView) view.findViewById(R.id.gravatar_id);
            url = (TextView) view.findViewById(R.id.url);
            avatar_url = (ImageView) view.findViewById(R.id.cover);
        }
    }

}
