package com.haikarose.codestube.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haikarose.codestube.R;
import com.haikarose.codestube.activities.CategoriesActivity;
import com.haikarose.codestube.activities.PlayerActivity;
import com.haikarose.codestube.pojos.Category;
import com.haikarose.codestube.pojos.PlayableItemModel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by root on 12/23/16.
 */

public class PlayableItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Object> items;
    private Context context;



    public PlayableItemAdapter(Context context,List<Object> items){
        this.items=items;
        this.context=context;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_play_cat_item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView descriptionText;
        private ImageView promoImage;
        private URL url;

        ItemViewHolder(View view){
            super(view);
            view.setOnClickListener(this);
            descriptionText=(TextView)view.findViewById(R.id.description);
            promoImage=(ImageView)view.findViewById(R.id.promo_image);
        }

        public void setData(PlayableItemModel itemModel){

            try {
                ItemViewHolder.this.url = new URL((itemModel.getUrl()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            this.descriptionText.setText(itemModel.getDescription());
            Glide.with(context).load(url.toString()).centerCrop().placeholder(android.R.drawable.editbox_dropdown_light_frame).into(promoImage);
        }

        @Override
        public void onClick(View v) {

            int position=ItemViewHolder.this.getAdapterPosition();
            PlayableItemModel itemModel=(PlayableItemModel)items.get(position);

            Intent intent=new Intent(context,PlayerActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(PlayableItemModel.KEY,itemModel.getUrl());
            context.startActivity(intent);
        }
    }
}
