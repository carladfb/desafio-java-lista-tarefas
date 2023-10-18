package dio.desafioprojetojava.repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dio.desafioprojetojava.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);

    List<Task> findByCompletedTrue();

    List<Task> findByCompletedFalse();

    Task findById(long id);
}
