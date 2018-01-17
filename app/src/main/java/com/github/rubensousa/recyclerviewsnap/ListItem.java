package com.github.rubensousa.recyclerviewsnap;




public class ListItem {
    private String message;
    private int imageResId;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }



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
