package com.korayaks.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table(value = "accounts")
public class Account implements Serializable {
    @PrimaryKey
    private String id = UUID.randomUUID().toString();
    @Setter
    @Column(value = "uname")
    private String username;
    @Column(value = "email")
    @Setter
    private String email;
    @Column(value = "pwd")
    @Setter
    private String passwd;
    @Column(value = "crated_at")
    private Date createdAt;
    @Column(value = "is_active")
    private Boolean active;
}
