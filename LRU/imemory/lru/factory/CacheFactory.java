package imemory.lru.factory;

import imemory.lru.datasource.Cache;
import imemory.lru.datasource.CacheOperations;
import imemory.lru.datasource.LRUCache;

public class CacheFactory {
    private static CacheOperations cacheOperations;
    private static Cache cache;

    public static CacheOperations createFactory(int max_size, CacheType type) {
        if (cacheOperations != null)
            return cacheOperations;

        cache = Cache.createInstance(max_size);
        switch (type) {
            case LRU:
                cacheOperations = new LRUCache(cache);
                break;
            default:
                cacheOperations = null;
        }
        return cacheOperations;
    }

}
