package com.demo;

import org.junit.Test;

import java.util.*;

public class IteratorTest {
    @Test
    public void test1() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("id", "1");
        hashMap.put("name", "张三");
        hashMap.put("age", "24");
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> s : entries) {
            System.out.println(s.getKey());
            System.out.println(s.getValue());
        }

        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey());
            System.out.println(next.getValue());
        }
    }
}
