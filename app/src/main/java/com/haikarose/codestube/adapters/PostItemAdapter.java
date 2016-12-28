package com.haikarose.codestube.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haikarose.codestube.R;
import com.haikarose.codestube.activities.ListOfPlayableItemActivity;
import com.haikarose.codestube.pojos.CategoryItem;
import com.haikarose.codestube.pojos.Post;
import com.haikarose.codestube.pojos.SubCatItemModel;
import com.haikarose.codestube.tools.CommonInformation;
import com.haikarose.codestube.tools.StringUpperHelper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * Created by root on 7/29/16.
 */
public class PostItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> list;
    Context context;

    public PostItemAdapter(Context context, List<Object> list){
        this.list=list;
        this.context=context;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Post currentItem=(Post)list.get(position);
        ((NotificationViewHolder)holder).setData(currentItem);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,parent,false);
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
        private TextView categoryItem;
        private TextView description;



        public NotificationViewHolder(View view){
            super(view);
            this.view=view;
            promo_image=(ImageView) view.findViewById(R.id.promo_image);
            time_text_view=(TextView) view.findViewById(R.id.time);
            description=(TextView)view.findViewById(R.id.description);
            categoryItem=(TextView)view.findViewById(R.id.category_item);
            description.setMovementMethod(LinkMovementMethod.getInstance());

            view.setOnClickListener(this);
            this.context=view.getContext();
        }

        @Override
        public void onClick(View v) {

           int position=NotificationViewHolder.this.getAdapterPosition();
           Post item=(Post) list.get(position);
           Intent intent=new Intent(NotificationViewHolder.this.context,ListOfPlayableItemActivity.class);
           intent.putExtra(CommonInformation.KEY_POST_ID,item.getId());
           NotificationViewHolder.this.context.startActivity(intent);

        }

        public void setData(Object item){

            Post itemModel=(Post) item;
            URL url= null;

            if(((Post)item).getContent().equalsIgnoreCase("springboot")){

                try {
                    url = new URL(((SubCatItemModel) item).getPromoImage());
                 } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                promo_image.setVisibility(View.VISIBLE);
                Glide.with(context).load(url.toString()).centerCrop().placeholder(android.R.drawable.editbox_dropdown_light_frame).into(promo_image);
            }else{
                promo_image.setVisibility(View.GONE);
            }

            time_text_view.setText("uongo time");
            categoryItem.setText(StringUpperHelper.doUpperlization("not figured"));
            if(itemModel.getContent().length()>100){
                description.setText(StringUpperHelper.doUpperlization(itemModel.getContent().substring(0,98)+"..."));
            }else{
                description.setText(StringUpperHelper.doUpperlization(itemModel.getContent()));
            }
        }


    }
}
