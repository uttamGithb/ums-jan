package com.ums;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class A {

    public static void main(String[] args) {
        A a1=new A();
        int val=a1.test1();
        System.out.println(val);
    }
    public int test1(){
        System.out.println(100);
        return 1000;
    }
}
