package imemory.lru.datasource;

import imemory.lru.dto.Pair;

public interface CacheOperations {

    public void clear();

    public Pair fetch(String key);

    public  Pair insert(String key, Object object) ;

    public  Pair delete(String key) ;

}
