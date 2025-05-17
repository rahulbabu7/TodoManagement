package todo.Repository;

import todo.Entity.Todo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTodoRepository implements TodoRepository {

    private static final String FILE_NAME = "todos.txt";

    @Override
    public void add(Todo todo) {
        List<Todo> todos = getAll();
        todos.add(todo);
        saveAll(todos);
    }

    @Override
    public boolean deleteById(int id) {
        List<Todo> todos = getAll();
        boolean removed = todos.removeIf(todo -> todo.getId() == id);
        saveAll(todos);
        return removed;
    }

    @Override
    public Todo getById(int id) {
        for (Todo todo : getAll()) {
            if (todo.getId() == id) return todo;
        }
        return null;
    }

   @SuppressWarnings("unchecked")
@Override
public List<Todo> getAll() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
        return (List<Todo>) ois.readObject();
    } catch (Exception e) {
        return new ArrayList<>();
    }
}

    private void saveAll(List<Todo> todos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(todos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
