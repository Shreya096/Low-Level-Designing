package imemory.lru.datasource;

import imemory.lru.dto.Pair;

public abstract class Cache {

    protected static Cache cache;
    protected static CacheDataStore cacheDataStore;

    public abstract void clear();

    public abstract Pair fetch(String key);

    public abstract Pair insert(String key, Object object);

    public abstract Pair delete(String key);

}
