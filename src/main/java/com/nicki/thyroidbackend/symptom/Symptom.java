package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity
@Table(name = "symptoms")
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String value;

    @Column(name = "top_ref")
    private String topRef;

    @Column(name = "bottom_ref")
    private String bottomRef;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Symptom() {
    }

    public Symptom(Long id, String date, String type, String value, String topRef, String bottomRef, User user) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.value = value;
        this.topRef = topRef;
        this.bottomRef = bottomRef;
        this.user = user;
    }

    public Symptom(String date, String type, String value, String topRef, String bottomRef) {
        this.date = date;
        this.type = type;
        this.value = value;
        this.topRef = topRef;
        this.bottomRef = bottomRef;

    }

    public Long getId() {
        return id;
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTopRef() {
        return topRef;
    }

    public void setTopRef(String topRef) {
        this.topRef = topRef;
    }

    public String getBottomRef() {
        return bottomRef;
    }

    public void setBottomRef(String bottomRef) {
        this.bottomRef = bottomRef;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
