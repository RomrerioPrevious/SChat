package com.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table("posts")
public class Post {
    @Id
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long id;

    @Column
    @CassandraType(type = CassandraType.Name.TEXT)
    private String message;
    @Column
    @CassandraType(type = CassandraType.Name.TEXT)
    private String pinned;
    @Column
    @CassandraType(type = CassandraType.Name.DATE)
    private LocalDate date;
    @Column
    @CassandraType(type = CassandraType.Name.TIME)
    private LocalTime time;
    @Column("user_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long userId;
    @Column
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.BIGINT)
    private List<Long> answers;
    @Column("hashtags_visible")
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.TEXT)
    private List<String> hashtagsVisible;
    @Column("hashtags_invisible")
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.TEXT)
    private List<String> hashtagsInvisible;
    @Column
    @CassandraType(type = CassandraType.Name.INT)
    private int likes;

    public Post(long id, String message, String pinned, LocalDate date, LocalTime time, long userId, List<Long> answers, List<String> hashtagsVisible, List<String> hashtagsInvisible, int likes) {
        this.id = id;
        this.message = message;
        this.pinned = pinned;
        this.date = date;
        this.time = time;
        this.userId = userId;
        this.answers = answers;
        this.hashtagsVisible = hashtagsVisible;
        this.hashtagsInvisible = hashtagsInvisible;
        this.likes = likes;
    }
}
