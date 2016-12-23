package com.haikarose.codestube.adapters;

import android.content.Context;
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

            Log.e("message","hello there am alive ");
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

            if(!(v.getId()==R.id.play_button)){

              /*  int position=NotificationViewHolder.this.getAdapterPosition();
                SubCatItemModel item=(SubCatItemModel)list.get(position);
                //Intent intent=new Intent(NotificationViewHolder.this.context,UpdateItemViewerActivity.class);
                Intent intent=new Intent(NotificationViewHolder.this.context,UltimateViewActivity.class);

                intent.putExtras(SubCatItemModel.UpdatesItemToBundle(item));
                NotificationViewHolder.this.context.startActivity(intent);*/

            }else{
                /*int position=NotificationViewHolder.this.getAdapterPosition();
                UpdatesItemModel item=list.get(position);
                //Intent intent=new Intent(NotificationViewHolder.this.context,UpdateItemViewerActivity.class);
                Intent intent=new Intent(NotificationViewHolder.this.context,ImageviewerActivity.class);
                intent.putExtras(UpdatesItemModel.UpdatesItemToBundle(item));
                NotificationViewHolder.this.context.startActivity(intent);*/
            }

        }

        public void setData(Object item){

            SubCatItemModel itemModel=(SubCatItemModel)item;
            URL url= null;
            try {
                url = new URL("https://scontent.xx.fbcdn.net/v/t1.0-9/14724391_1131552686932012_1980706645257959924_n.jpg?_nc_eui2=v1%3AAeFnHBAvTkAycFt7acOh76x_-Rzobattaerj680wwUGzCbD9jfKUthcuPEOY8Hz_EaK44QvQNxd4zRnKmrNx6Ey4OiZBrPue-IEMwrx7QC14eA&oh=5a6b716fb1f1edae1784c8a1e27be5f6&oe=589E6A96");
                //url=new URL("https://scontent.xx.fbcdn.net/v/t1.0-0/s480x480/14729116_559960550855632_879800026931900081_n.jpg?_nc_eui2=v1%3AAeEwBUzYNejWJ0xA5CO0ceyXps7kzBdw48Px2E8-l2JSYV1FjC6Ic1CdSmjr1qujuDXN9DvNTuGR1cwpEkIyqDt_PkjSlxTWDN_ICk8l0R-nPQ&oh=f65d0c50e6a01416f770d7d2756b64b0&oe=58954080");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

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

           // time_text_view.setText(DateStringHelper.getDate(item.getTime()));
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
