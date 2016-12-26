package com.haikarose.codestube.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haikarose.codestube.R;
import com.haikarose.codestube.activities.ListOfPlayableItemActivity;
import com.haikarose.codestube.pojos.SubCatItemModel;
import com.haikarose.codestube.tools.StringUpperHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * Created by root on 7/29/16.
 */
public class SubCatItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> list;
    Context context;

    public SubCatItemAdapter(Context context, List<Object> list){
        this.list=list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SubCatItemModel currentItem=(SubCatItemModel)list.get(position);
        ((NotificationViewHolder)holder).setData(currentItem);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sub_cat_item,parent,false);
        NotificationViewHolder viewHolder=new NotificationViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        private Context context;
        private View view;

        private ImageView promo_image;
        private TextView time_text_view;
        private TextView title;
        private TextView description;
        private LinearLayout play_button;



        public NotificationViewHolder(View view){
            super(view);
            this.view=view;
            promo_image=(ImageView) view.findViewById(R.id.promo_image);
            time_text_view=(TextView) view.findViewById(R.id.time);
            title=(TextView)view.findViewById(R.id.channel_name);
            description=(TextView)view.findViewById(R.id.message);
            description.setMovementMethod(LinkMovementMethod.getInstance());
            play_button=(LinearLayout)view.findViewById(R.id.play_button);
            play_button.setOnClickListener(this);

            view.setOnClickListener(this);
            this.context=view.getContext();
        }

        @Override
        public void onClick(View v) {

           int position=NotificationViewHolder.this.getAdapterPosition();
           SubCatItemModel item=(SubCatItemModel)list.get(position);
           Intent intent=new Intent(NotificationViewHolder.this.context,ListOfPlayableItemActivity.class);
           intent.putExtras(SubCatItemModel.UpdatesItemToBundle(item));
           NotificationViewHolder.this.context.startActivity(intent);

        }

        public void setData(Object item){

            SubCatItemModel itemModel=(SubCatItemModel)item;
            URL url= null;

            if(((SubCatItemModel)item).getTitle().equalsIgnoreCase("ujinga")){

                try {
                    url = new URL(((SubCatItemModel) item).getPromoImage());
                 } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                promo_image.setVisibility(View.VISIBLE);
                play_button.setVisibility(View.VISIBLE);
                Glide.with(context).load(url.toString()).centerCrop().placeholder(android.R.drawable.editbox_dropdown_light_frame).into(promo_image);
            }else{
                promo_image.setVisibility(View.GONE);
                play_button.setVisibility(View.GONE);
            }

            time_text_view.setText("uongo time");
            title.setText(StringUpperHelper.doUpperlization(itemModel.getTitle()));
            if(itemModel.getDescription().length()>100){
                description.setText(StringUpperHelper.doUpperlization(itemModel.getDescription().substring(0,98)+"..."));
            }else{
                description.setText(StringUpperHelper.doUpperlization(itemModel.getDescription()));
            }
        }


    }
}
