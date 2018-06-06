import java.util.*;
import java.util.stream.Collectors;

public class Main {

    /*Remove duplicates from Collection with maintaining it's order.*/

    private Collection<String> someValues;

    public void someMethod(Collection<String> values){
        values.forEach(System.out::println);
    }

    /* First method -> JAVA 1.8 using streams*/
    public void removeDuplicates(Collection<String> values){
        someValues  = values.stream()
                            .distinct()
                            .collect(Collectors.toList());
    }

    /* Second method -> Using Sets but maintain order -> LinkedHashSet*/
    public void removeDuplicates2(Collection<String> values){
        someValues = new ArrayList<String>(new LinkedHashSet<String>(values));
    }

    /*Third method old approach -> forEach + contains*/
    public void removeDuplicates3(Collection<String> values){
        List<String> distinctList = new ArrayList<>();
        for(String name : values){
            if(!distinctList.contains(name))
                distinctList.add(name);
        }
        someValues = distinctList;
    }

    /*Fourth method older approach -> iterator*/
    public void removeDuplicates4(Collection<String> values){
        Iterator<String> iterator = values.iterator();
        List<String> distinctList = new ArrayList<>();
        while(iterator.hasNext()){
            String value = iterator.next();
            if(!distinctList.contains(value))
                distinctList.add(value);
        }
        someValues = distinctList;
    }

    public void add(String value){
        someValues.add(value);
    }

    public void fillCollection(Collection<String> collection){
        add("value");
        add("value");
        add("value2");
        add("value2");
        add("value2");
    }


    public static void main(String[] args) {
       Main main = new Main();
       main.someValues = new ArrayList<String>();

       main.fillCollection(main.someValues );
       System.out.println("Before removing - first method");
       main.someMethod(main.someValues);
       main.removeDuplicates(main.someValues);
       System.out.println("After removing - first method");
       main.someMethod(main.someValues);

       main.fillCollection(main.someValues );
       System.out.println("Before removing - second method");
       main.someMethod(main.someValues);
       main.removeDuplicates2(main.someValues);
       System.out.println("After removing - second method");
       main.someMethod(main.someValues);

       main.fillCollection(main.someValues );
       System.out.println("Before removing - third method");
       main.someMethod(main.someValues);
       main.removeDuplicates3(main.someValues);
       System.out.println("After removing - third method");
       main.someMethod(main.someValues);


        main.fillCollection(main.someValues );
        System.out.println("Before removing - fourth method");
        main.someMethod(main.someValues);
        main.removeDuplicates4(main.someValues);
        System.out.println("After removing - fourth method");
        main.someMethod(main.someValues);
    }
}
