package com.example.hafidzniioman.triumphmotorcycles;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hafidzniioman on 21/02/18.
 */

public class Motor implements Parcelable {
    public static final Creator<Motor> CREATOR = new Creator<Motor>() {
        @Override
        public Motor createFromParcel(Parcel source) {
            return new Motor(source);
        }

        @Override
        public Motor[] newArray(int size) {
            return new Motor[size];
        }
    };
    private String name, remarks, photo;

    public Motor() {
    }

    protected Motor(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
    }
}
