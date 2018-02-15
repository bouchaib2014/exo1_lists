package com.example.googleeb.exo1_lists;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by enkre on 2/14/2018.
 */

public class Contact implements Parcelable{

    private String name, age;

    public Contact(String name, String age) {
        this.name = name;
        this.age = age;
    }

    protected Contact(Parcel in) {
        name = in.readString();
        age = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(age);
    }
}
