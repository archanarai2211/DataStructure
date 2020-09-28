import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class LFUCache {

    int capacity;
    int cnt = 0;

    HashMap<Integer, Integer> cache = new HashMap<>();
    HashMap<Integer, Integer> cacheCount = new HashMap<>();
    HashMap<Integer, List<Integer>> count = new HashMap<>();

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(cache.containsKey(key)){

            //System.out.println("fetching:"+key);
            updateCacheCount(key);
            return cache.get(key);
        }
        return -1;
    }

    public void updateCacheCount(int key) {
        if(cacheCount.containsKey(key)){
            Integer c = cacheCount.get(key);
            cacheCount.put(key, ++c);
            //  System.out.println("UpdatingCacheCount:"+key+"count:"+c);
            updateCount(c, key);
        }
    }
    public void updateCount(int c, int key) {
        List<Integer> countList;

        if(count.containsKey(c)){
            if(count.get(c)==null){
                countList = new ArrayList<>();
            }else{
                countList = count.get(c);
            }
            countList.add(key);
            count.put(c, countList);

        }else{
            countList = new ArrayList<>();
            countList.add(key);
            count.put(c, countList);
        }
        // System.out.println("Adding to:"+c+" key:"+key);
        if(c>1 && count.get(c-1)!=null){
            countList = count.get(c-1);
            // System.out.println("Removing from:"+(c-1)+" key:"+key);
            countList.remove(countList.indexOf(key));
            for(Integer o: countList){

                //   System.out.println("Dremain:"+o);
            }


            if(countList.isEmpty()){
                count.remove(c-1);
            }else{
                count.put(c-1, countList);
            }
        }
    }

    public void addCount(int key){
        List<Integer> countList;
        if(count.get(1)==null){
            countList = new ArrayList<>();
        }else{
            countList = count.get(1);
        }
        countList.add(key);
        count.put(1, countList);
    }

    public void deleteCount(){
        boolean deleted = false; int i =1;
        while(!deleted){
            if(count.get(i)!=null){
                List<Integer> countList = count.get(i);
                for(Integer o: countList){
                    //  System.out.println("Dfetch:"+o);
                }
                int r = countList.remove(0);
                if(countList.isEmpty()){
                    count.remove(1);
                }else{
                    count.put(1, countList);
                }
                //     System.out.println("Deleting:"+r);
                cacheCount.remove(r);
                cache.remove(r);
                deleted = true;
            }
            i++;
        }
    }



    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(cache.containsKey(key)){
            //    System.out.println("Updating:"+key);
            updateCacheCount(key);
        }else{
            if(cnt<capacity){
                //  System.out.println("creating:"+key);
                cacheCount.put(key, 1);
                addCount(key);
                cnt++;
            }else{
                //  System.out.println("Dcreating:"+key);
                deleteCount();
                cacheCount.put(key, 1);
                addCount(key);
            }
        }
        cache.put(key, value);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */