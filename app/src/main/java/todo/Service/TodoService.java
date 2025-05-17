package todo.Service;
import todo.Entity.Todo;
import java.util.List;
import java.util.ArrayList;
public class TodoService {
    

    List<Todo> todos = new ArrayList<>();  //creating an array list for storing the todo

    //add todo

    public void addTodo(Todo todo){
        todos.add(todo);  // todo list contains todo objects
        System.out.println(" " +todo.getTitle()+"todo added successfully");
    }

    public void statusUpdate(int id){
        // Boolean found = false;
        for(Todo todo:todos){
            if(todo.getId() == id){
                // found = true;
                todo.updateTodo();
            }   
            }
            // if(!found){
            //     System.out.println("Id not found");
            // }
            
    }

    public void updateTodo(int id,String description){
        // todo.updateDetails(description);
        // Boolean found = false;
        for(Todo todo:todos){
            if(todo.getId() == id){
                // found = true;
                todo.updateDetails(description);
            }   
            }
            // if(!found){
                // System.out.println("Id not found");
            // }
    }

    public Boolean idFound(int id){
        for(Todo todo:todos){
            if(todo.getId() == id){
                
               return true; 
            }   
            }
        return false;
    }

    public void viewTodos(){

        if(todos.isEmpty()){
            System.out.println("No todos ");
        }
        else{
            System.out.println("*******************");
            for(Todo todo:todos){

                
                System.out.println(todo);
                System.out.println();
                System.out.println();
                System.out.println();
                
            }
            System.out.println("*******************");

        }
    }

    public void deleteTodo(int id){
         for (int i = 0; i < todos.size(); i++) {
        if (todos.get(i).getId() == id)  //getting the todo whose id is matched
            {
            todos.remove(i);
            System.out.println("Todo with ID " + id + " removed successfully.");
            updateId();
            break;
            }
        } 
    }

    //It's better not to reassign IDs. in real world problems
    public void updateId(){
        int count = 1;
        for(Todo todo:todos){
            todo.setId(count++);
        }

        // this is for updating the id for the new elements 
        // without the below code when we add a new todo its id get continued without updating
        Todo.resetId();
        Todo.setCount(todos.size());
    }
        
}
