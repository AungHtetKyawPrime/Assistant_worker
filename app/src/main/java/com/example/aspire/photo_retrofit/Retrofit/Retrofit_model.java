package com.example.aspire.photo_retrofit.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Retrofit_model {
    @SerializedName("totalHits")
    public Integer total_hits;
    @SerializedName("hits")
    public List<photo_data> photo_d = new ArrayList<>();

    public class photo_data {
        @SerializedName("largeImageURL")
        public String img;
        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }
        @SerializedName("likes")
        public Integer likes;
        @SerializedName("views")
        public String views;
        @SerializedName("favorites")
        public Integer favorites;



    }
}
