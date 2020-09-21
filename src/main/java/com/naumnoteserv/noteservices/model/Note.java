package com.naumnoteserv.noteservices.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "notestable")
public class Note {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "head")
    private String head;
    @Column(name = "text")
    private String text;
    @Column(name = "date")
    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }
}
