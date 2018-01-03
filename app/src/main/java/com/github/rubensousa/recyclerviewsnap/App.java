package com.github.rubensousa.recyclerviewsnap;


public class App {

    private int mDrawable;
    private String mName;
    private String mRating;

    public App(String name, int drawable, String rating) {
        mName = name;
        mDrawable = drawable;
        mRating = rating;
    }

    public String getRating() {
        return mRating;
    }

    public int getDrawable() {
        return mDrawable;
    }

    public String getName() {
        return mName;
    }
}

