package com.wangic.light;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import Entry.LightModel;

/**
 * Created by wangic on 2018/3/13.
 */
public class LightListAdapter extends BaseAdapter {
    private ArrayList<LightModel>arrayList;
    private Context context;
    private static final String TAG = "LightListAdapter";

    public LightListAdapter(Context context,ArrayList<LightModel> arrayList) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final MyHolder myHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.light_item,null);
            myHolder = new MyHolder();
            myHolder.light_item_name = (TextView) convertView.findViewById(R.id.light_item_name);
            myHolder.light_status = (Switch) convertView.findViewById(R.id.light_status);
            myHolder.light_item_more = (ImageView) convertView.findViewById(R.id.light_item_more);
            myHolder.light_item_more_layout = (LinearLayout) convertView.findViewById(R.id.light_item_more_layout);
            convertView.setTag(myHolder);
        }else{
            myHolder = (MyHolder) convertView.getTag();
        }
        myHolder.light_item_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myHolder.light_item_more_layout.setVisibility(View.GONE);
            }
        });
        myHolder.light_status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.e(TAG, "onCheckedChanged: "+isChecked );
            }
        });
        return convertView;
    }

    class MyHolder{
        private TextView light_item_name;
        private Switch light_status;
        private ImageView light_item_more;
        private LinearLayout light_item_more_layout;
    }
}
