package todo.Repository;

import todo.Entity.Todo;
import java.util.List;

public interface TodoRepository {
    void add(Todo todo);
    boolean deleteById(int id);
    Todo getById(int id);
    List<Todo> getAll();
}
