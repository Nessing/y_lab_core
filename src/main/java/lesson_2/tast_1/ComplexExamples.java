package lesson_2.tast_1;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };
        /*  Raw data:

        0 - Harry
        0 - Harry
        1 - Harry
        2 - Harry
        3 - Emily
        4 - Jack
        4 - Jack
        5 - Amelia
        5 - Amelia
        6 - Amelia
        7 - Amelia
        8 - Amelia

        **************************************************

        Duplicate filtered, grouped by name, sorted by name and id:

        Amelia:
        1 - Amelia (5)
        2 - Amelia (6)
        3 - Amelia (7)
        4 - Amelia (8)
        Emily:
        1 - Emily (3)
        Harry:
        1 - Harry (0)
        2 - Harry (1)
        3 - Harry (2)
        Jack:
        1 - Jack (4)

     */

    /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */

    public static void main(String[] args) {
        System.out.println("Raw data:");
        System.out.println();


//        for (Person person : RAW_DATA) {
//            System.out.println(person.id + " - " + person.name);
//        }
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("Duplicate filtered, grouped by name, sorted by name and id:");
        System.out.println();

        /** TASK 1 **/
//        tast1(RAW_DATA);

        /** TASK 2 **/
//        int[] array = new int[] {3, 4, 2, 7};
//        tast2(array, 10);

        /** TASK 3 **/
//        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); // true
//        System.out.println(fuzzySearch("cwhl", "cartwheel")); // true
//        System.out.println(fuzzySearch("cwhee", "cartwheel")); // true
//        System.out.println(fuzzySearch("cartwheel", "cartwheel")); // true
//        System.out.println(fuzzySearch("cwheeel", "cartwheel")); // false
//        System.out.println(fuzzySearch("lw", "cartwheel")); // false
//        System.out.println(fuzzySearch("ers", "ghenrokss")); // true
//        System.out.println(fuzzySearch("erss", "ghenroks")); // false

        /*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

            Что должно получиться
                Key: Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
         */



        /*
        Task2

            [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
         */



        /*
        Task3
            Реализовать функцию нечеткого поиска

                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */
    }

    public static void tast1(Person[] persons) {
        // убираются дубликаты
        List<Person> person = Arrays.stream(persons)
                .distinct()
                .toList();
        // группировка по имени
        Map<String, List<Person>> map = person.stream()
                .collect(Collectors.groupingBy(Person::getName));
        // сортировка по имени
        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // печать в консоль
        map.forEach((key, value) -> System.out.printf("Key: %s\nValue:%d\n", key, value.size()));
    }

    public static void tast2(int[] array, int sum) {
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                if (first + second == sum) {
                    System.out.printf("[%d, %d]\n", first, second);
                    return;
                }
            }
        }
        System.out.println("Такой пары нет");
    }

    public static boolean fuzzySearch(String searching, String where) {
        boolean result = false;
        int point = 0;
        for (int i = 0; i < searching.length(); i++) {
            char first = searching.charAt(i);
            result = false;
            for (int j = point; j < where.length(); j++) {
                char second = where.charAt(j);
                if (first == second) {
                    result = true;
                    point = j + 1;
                    break;
                }
            }
            if (!result) return false;
        }
        return result;
    }
}
