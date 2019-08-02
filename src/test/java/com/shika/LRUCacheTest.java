package com.shika;

public class LRUCacheTest {

    @org.junit.Test
    public void put() throws Exception {
        LRUCache<String, String> lru = new LRUCache<>(2);
        lru.put("Lucy", "工程部");
        lru.put("June", "应用部");
        lru.put("Jam", "设计部");
        System.out.println(lru);
        System.out.println(lru.get("Jam"));
    }

    @org.junit.Test
    public void get() throws Exception {
    }

}