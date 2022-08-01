package study.cherry.java.example;

import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        PredicateExample pe = new PredicateExample();

        // test
        System.out.println(pe.test("hello"));

        // negate
        System.out.println(pe.negate("hello"));

        // and
        System.out.println(pe.and("hello"));

        // or
        System.out.println(pe.or("hello"));

        // isEqual
        System.out.println(pe.isEqual("hello"));
    }

    public boolean test(String words) {
        Predicate<String> predicate = (str) -> str.length() > 3;

        return predicate.test(words);
    }

    public boolean and(String words) {
        Predicate<String> predicate1 = (str) -> str.length() > 3;
        Predicate<String> predicate2 = (str) -> str.length() > 10;

        return predicate1.and(predicate2).test(words);
    }

    public boolean negate(String words) {
        Predicate<String> predicate = (str) -> str.length() > 3;
        Predicate<String> negate = predicate.negate();
        return negate.test(words);
    }

    public boolean or(String words) {
        Predicate<String> predicate1 = (str) -> str.length() > 3;
        Predicate<String> predicate2 = (str) -> str.length() > 10;

        return predicate1.or(predicate2).test(words);
    }

    public boolean isEqual(String words) {
        Predicate<String> predicate = Predicate.isEqual("java");
        return predicate.test(words);
    }


}
