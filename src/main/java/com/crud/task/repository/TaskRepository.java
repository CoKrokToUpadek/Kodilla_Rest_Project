package com.crud.task.repository;

import com.crud.task.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    List<Task> findAll();
    @Override
    Optional<Task> findById(Long id);
}
