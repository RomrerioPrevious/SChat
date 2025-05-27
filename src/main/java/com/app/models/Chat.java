package com.app.models;

import lombok.Getter;
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
}
