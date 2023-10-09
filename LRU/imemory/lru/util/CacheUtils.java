package imemory.lru.util;

import java.util.Scanner;

import imemory.lru.factory.CacheType;
import imemory.lru.service.CacheDAO;

public class CacheUtils {

    final static CacheType cacheType = CacheType.LRU;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter size of cache : ");
        int maxSize = scanner.nextInt();

        CacheDAO.initializeService(maxSize, cacheType);

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
                    CacheDAO.insert();
                    break;
                case 2:
                    CacheDAO.fetch();
                    break;
                case 3:
                    CacheDAO.delete();
                    break;
                case 4:
                    CacheDAO.clear();
                    break;
                case 5:
                    System.exit(0);
                default:
                  System.out.println("Enter valid operation");

            }

        }

    }

}
