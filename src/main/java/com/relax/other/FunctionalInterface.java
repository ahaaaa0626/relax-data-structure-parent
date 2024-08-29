package com.relax.other;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Author relax
 * @Date 2024/8/29 14:37
 * @Description functional interface
 * @Version 1.0
 **/
public class FunctionalInterface {

    @Test
    public void testConsumer() {

        happyTime(101, new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(101 + " people");
            }
        });

    }

    public void happyTime(int num, Consumer<Integer> con) {
        System.out.println("this is consumer interface!");
        con.accept(num);
    }



    @Test
    public void testSupplier(){
        String name = getName(new Supplier<String>() {
            @Override
            public String get() {
                return "_ahaaaa";
            }
        });

        System.out.println(name);

    }

    public String getName(Supplier<String> sup){
        return sup.get();
    }


    @Test
    public void testFunction(){
        Integer result = calculateResult(101, new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return ++integer;
            }
        });

        System.out.println(result);

    }

    public Integer calculateResult(int num, Function<Integer, Integer> function){
        return function.apply(num);
    }


    @Test
    public void testPredicate(){

        boolean apply = isApply(0, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 0;
            }
        });

        System.out.println(apply);

    }

    public boolean isApply(int flag, Predicate<Integer> predicate){
        return predicate.test(flag);
    }

}
