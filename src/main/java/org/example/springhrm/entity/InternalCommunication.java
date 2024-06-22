package org.example.springhrm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class InternalCommunication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long communicationId;
    private String title;
    private String content;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "senderId")
    private Employee sender;
    @ManyToOne
    @JoinColumn(name = "receiverId")
    private Employee receiver;
}
