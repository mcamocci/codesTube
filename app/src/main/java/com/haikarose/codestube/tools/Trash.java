package com.haikarose.codestube.tools;

/**
 * Created by root on 12/26/16.
 */

public class Trash {

 /*
        if(ViewType==VIEW_TYPE_NORMAL){
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
                ((ViewGroup)cardView.getParent()).removeView(nativeExpressAdView);
            }
            cardView.addView(nativeExpressAdView);

        }*/



       /* TextView text=(TextView)view.findViewById(R.id.text);

        text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                TimePickerDialog dialog =  new TimePickerDialog(
                        getActivity(),R.style.DialogTheme,
                        timeSetListener,
                        05,
                        12,
                        true);
                dialog.show();

               *//*TimePickerFragment fragment=new TimePickerFragment();
                fragment.show(getFragmentManager(),"show");*//*

            }
        });*/


       /*    recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        final float density=getActivity().getResources().getDisplayMetrics().density;

                        int width=(int)(recyclerView.getWidth()/density);
                        if(width>=600){
                            width=500;
                        }
                        AdSize size=new AdSize(width,150);
                        //Toast.makeText(getContext(),Float.toString(recyclerView.getWidth()/density),Toast.LENGTH_SHORT).show();

                        try{
                            NativeExpressAdView nativeExpressAdView=(NativeExpressAdView)objects.get(on);
                            if(nativeExpressAdView.getAdSize()==null){
                                nativeExpressAdView.setAdSize(size);
                            }
                            nativeExpressAdView.loadAd(new AdRequest.Builder().build());
                        }catch (Exception ex){

                        }
                       *//* for(int i=0; i<start;i+=8){
                            Log.e("home position: ",Integer.toString(i));

                        }*//*
                    }
                });*/
}
