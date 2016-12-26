package com.haikarose.codestube.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.NativeExpressAdView;
import com.haikarose.codestube.R;
import com.haikarose.codestube.activities.CategoriesActivity;
import com.haikarose.codestube.dialogs.MoreOptionDialog;
import com.haikarose.codestube.pojos.Category;

import java.util.List;

/**
 * Created by root on 12/21/16.
 */

public class CategoryItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Object> categoriyList;
    private FragmentManager fragmentManager;

    public final static int VIEW_TYPE_NORMAL=0;
    public final static int VIEW_TYPE_AD=1;

    public CategoryItemAdapter(Context context,FragmentManager fragmentManager, List<Object> categoryList){
        this.context=context;
        this.categoriyList=categoryList;
        this.fragmentManager=fragmentManager;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

         View view;

        if(viewType==VIEW_TYPE_AD){

            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.ads_view_item,parent,false);
            NativeAd holder=new NativeAd(view);
            return holder;

        }else{
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item,parent,false);
            CategoryItemViewHolder holder=new CategoryItemViewHolder(view);
            holder.setFragmentManager(fragmentManager);
            return holder;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int ViewType=getItemViewType(position);

        if(ViewType==0){
            Category category=(Category)categoriyList.get(position);
            CategoryItemViewHolder hold=(CategoryItemViewHolder)holder;
            hold.setData(category);

        }else{
            NativeAd nativeAd=(NativeAd)holder;
            Log.e("the position is: ",Integer.toString(position));
            NativeExpressAdView nativeExpressAdView=(NativeExpressAdView)categoriyList.get(position);
            ViewGroup cardView=(ViewGroup)nativeAd.itemView;
            cardView.removeAllViews();

            if(nativeExpressAdView.getParent()!=null){

                    try {
                        ((ViewGroup)cardView.getParent()).removeView(nativeExpressAdView);
                        //cardView.addView(nativeExpressAdView);
                    }catch (Exception ex){
                        Log.e("error caught",ex.getMessage());
                    }

            }
            try {
                cardView.addView(nativeExpressAdView);
            }catch (Exception ex){
                Log.e("error caught2",ex.getMessage());
                Toast.makeText(context,"yoyo1",Toast.LENGTH_SHORT).show();

            }

        }

       
    }

    @Override
    public int getItemCount() {
        return categoriyList.size();
    }

    public  class CategoryItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Category category;
        private View view;
        private ImageView moreOption;
        private FragmentManager fragmentManager;

        public CategoryItemViewHolder(View view){
            super(view);
            view.setOnClickListener(this);
            this.view=view;
        }

        public void setData(Category category){
            this.category=category;

            TextView title=(TextView)view.findViewById(R.id.title);
            TextView description=(TextView)view.findViewById(R.id.description);
            TextView time=(TextView)view.findViewById(R.id.time);
            moreOption=(ImageView)view.findViewById(R.id.more_menu);
            moreOption.setOnClickListener(CategoryItemViewHolder.this);

            title.setText(this.category.getTitle().toUpperCase());
            time.setText(this.category.getTime());
            description.setText(this.category.getDescription());

        }

        public void setFragmentManager(FragmentManager fragmentManager){
            this.fragmentManager=fragmentManager;
        }

        @Override
        public void onClick(View v) {

            int position=CategoryItemViewHolder.this.getAdapterPosition();
            Toast.makeText(context,Integer.toString(position),Toast.LENGTH_SHORT).show();

            if(v.getId()==R.id.more_menu){
                MoreOptionDialog dialog=new MoreOptionDialog();
                dialog.show(fragmentManager,"tag");
            }else{
                Category item=(Category)categoriyList.get(position);
                Intent intent=new Intent(context, CategoriesActivity.class);
                intent.putExtra("title",item.getTitle());
                context.startActivity(intent);
            }

        }
    }

    public class NativeAd extends RecyclerView.ViewHolder{
       public  NativeAd(View view){
            super(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        try{
            Category item=(Category)categoriyList.get(position);
            return 0;
        }catch (Exception ex){
            Log.e("the render probs",Integer.toString(position));
           // Toast.makeText(context,"failed to render at"+Integer.toString(position),Toast.LENGTH_SHORT).show();
            return 1;
        }
    }
}
