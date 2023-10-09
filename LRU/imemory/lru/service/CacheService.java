package imemory.lru.service;

import java.util.Scanner;

import imemory.lru.datasource.Cache;
import imemory.lru.datasource.CacheOperations;
import imemory.lru.dto.Pair;
import imemory.lru.factory.CacheType;
import imemory.lru.factory.CacheFactory;

public class CacheService {

    private static CacheOperations cacheOperations;
    private static Scanner scanner;

    public static void initializeService(int max_size, CacheType cacheType) {
        cacheOperations = CacheFactory.createFactory(max_size, cacheType);
        scanner = new Scanner(System.in);
    }

    public static void insert() {
        System.out.println("Enter key and value to insert : \n Enter key :");
        String key = scanner.next();
        System.out.println("Enter value :");
        String value = scanner.next();
        Pair pair = cacheOperations.insert(key, value);
        System.out.println(pair + " is inserted successfully");

    }

    public static void fetch() {
        System.out.println("Enter key to fetch :");
        String key = scanner.next();
        Pair pair = cacheOperations.fetch(key);
        if (pair != null)
            System.out.println(pair + " is fetched successfully");
        else
            System.out.println("No value for key : " + key);

    }

    public static void clear() {
        cacheOperations.clear();
        System.out.println("Cache is cleared successfully");
    }

    public static void delete() {
        System.out.println("Enter key to delete:");
        String key = scanner.next();

        Pair pair = cacheOperations.delete(key);
       if (pair != null)
            System.out.println(pair + " is deleted successfully");
        else
            System.out.println("No value for key : " + key);

    }

}