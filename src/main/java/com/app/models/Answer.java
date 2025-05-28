package com.app.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table("answers")
public class Answer {
    @Id
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long id;

    @Column
    @CassandraType(type = CassandraType.Name.TEXT)
    private String message;
    @Column
    @CassandraType(type = CassandraType.Name.DATE)
    private LocalDate date;
    @Column
    @CassandraType(type = CassandraType.Name.TIME)
    private LocalTime time;
    @Column("post_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long postId;
    @Column("answer_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long answerId;
    @Column("user_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long userId;
    @Column("gif_link")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String gifLink;

    public Answer(long id, String message, LocalDate date, LocalTime time, long postId, long answerId, long userId, String gifLink) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.time = time;
        this.postId = postId;
        this.answerId = answerId;
        this.userId = userId;
        this.gifLink = gifLink;
    }
}

