package com.example.collectiveproject732.Model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Table(name = "users")
@Entity
@Getter
@Setter
public class User {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String firstName;

    @NotNull
    public String userName;

    @NotNull
    public String lastName;

    //todo make this stuff work idk
    public String password;
    @NotNull
    public String email;

    @NotNull
    public boolean isAdmin;

    @OneToMany(mappedBy = "user")
    public List<UserTask> userTasks;
}
