package com.github.rubensousa.recyclerviewsnap.data;




public class ListItem2 {
    private String name;
    private String message;
    private int imageResId;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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
