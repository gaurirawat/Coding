package SupportMaterial.CollectionsAndJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//http://tutorials.jenkov.com/java-functional-programming/streams.html
public class Streams_string {
    /*
Non-Terminal Operations
    filter()    map()    flatMap()    distinct()    limit()    peek()

Terminal Operations
    anyMatch()    allMatch()    noneMatch()    collect()    count()    findAny()
    findFirst()    forEach()    min()    max()    reduce()    toArray()
     */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        //anyMatch
        boolean anyMatch = stream.anyMatch((value) -> { return value.startsWith("One"); });
        System.out.println(anyMatch);

        //allMatch
        boolean allMatch = stream.allMatch((value) -> { return value.startsWith("One"); });
        System.out.println(allMatch);

        //noneMatch
        boolean noneMatch = stream.noneMatch((element) -> {return "xyz".equals(element);});
        System.out.println("noneMatch = " + noneMatch);

        //collect
        List<String> stringsAsUppercaseList = stream.map(value -> value.toUpperCase()).collect(Collectors.toList());
        System.out.println(stringsAsUppercaseList);

        //count:
        long count = stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        }).count();
        System.out.println("count = " + count);


        stringList = new ArrayList<String>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");
        stream = stringList.stream();

        //You can check if the Optional returned contains an element via its isPresent() method.
        //If the Stream is empty, the Optional get() method will throw a NoSuchElementException.
        //findAny
        Optional<String> anyElement = stream.findAny();
        System.out.println(anyElement.get());

        //findFirst
        Optional<String> result = stream.findFirst();
        System.out.println(result.get());

        //forEach
        stream.forEach( element -> { System.out.println(element); });

        //min
        Optional<String> min = stream.min((val1, val2) -> {return val1.compareTo(val2);});
        String minString = min.get();
        System.out.println(minString);

        //max
        Optional<String> max = stream.max((val1, val2) -> {return val1.compareTo(val2);});
        String maxString = max.get();
        System.out.println(maxString);

        //reduce
        Optional<String> reduced = stream.reduce((value, combinedValue) -> {return combinedValue + " + " + value;});
        System.out.println(reduced.get());

        //toArray
        Object[] objects = stream.toArray();

        //Concatenate Streams
        stringList = new ArrayList<String>();
        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a mockingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream1 = stringList.stream();
        List<String> stringList2 = new ArrayList<>();
        stringList2.add("Lord of the Rings");
        stringList2.add("Planet of the Rats");
        stringList2.add("Phantom Menace");

        Stream<String> stream2 = stringList2.stream();
        Stream<String> concatStream = Stream.concat(stream1, stream2);
        List<String> stringAsUppercaseList = concatStream.collect(Collectors.toList());

        System.out.println(stringAsUppercaseList);

        //Create Stream From Array
        Stream<String> streamOf = Stream.of("one", "two", "three");

    }
}
