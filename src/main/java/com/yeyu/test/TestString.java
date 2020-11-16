package com.yeyu.test;

import org.junit.Test;

/**
 * @program: my-admin
 * @description:
 * @author: ganzj
 * @create: 2020-11-12 15:10
 */
public class TestString {

    @Test
    public void testStringStr(){
       String str = "123/abc";
        System.out.println(str.substring(0,1).equals("/"));
        System.out.println(str.substring(0,1).equals("/")?str:"/"+str);
    }

    @Test
    public void test2(){
        int x=5,y=7,u=9,v=6;
        System.out.println(x>y ? x+2:u>v ? u-3:v+2);
    }

    @Test
    public void test3(){
        String s1="123";
        String s2="123";
        String s3=new String("123");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
    }

    @Test
    public void test4(){
        String s="0123456789",s1,s2;
        s1=s.substring(2);s2=s.substring(2,5);System.out.println(s1+s2);
    }

    @Test
    public void test5(){
        int x = 10;
        while (x > 7)
        { System.out.print("*"); x--;}
    }
    
    @Test
    public void test6(){
        int[][] x={{1,2},{3,4,5},{6},{}};
        System.out.println(x.length);
    }

    class U{
//        int a= 078;
//        int b = AA;
        int c = 5000;
        int d = 0x3ABC;
        int x;
        int y;
        U(int a, int b){x= a; y = b;}
        void copy(U a){ x = a.x; y = a.y;}
    }
    U u = new U(1, 2), v = new U(2, 3);
}
