package com.github.rubensousa.recyclerviewsnap.data;




public class ListItem {
    private String name;
    private String message;
    private int imageResId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    private String time;



    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }


    public int getImageResId() {

        return imageResId;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
