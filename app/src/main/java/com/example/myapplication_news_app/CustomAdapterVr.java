package com.example.myapplication_news_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapterVr extends RecyclerView.Adapter<CustomAdapterVr.MyViewHolder>{


    private List<News> news;

    private Activity activity;
    private Context context;


    private CustomAdapterHR.OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(CustomAdapterHR.OnItemClickListener listener) {
        this.listener = listener;
    }

    public CustomAdapterVr(Activity activity, Context context ,List<News> news){
        this.activity = activity;
        this.context = context;
        this.news = news;

    }
    @NonNull
    @Override
    public CustomAdapterVr.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_row,parent,false);
        return new CustomAdapterVr.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterVr.MyViewHolder holder, int position) {
        holder.news_title.setText(String.valueOf(news.get(position).getTitle()));
        holder.news_desc.setText(String.valueOf(news.get(position).getNewsdescription()));
        Picasso.get().load(news.get(position).getNewsImage()).into(holder.coverImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "sample";
                int currentposition = holder.getAdapterPosition();

                    listener.onItemClick(currentposition);


            }
        });
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView news_title, news_desc;
        ImageView coverImage;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            news_title = itemView.findViewById(R.id.news_title1);
            news_desc = itemView.findViewById(R.id.news_desc1);
            coverImage = itemView.findViewById(R.id.coverImage1);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
