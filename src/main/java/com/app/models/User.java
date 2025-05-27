package com.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(name = "question_type")
    private String questionType;
    @Column(name = "question_answer")
    private String questionAnswer;
    @Column
    private String secret;
    @Column
    private LocalDate date;
    @Column
    private LocalTime time;
    @Column
    private List<Integer> groups;
    @Column
    private List<Integer> contacts;
    @Column
    private List<String> favorites;
    @Column
    private String avatar;
    @Column
    private String name;
    @Column
    private List<Integer> subscriptions;
    @Column
    private List<Integer> likes;
    @Column
    private String type;
    @Column(name = "two_factor")
    private String twoFactor;
}
