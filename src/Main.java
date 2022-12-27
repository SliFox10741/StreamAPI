import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        Stream<Person> stream = persons.stream();
        Stream<Person> stream2 = persons.stream();
        Stream<Person> stream3 = persons.stream();

        //поиск кол-ва несовершеннолетних
        long count = stream.filter(person -> person.getAge() < 18).count();
        System.out.println(count);

        //поиск презывников
        List<String> count2 = stream2.filter( person -> (person.getAge() >= 18 && person.getAge() < 27)).
                map(Person::getFamily).
                toList();
        System.out.println(count2);

        //отсортированный по фамилии список людей от 18 до 60 лет с высшим образованием
        List<String> count3 =
                stream3.filter(person -> (person.getAge() >= 18 &&
                                person.getAge() <= 60 &&
                                person.getEducation() == Education.HIGHER))
                .map(Person::getFamily).sorted(Comparator.naturalOrder()).
                toList();
        System.out.println(count3);
    }
}