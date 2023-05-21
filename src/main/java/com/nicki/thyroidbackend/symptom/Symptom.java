package com.nicki.thyroidbackend.symptom;

import com.nicki.thyroidbackend.user.User;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private double value;

    @Column(name = "top_ref")
    private double topRef;

    @Column(name = "bottom_ref")
    private double bottomRef;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;





    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", topRef='" + topRef + '\'' +
                ", bottomRef='" + bottomRef + '\'' +
                ", user=" + user +
                '}';
    }
}
