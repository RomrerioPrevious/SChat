package com.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
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

    public User(Long id, String password, String email, String username, String questionType, String questionAnswer, String secret, LocalDate date, LocalTime time, List<Integer> groups, List<Integer> contacts, List<String> favorites, String avatar, String name, List<Integer> subscriptions, List<Integer> likes, String type, String twoFactor) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.username = username;
        this.questionType = questionType;
        this.questionAnswer = questionAnswer;
        this.secret = secret;
        this.date = date;
        this.time = time;
        this.groups = groups;
        this.contacts = contacts;
        this.favorites = favorites;
        this.avatar = avatar;
        this.name = name;
        this.subscriptions = subscriptions;
        this.likes = likes;
        this.type = type;
        this.twoFactor = twoFactor;
    }
}
