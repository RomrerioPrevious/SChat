package com.app.models;

import lombok.*;
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
@AllArgsConstructor
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

    public Post(long id) {
        this.id = id;
    }
}
