package com.apple.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class AppleFilter {

    public static List<Apple> filterWithSpec(List<Apple> appleRepo, Predicate spec) {
        List<Apple> filtered = new ArrayList<>();
        for (Apple apple : appleRepo) {
            if (spec.test(apple)) {
                filtered.add(apple);
            }

        }
        return filtered;
    }

}
