package todo.Repository;

import todo.Entity.Todo;
import java.util.ArrayList;
import java.util.List;

public class InMemoryTodoRepository implements TodoRepository {
    private List<Todo> todos = new ArrayList<>();

    @Override
    public void add(Todo todo) {
        todos.add(todo);
    }

    @Override
    public boolean deleteById(int id) {
    for (int i = 0; i < todos.size(); i++) {
        if (todos.get(i).getId() == id) {
            todos.remove(i);
            return true;
        }
    }
    return false;
}

    @Override
    public Todo getById(int id) {
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }

    @Override
    public List<Todo> getAll() {
        return todos;
    }
}
