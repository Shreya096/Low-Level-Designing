package imemory.lru.util;

import java.util.Scanner;

import imemory.lru.factory.CacheType;
import imemory.lru.service.CacheService;

public class CacheUtils {

    final static CacheType cacheType = CacheType.LRU;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of cache : ");
        int maxSize = scanner.nextInt();

        CacheService.initializeService(maxSize, cacheType);

        while (true) {
            System.out.println("1 -- Insert ");
            System.out.println("2 -- Fetch ");
            System.out.println("3 -- Delete");
            System.out.println("4 -- Clear ");
            System.out.println("5 -- Exit");

            System.out.println(" Enter operation : ");
            int operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    CacheService.insert();
                    break;
                case 2:
                    CacheService.fetch();
                    break;
                case 3:
                    CacheService.delete();
                    break;
                case 4:
                    CacheService.clear();
                    break;
                case 5:
                    System.exit(0);
                default:
                  System.out.println("Enter valid operation");

            }

        }

    }

}
