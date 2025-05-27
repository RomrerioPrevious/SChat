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
@Table("personal")
public class Personal {
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
    @Column("user_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long userId;
    @Column("chat_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long chatId;
    @Column
    @CassandraType(type = CassandraType.Name.LIST, typeArguments = CassandraType.Name.TEXT)
    private List<String> links;
    @Column("answer_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long answerId;
    @Column("forwarded_id")
    @CassandraType(type = CassandraType.Name.BIGINT)
    private long forwardedId;
    @Column("gif_link")
    @CassandraType(type = CassandraType.Name.TEXT)
    private String gifLink;
}
