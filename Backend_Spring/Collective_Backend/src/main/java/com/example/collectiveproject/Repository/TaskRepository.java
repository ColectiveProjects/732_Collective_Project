package com.example.collectiveproject.Repository;

import com.example.collectiveproject.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findAll();
}
