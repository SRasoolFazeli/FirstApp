package com.example.maroon.FakeModel;

import android.widget.ImageView;

public class FruitData {
    private int img ;
    private String fruitName ;
    private String fruitPrice ;

    public FruitData(int img, String fruitName, String fruitPrice) {
        this.img = img;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitPrice() {
        return fruitPrice;
    }

    public void setFruitPrice(String fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
}
