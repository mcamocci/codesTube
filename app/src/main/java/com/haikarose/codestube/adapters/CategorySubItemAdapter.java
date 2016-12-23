package com.haikarose.codestube.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.haikarose.codestube.R;
import com.haikarose.codestube.pojos.CategorySubItem;

import java.util.List;

/**
 * Created by root on 12/21/16.
 */

public class CategorySubItemAdapter extends RecyclerView.Adapter<CategorySubItemAdapter.CategorySubItemViewHolder> {

    private List<Object> items;
    private Context context;

    public CategorySubItemAdapter(Context context,List<Object> items){
        this.items=items;
        this.context=context;
    }

    @Override
    public CategorySubItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= (LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item,parent,false));
        CategorySubItemViewHolder holder=new CategorySubItemViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(CategorySubItemViewHolder holder, int position) {
        CategorySubItem item=(CategorySubItem)items.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CategorySubItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public CategorySubItemViewHolder(View view){
            super(view);
        }

        public void setData(CategorySubItem item){

        }

        @Override
        public void onClick(View v) {

        }
    }
}
