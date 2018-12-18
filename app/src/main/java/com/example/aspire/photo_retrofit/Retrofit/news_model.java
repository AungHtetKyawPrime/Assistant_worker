package com.example.aspire.photo_retrofit.Retrofit;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class news_model {
    @SerializedName("status")
    public String news_status;
    @SerializedName("totalResults")
    public Integer totalResult;
    @SerializedName("articles")
    public List<news> news_data=new ArrayList<>();
    public class news{
        @SerializedName("author")
        public String author;
        @SerializedName("title")
        public String news_title;
        @SerializedName("description")
        public String news_content;
        @SerializedName("urlToImage")
        public String img;

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
    }

}
