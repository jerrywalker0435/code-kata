package com.apple.filter;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class AppleFilterTest {

    private List<Apple> appleRepo;

    @Before
    public void givenAppleRepo(){
        //given
        Apple apple1 = new Apple("red",110);
        Apple apple2 = new Apple("red",80);
        Apple apple3 = new Apple("green",120);
        Apple apple4 = new Apple("red",130);

        appleRepo = asList(apple1,apple2,apple3,apple4);

    }

    @Test
    public void whenFilterRedThenRemain3(){

        Predicate<Apple> redApple = apple -> apple.getColor().equals("red");
        //when
        List<Apple> filteredApples = AppleFilter.filterWithSpec(appleRepo, redApple);

        //then
        assertThat(filteredApples.size()).isEqualTo(3);


    }

    @Test
    public void whenFilterGreenThenRemain1(){


        //when
        List<Apple> filteredApples = appleRepo.stream().filter(apple -> apple.getColor().equals("green")).collect(Collectors.toList()); ;


        //then
        assertThat(filteredApples.size()).isEqualTo(1);


    }

    @Test
    public void whenFilterGTWeight100ThenRemain3(){
        Predicate<Apple> weight = apple -> apple.getWeight()>100;


        //when
        List<Apple> filteredApples = appleRepo.stream().filter(apple -> apple.getWeight()>100).collect(Collectors.toList()); ;

        //then
        assertThat(filteredApples.size()).isEqualTo(3);


    }
    @Test
    public void whenFilterRedAndGTWeight100ThenRemain2(){
        Predicate<Apple> weight = apple -> apple.getWeight()>100;
        Predicate<Apple> red = apple -> apple.getColor().equals("red");


        //when
        List<Apple> filteredApples = AppleFilter.filterWithSpec(appleRepo,red.and(weight));

        //then
        assertThat(filteredApples.size()).isEqualTo(2);


    }
    @Test
    public void whenFilterNotRedAndThenRemain1(){
        Predicate<Apple> red = apple -> apple.getColor().equals("red");


        //when
        List<Apple> filteredApples = AppleFilter.filterWithSpec(appleRepo,red.negate());

        //then
        assertThat(filteredApples.size()).isEqualTo(1);


    }
    @Test
    public void whenFilterRedOrGt100AndThenRemain4(){
        Predicate<Apple> weight = apple -> apple.getWeight()>100;
        Predicate<Apple> red = apple -> apple.getColor().equals("red");

        //when
        List<Apple> filteredApples = AppleFilter.filterWithSpec(appleRepo,red.or(weight));

        //then
        assertThat(filteredApples.size()).isEqualTo(4);


    }
}
