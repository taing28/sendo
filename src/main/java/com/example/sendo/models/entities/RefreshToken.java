package com.example.sendo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime expiredTime = LocalDateTime.now();
    private String token;
    @Column(insertable = false, updatable = false)
    private Long userId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId", foreignKey = @ForeignKey(name = "fk_token_user"))
    private User userToken;
}
