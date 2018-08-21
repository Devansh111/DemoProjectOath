package com.example.devansh.demoprojectoath.Adapters;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devansh.demoprojectoath.PoJo.NewsPojo;
import com.example.devansh.demoprojectoath.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Devansh on 8/21/2018.
 */

public class Main_list_adapter extends ArrayAdapter<NewsPojo> {

    List<NewsPojo> list = new ArrayList<NewsPojo>();
    public View view;
    Context c ;
    public Main_list_adapter(@NonNull Context context, @LayoutRes int resource, List<NewsPojo> list) {
        super(context, resource);
        this.list = list;
        this.c = context;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        view = convertView;
        final Holder holder;
        if(convertView == null){
            view = View.inflate(c, R.layout.display_adapter,null);
            holder = new Holder();
            holder.news_text = (TextView) view.findViewById(R.id.news_title);
            holder.news_image = (ImageView) view.findViewById(R.id.news_image);
            holder.news_image.setImageURI(Uri.parse(list.get(position).getImage()));
            holder.news_text.setText(list.get(position).getTitle().toString());
            view.setTag(holder);
        }
        else
            holder = (Holder) view.getTag();

        return view;
    }
}
    class Holder {
        public ImageView news_image;
        public TextView news_text;

    }
