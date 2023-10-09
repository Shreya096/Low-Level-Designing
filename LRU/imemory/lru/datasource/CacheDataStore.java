package imemory.lru.datasource;

import java.util.Map;

public class CacheDataStore {

    private static CacheDataStore cacheDataStore;
    final private int max_size;
    private Map<String, Object> data;

    private CacheDataStore(int max_size) {
        this.max_size = max_size;
    }

    public int getMax_size() {
        return max_size;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public static CacheDataStore createInstance(int max_size) {
        if (cacheDataStore == null) {
            cacheDataStore = new CacheDataStore(max_size);
        }
        return cacheDataStore;
    }

}
