package imemory.lru.datasource;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

import imemory.lru.dto.Pair;

public class LRUCache extends Cache {

    private static Deque<String> keyList;

    private LRUCache(){ 
    }

    public static Cache createCache(int maxSize){
        if(cache==null){
            cache = new LRUCache();
        }
        cacheDataStore=CacheDataStore.createInstance(maxSize);
        return cache;
    }


    public  void clear() {
        if (cacheDataStore.getData() == null)
            return;

        cacheDataStore.getData().clear();
        if(keyList!=null && keyList.size()>0)
            keyList.clear();
    }

    public Pair fetch(String key) {
        if (cacheDataStore==null || cacheDataStore.getData()==null)
            return null;

        Pair pair = null;
        if (cacheDataStore.getData().get(key) == null) {
            return null;
        } else {
            keyList.remove(key);
            keyList.addFirst(key);
            pair = new Pair(key, cacheDataStore.getData().get(key));
        }
        return pair;
    }

    public  Pair insert(String key, Object object) {
        Pair pair = null;
        if (cacheDataStore==null || cacheDataStore.getData()==null || keyList == null ) {
            cacheDataStore=CacheDataStore.createInstance(10);
            keyList = new LinkedList<String>();
            if (cacheDataStore.getData() == null) {
                cacheDataStore.setData(new HashMap<>());
            }
        } else if (keyList.size() >= cacheDataStore.getMax_size()) {
            String keyRemoved = keyList.removeLast();
            cacheDataStore.getData().remove(keyRemoved);

        } else {
            keyList.remove(key);
        }

        keyList.addFirst(key);
        cacheDataStore.getData().put(key, object);
        pair = new Pair(key, object);
        return pair;
    }

    public  Pair delete(String key) {
        if (cacheDataStore==null || cacheDataStore.getData()==null || keyList == null || keyList.size() == 0)
            return null;

        Pair pair = null;
        if (cacheDataStore.getData().get(key) == null) {
            return null;
        } else {
            pair = new Pair(key, cacheDataStore.getData().get(key));
            keyList.remove(key);
            cacheDataStore.getData().remove(key);
        }
        return pair;
    }

}
