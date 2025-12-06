package examples;

public class Worker {
    String name;
    String post;
    int salary;

    Worker(String name, String post, int salary) {
        this.name = name;
        this.post = post;
        this.salary = salary;
    }

    void getInfo() {
        System.out.println("Name: " + name + "\nPost: " + post + "\nSalary: " + salary);
    }


}
