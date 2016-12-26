package com.haikarose.codestube.pojos;

import android.os.Bundle;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by root on 7/29/16.
 */
public class SubCatItemModel {


    private Long id;
    private String promoImage;
    private String description;
    private String title;
    private int resourceCount;

    public static final String ID="id";
    public static final String TITLE="title";
    public static final String DESCRIPTION="description";
    public static final String PROMO_IMAGE="promo_image";
    public static final String RES_COUNT="res_count";


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPromoImage() {
        return promoImage;
    }

    public void setPromoImage(String promoImage) {
        this.promoImage = promoImage;
    }

    public int getResourceCount() {
        return resourceCount;
    }

    public void setResourceCount(int resourceCount) {
        this.resourceCount = resourceCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    public static Bundle UpdatesItemToBundle(SubCatItemModel itemModel){

        Bundle bundle=new Bundle();
        bundle.putLong(itemModel.ID,itemModel.getId());
        bundle.putCharSequence(itemModel.TITLE,itemModel.getTitle());
        bundle.putString(itemModel.DESCRIPTION,itemModel.getDescription());
        bundle.putString(itemModel.PROMO_IMAGE,itemModel.getPromoImage());
        bundle.putString(itemModel.RES_COUNT,Integer.toString(itemModel.getResourceCount()));
        return bundle;
    }

    public static SubCatItemModel createFromBundle(Bundle bundle){

        SubCatItemModel model=new SubCatItemModel();
        model.setId(bundle.getLong(SubCatItemModel.ID));
        model.setTitle(bundle.getString(SubCatItemModel.TITLE));
        model.setDescription(bundle.getString(SubCatItemModel.DESCRIPTION));
        model.setPromoImage(bundle.getString(SubCatItemModel.PROMO_IMAGE));
       return model;
    }


}
