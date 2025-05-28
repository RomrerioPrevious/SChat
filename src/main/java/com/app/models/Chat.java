package com.app.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Table("chats")
public class Chat {
    @Id
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long id;

    @Column
    @CassandraType(type = CassandraType.Name.TEXT)
    private String name;
    @Column
    @CassandraType(type = CassandraType.Name.TEXT)
    private String description;
    @Column
    @CassandraType(type = CassandraType.Name.DATE)
    private LocalDate date;
    @Column
    @CassandraType(type = CassandraType.Name.TIME)
    private LocalTime time;
    @Column
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.BIGINT)
    private List<Long> users;
    @Column
    @CassandraType(type = CassandraType.Name.TEXT)
    private String secret;
    @Column
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.BIGINT)
    private List<Long> messages;
    @Column
    @CassandraType(type = CassandraType.Name.TEXT)
    private String avatar;
    @Column("is_secret")
    @CassandraType(type = CassandraType.Name.BOOLEAN)
    private boolean isSecret;

    public Chat(long id, String name, String description, LocalDate date, LocalTime time, List<Long> users, String secret, List<Long> messages, String avatar, boolean isSecret) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.time = time;
        this.users = users;
        this.secret = secret;
        this.messages = messages;
        this.avatar = avatar;
        this.isSecret = isSecret;
    }
}
