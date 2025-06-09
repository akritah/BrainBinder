import java.time.LocalDate;

public class Assignment {
    String name;
    private LocalDate dueDate;
    boolean completed;

    Assignment(String name,  LocalDate dueDate) {
        this.name = name;
        this.dueDate = dueDate;
        this.completed = false;
    }

    @Override
    public String toString() {
        return name + " (Due: " + dueDate + ")";
    }
    public String getName() {
      return name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}
