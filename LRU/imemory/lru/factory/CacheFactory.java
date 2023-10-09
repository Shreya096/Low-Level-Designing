package imemory.lru.factory;

import imemory.lru.datasource.CacheDataStore;
import imemory.lru.datasource.Cache;
import imemory.lru.datasource.LRUCache;

public class CacheFactory {
    private static Cache cache;

    public static Cache createFactory(int max_size, CacheType type) {
        if (cache != null)
            return cache;

        switch (type) {
            case LRU:
                cache = LRUCache.createCache(max_size);
                break;
            default:
                cache = null;
        }
        return cache;
    }

}
