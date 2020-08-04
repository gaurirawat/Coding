package SupportMaterial.CollectionsAndJava8;
//https://www.baeldung.com/java-8-sort-lambda
import java.util.*;

public class Sorting {

        public static void main(String[] args) {
//        Sorting
        List<Human> humans = Arrays.asList(
                new Human("Sarah", 10),
                new Human("Jack", 12)
        );

//        Without lambda:
        Collections.sort(humans, new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return h1.getName().compareTo(h2.getName());
            }
        });

//        With lambda:
        humans.sort((Human h1, Human h2) -> h1.getName().compareTo(h2.getName()));
        humans.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
        Collections.sort(humans, Comparator.comparing(Human::getName));

//        Reversed:
        Comparator<Human> comparator= (h1, h2) -> h1.getName().compareTo(h2.getName());
        humans.sort(comparator.reversed());

//        Sorting with conditions:
        humans.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));


    }
}
class Human {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
// standard constructors, getters/setters, equals and hashcode
}