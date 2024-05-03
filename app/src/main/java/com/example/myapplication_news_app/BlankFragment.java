package com.example.myapplication_news_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {

    public String title;
    public String desc;
    public String imgurl;
    List<News> newsarray;

    TextView news_ttile, news_descipiton;
    ImageView imgview;
    RecyclerView relatednews;
    CustomAdapterHR adapterhr;
    CustomAdapterVr adaptervr;
    String[] news_titl = {"Dow futures jump 300 points after Apple reports; traders brace for April payrolls data: Live updates - CNBC",
            "Apple beats Q2 estimates as iPhone sales decline 10% - Yahoo Finance",
            "Turkey's inflation accelerates to nearly 70% in April - CNBC",
            "Asia markets live updates: U.S. jobs, Japanese yen, Apple earnings - CNBC",
            "'The Big Nude Boat' offers cruise without clothing on Norwegian Cruise Line - KABC-TV",
            "American oil tycoon accused of trying to conspire with OPEC to inflate prices - CNN",
            "Tesla layoffs: Pakistani-origin woman laid off by Elon Musk says it’s ‘Very hard to let go of…’ - Hindustan Times",
            "Wegovy wins 25,000 new sign-ups a week in US - BBC.com"


    };

    String[] news_desc = {"The major averages are on track for modest declines on the week as Wall Street awaits the April jobs report.",
            "Apple shares popped after it reported better-than-expected Q2 earnings and increased its dividend to $0.25 per share.",
            "Turkey's inflation accelerated to 69.8% annually for the month of April, the Turkish Statistical Institute reported Friday.",
            "Investors will be watching the U.S. nonfarm payrolls data after the U.S. Federal Reserve held interest rates steady at the end of its two-day meeting on Wednesday.",
            "If you want to take a cruise but prefer to pack light, this might be the trip for you.",
            "Scott Sheffield, the founder and longtime CEO of Texas oil producer Pioneer Natural Resources, attempted to collude with OPEC and its allies to inflate oil prices, federal regulators alleged Thursday.",
            "“Unfortunately, the Tesla Charging Team of 500+ people, including me, was dissolved tonight,” a Pakistani-origin woman laid off by Elon Musk wrote in a post. | Trending",
            "Novo Nordisk is under pressure to cut US prices of its weight loss drug, as demand soars."


    };

    String[] img_arr = {"https://image.cnbcfm.com/api/v1/image/107408936-17145832462024-04-29t143859z_1871902969_rc2dg7aogzed_rtrmadp_0_usa-stocks.jpeg?v=1714583322&w=1920&h=1",
            "https://s.yimg.com/ny/api/res/1.2/ZQ14F7Jyw1kDGPj9MOMYuA--/YXBwaWQ9aGlnaGxhbmRlcjt3PTEyMDA7aD04MDA-/https://s.yimg.com/os/creatr-uploaded-images/2024-04/3fe1b730-07ef-11ef-aa7a-6c10155205d0",
            "https://image.cnbcfm.com/api/v1/image/107239665-1683809695399-gettyimages-1242813351-TURKEY_LEVENT.jpeg?v=1714723578&w=1920&h=1080",
            "https://image.cnbcfm.com/api/v1/image/107126209-1664410945120-gettyimages-1241870098-HK_STOCK_EXCHANGE.jpeg?v=1664415363&w=1920&h=1080",
            "https://cdn.abcotvs.com/dip/images/14757629_050224-kabc-4pm-naked-cruise-vid.jpg?w=1600",
            "https://media.cnn.com/api/v1/images/stellar/prod/gettyimages-1247876980.jpg?c=16x9&q=w_800,c_fill",
            "https://www.hindustantimes.com/ht-img/img/2024/05/03/1600x900/LinkedIn_Viral_Elon_Musk_Pakistani_Tesla_Layoffs_1714700595266_1714700627140.jpg",
            "https://ichef.bbci.co.uk/news/1024/branded_news/76ee/live/7b250690-0898-11ef-aac4-c3e048f12493.jpg"


    };
    public static Fragment newInstance(String title, String description, String imageurl) {
        Bundle args = new Bundle();

        args.putString("title", title);
        args.putString("Description", description);
        args.putString("ImageUrl", imageurl);

        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        news_ttile = view.findViewById(R.id.Newstitle);
        news_descipiton = view.findViewById(R.id.NewsDescription);
        imgview = view.findViewById(R.id.NewsIMG);
        relatednews = view.findViewById(R.id.RelatedNews);

        news_ttile.setText(getArguments().getString("title"));
        news_descipiton.setText(getArguments().getString("Description"));
        Picasso.get().load(getArguments().getString("ImageUrl")).into(imgview);
        newsarray = new ArrayList<>();
        extractNews();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        adaptervr = new CustomAdapterVr(getActivity(),getContext(), newsarray);
        relatednews.setAdapter(adaptervr);
        relatednews.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        return view;
    }

    private void extractNews() {

        for (int i = 3; i < 7; i++) {
            News news = new News();

            news.setTitle(news_titl[i]);
            news.setNewsdescription(news_desc[i]);
            news.setNewsImage(img_arr[i]);
            newsarray.add(news);
        }
    }
}