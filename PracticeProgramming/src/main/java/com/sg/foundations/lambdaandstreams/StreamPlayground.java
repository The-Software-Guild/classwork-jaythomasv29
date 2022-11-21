package com.sg.foundations.lambdaandstreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPlayground {
    public static void main(String[] args) {
/**        There are many methods in the Stream class that allow us to process data using lambdas,
 *          but we primarly use filter, map, collect, and forEach.
 *
 */
        List<Person> peopleList = new ArrayList<>(Arrays.asList(
                new Person("James", 30),
                new Person("Lil Jon", 17),
                new Person("Monique", 54),
                new Person("Stephen", 30),
                new Person("Billy", 18),
                new Person("Michaelangelo", 20),
                new Person("Tiffany", 21),
                new Person("Phill", 7)
        ));

        List<Person> peopleCanVoteList = peopleList.stream().filter((p) -> p.getAge() >= 18).collect(Collectors.toList());
        List<Person> peopleCanDrinkList = peopleList.stream().filter((p) -> p.getAge() >= 21).collect(Collectors.toList());
        System.out.println(peopleCanDrinkList.toString());

        peopleList.stream().forEach((p) -> {
            System.out.println(p);
        });
    }
}
