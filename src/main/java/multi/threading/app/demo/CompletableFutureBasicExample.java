package multi.threading.app.demo;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
    int id;
    String name;
    Employee(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
public class CompletableFutureBasicExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.supplyAsync(()->getEmployees())
                         .thenApplyAsync((employees)->employeeNameStartWithLetter_K(employees))
                         .thenAcceptAsync((employees)->showRecords(employees))
                         .get();
    }

    public static List<Employee> getEmployees(){
        return Stream.of(new Employee(11,"kaushal"),
                new Employee(12,"kaushalkebhaiya"),
                new Employee(13,"kanishk"),
                new Employee(14,"raghu"))
                .collect(Collectors.toList());
    }

    public static List<Employee> employeeNameStartWithLetter_K(List<Employee> employees){
        return employees.stream()
                .filter(emp->emp.name.startsWith("kau"))
                .collect(Collectors.toList());
    }
    public static void showRecords(List<Employee> employees){
        employees.stream()
                .forEach(System.out::println);
    }
}
