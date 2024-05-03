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

public class CustomAdapterHR extends RecyclerView.Adapter<CustomAdapterHR.MyViewHolder> {

   private List<News> news;

    private Activity activity;
    private Context context;


    private OnItemClickListener listener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public CustomAdapterHR(Activity activity, Context context ,List<News> news){
        this.activity = activity;
        this.context = context;
        this.news = news;

    }
    @NonNull
    @Override
    public CustomAdapterHR.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.news_hor,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapterHR.MyViewHolder holder,final  int position) {

        holder.news_title.setText(String.valueOf(news.get(position).getTitle()));
        holder.news_desc.setText(String.valueOf(news.get(position).getNewsdescription()));
        Picasso.get().load(news.get(position).getNewsImage()).into(holder.coverImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "sample";
                int currentposition = holder.getAdapterPosition();
                if(listener!=null && currentposition != RecyclerView.NO_POSITION){
                    listener.onItemClick(currentposition);
                }

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
            news_title = itemView.findViewById(R.id.news_title);
            news_desc = itemView.findViewById(R.id.news_desc);
            coverImage = itemView.findViewById(R.id.coverImage1);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
