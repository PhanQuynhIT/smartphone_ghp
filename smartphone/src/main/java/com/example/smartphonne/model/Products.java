package com.example.smartphonne.model;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //tự động tạo ID
    private int item_id;
    private String title;
    private String describe_p;
    private String release_date;

    public void Products(int item_id, String title, String describe_p, String release_date) {
        this.item_id = item_id;
        this.title = title;
        this.describe_p = describe_p;
        this.release_date = release_date;
    }

    // Constructor mặc định (nếu không dùng Lombok)
    public void Products() {
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe_p() {
        return describe_p;
    }

    public void setDescribe_p(String describe_p) {
        this.describe_p = describe_p;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
}