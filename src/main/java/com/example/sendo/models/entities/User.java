package com.example.sendo.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private String phone;
    private Boolean status = true;

    @Column(insertable = false, updatable = false)
    private Long roleId;

    public User(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "roleId", foreignKey = @ForeignKey(name = "fk_user_role"))
    private Role role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userToken")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<RefreshToken> tokenList;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "userOrder")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Order> orderList;
}
