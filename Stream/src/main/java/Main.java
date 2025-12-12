import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Alex", 35));
        users.add(new User("Max", 17));
        users.add(new User("John", 22));
        users.add(new User("Andrew", 33));
        users.add(new User("Jack", 44));
        users.add(new User("Nick", 80));
        users.add(new User("Alice", 46));
        users.add(new User("Helen", 11));

        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .filter((n) -> n.getAge() < 40)
                .limit(3)
                .map(User::getName)
                .forEach(System.out::println);
    }
}

