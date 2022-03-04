import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sobes {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Path path = Paths.get("src/persons.txt");
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size(); i = i + 3) {
                User usr = new User();
                usr.setSurname(lines.get(i));
                usr.setName(lines.get(i + 1));
                usr.setAge(Integer.parseInt(lines.get(i + 2)));
                users.add(usr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        users.sort(Comparator.comparing(User::getAge));
        users.forEach(System.out::println);

    }

    public static class User {
        public String name;
        public String surname;
        public int age;

        public User(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public User() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name + " " + surname + ", " + age;

        }
    }


}
