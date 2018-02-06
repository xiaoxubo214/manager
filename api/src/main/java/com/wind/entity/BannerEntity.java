package com.wind.entity;

import java.util.ArrayList;
import java.util.List;

public class BannerEntity {
    public BannerEntity(){
        bannerList = new ArrayList<>();
    }
    public List<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(List<Banner> bannerList) {
        this.bannerList = bannerList;
    }

    public List<Banner> bannerList;

    public static class Banner{
        public String coupletsId;
        public String imageUrl;
        public Banner(String coupletsId,String imageUrl) {
            this.coupletsId = coupletsId;
            this.imageUrl = imageUrl;
        }

        public String getCoupletsId() {
            return coupletsId;
        }

        public void setCoupletsId(String coupletsId) {
            this.coupletsId = coupletsId;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

    }
}
