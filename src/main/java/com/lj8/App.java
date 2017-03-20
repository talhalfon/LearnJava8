package com.lj8;

import java.util.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

/**
 * Learn Java 8!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        double s1 = formula.calculate(100);     // 100.0
        double s2 = formula.sqrt(16);

        System.out.println( s1 + " " + s2 );

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123

        Something something = new Something();
        Converter<String, String> converter1 = something::startsWith;
        String converted1 = converter1.convert("Java");
        System.out.println(converted1);    // "J"



        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person.firstName + " " + person.lastName);    // "J"


        final int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        stringConverter.convert(2);     // 3

        //Optionals
        Optional<String> optional = Optional.of("bam");

        optional.isPresent();           // true
        optional.get();                 // "bam"
        optional.orElse("fallback");    // "bam"

        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"

        Optional<String> optional1 = Optional.empty();
        boolean aaaaa =  optional1.isPresent();           // true
        System.out.println(aaaaa);

        //Streams
        System.out.println("********* Streams ********* ");
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        System.out.println(stringCollection);
        //Filter
        System.out.println("********* Filter ********* ");
        stringCollection
                .stream()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        //Sorted

        List<Boolean> boolCollection = new ArrayList<>();
        //boolCollection.add(true);

        System.out.println( boolCollection.stream().anyMatch((s) -> s.booleanValue()) );



        System.out.println("********* Sorted *********");
        stringCollection
                .stream()
                .sorted()
                .filter((s) -> s.startsWith("a"))
                .forEach(System.out::println);
        //Map
        System.out.println("********* Map *********");
        stringCollection
                .stream()
                .map(String::toUpperCase)
                .sorted((a, b) -> b.compareTo(a))
                .forEach(System.out::println);
        //Match
        System.out.println("********* Match *********");
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));

        System.out.println(anyStartsWithA);      // true

        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));

        System.out.println(allStartsWithA);      // false

        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));

        System.out.println(noneStartsWithZ);      // true
        //Count
        System.out.println("********* Count *********");
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();

        System.out.println(startsWithB);    // 3


        List<Double> sqrtOfFirst100Primes =
            Stream.iterate(1, e -> e + 1)
                    .filter(Sample::isPrime)
                    .map(Math::sqrt)
                    .limit(100)
                    .collect(toList());

        System.out.println(String .format("Computer %d values, fiorst is %g, last is %g",
                sqrtOfFirst100Primes.size(),
                sqrtOfFirst100Primes.get(0),
                sqrtOfFirst100Primes.get(sqrtOfFirst100Primes.size()-1) ));

        System.out.println("********* functional programming  *********");
        Integer  number = FunctionClass.invertTheNumber(5);
        System.out.println(number);
   }
}
