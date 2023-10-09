package imemory.lru.datasource;

import java.util.Map;

public class Cache {

    private static Cache cache;
    final private int max_size;
    private Map<String, Object> data;

    private Cache(int max_size) {
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

    public static Cache createInstance(int max_size) {
        if (cache == null) {
            cache = new Cache(max_size);
        }
        return cache;
    }

}
