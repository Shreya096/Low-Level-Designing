package imemory.lru.datasource;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import imemory.lru.dto.Pair;

public class LRUCache implements  CacheOperations {

    private Cache cache;
    private static Deque<String> keyList;

    public LRUCache(Cache cache){
        this.cache = cache;
    }

    public  void clear() {
        if (cache.getData() == null)
            return;

        cache.getData().clear();
        if(keyList!=null && keyList.size()>0)
            keyList.clear();
    }

    public Pair fetch(String key) {
        if (cache==null || cache.getData()==null)
            return null;

        Pair pair = null;
        if (cache.getData().get(key) == null) {
            return null;
        } else {
            keyList.remove(key);
            keyList.addFirst(key);
            pair = new Pair(key, cache.getData().get(key));
        }
        return pair;
    }

    public  Pair insert(String key, Object object) {
        Pair pair = null;
        if (cache==null || cache.getData()==null || keyList == null ) {
            cache=Cache.createInstance(10);
            keyList = new LinkedList<String>();
            if (cache.getData() == null) {
                cache.setData(new HashMap<>());
            }
        } else if (keyList.size() >= cache.getMax_size()) {
            String keyRemoved = keyList.removeLast();
            cache.getData().remove(keyRemoved);

        } else {
            keyList.remove(key);
        }

        keyList.addFirst(key);
        cache.getData().put(key, object);
        pair = new Pair(key, object);
        return pair;
    }

    public  Pair delete(String key) {
        if (cache==null || cache.getData()==null || keyList == null || keyList.size() == 0)
            return null;

        Pair pair = null;
        if (cache.getData().get(key) == null) {
            return null;
        } else {
            pair = new Pair(key, cache.getData().get(key));
            keyList.remove(key);
            cache.getData().remove(key);
        }
        return pair;
    }

}
