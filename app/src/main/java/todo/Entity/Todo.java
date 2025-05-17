package todo.Entity;

public class Todo {
    private static int count=0;
    private int id;
    private String title;
    private String description;
    private Boolean is_completed;


    public Todo(String title,String description){
        count++;
        this.id = count;
        this.title = title;
        this.description = description;
        this.is_completed = false;
    }

    public  String getTitle(){
        return this.title;
    }
    public  int getId(){
        return this.id;
    }

    public void setId(int count){
         this.id = count;
    }

    public  String getDetails(){
        return this.description;
    }
    public void updateDetails(String description){
        this.description = description;
    }

    public void updateTodo(){

           this.is_completed = !this.is_completed;
        }


    public static void resetId(){
        count = 0;
    }
    public static void setCount(int countnew){
        count = countnew;
    }

  @Override
    public String toString() {
        // return this.id +"-" +this.title +"(Titi)" "\n" + this.description +" \n Status "+ (this.is_completed ? " (Done)" : " (Pending)");
        return " id: "+this.id+"\n Title - "+this.title+"\n Description - "+this.description+" \n Status - "+(this.is_completed ? " (Done)" : " (Pending)");
    }
}
