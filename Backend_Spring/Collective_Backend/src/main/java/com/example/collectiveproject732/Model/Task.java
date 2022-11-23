package com.example.collectiveproject732.Model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Task {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public Category category;

    @NotNull
    public String name;

    @OneToMany(mappedBy = "task")
    List<UserTask> usersTasks;

}