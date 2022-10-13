package br.com.fiap.epictaskapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.epictaskapi.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.status < 100")
    List<Task> findPending();

    @Query("SELECT t FROM Task t WHERE t.status = 100")
    List<Task> findDone();

    
}
