package com.yeyu.test;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * @program: my-admin
 * @description:
 * @author: ganzj
 * @create: 2020-11-05 10:55
 */
public class TestStringJoner {

    public static void main(String[] args) {
        TestStringJoner s = new TestStringJoner();
        s.test01();
    }

    @Test
    public  void test01(){
        StringJoiner a = new StringJoiner(",","222","333");

        System.out.println(a.add("aaa").toString());
        System.out.println(a.add("bbb").toString());
        System.out.println(a.add("ccc").toString());
    }
}
