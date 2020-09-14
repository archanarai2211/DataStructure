public class HashTable<X,Y> {
    private HashEntry[] data;
    private int capacity;
    private int size;

    public HashTable( int capacity) {
        this.capacity = capacity;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Y get(X key){
        int hash = calculateHash(key);
        if(data[hash] == null){
            return null;
        }else{
            return (Y)data[hash].getValue();
        }
    }

    public void put(X key, Y val){
        int hash = calculateHash(key);
        data[hash]=new HashEntry<X,Y>(key, val);
        size++;
    }


    public Y delete(X key){
        //remove item
       Y value = get(key);
       if(value != null){
           int hash = calculateHash(key);
           data[hash] = null;
           size--;

           //rearrange hash slot incase of data collision
           hash = (hash+1)%capacity;
           while(data[hash]!= null){
                HashEntry he = data[hash];
                data[hash]=null;
                put((X)he.getKey(), (Y)he.getValue());
                size--;
                hash = (hash+1)%capacity;
           }
       }
       return value;

    }

    public boolean hasKey(X key){
        int hash = calculateHash(key);
        return data[hash].getKey() != null;
    }

    public boolean hasValue(Y value){
        for(int i = 0; i< capacity;i++){
            HashEntry he = data[i];
            if(he.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }

    private int calculateHash(X key){
        //get hash slot
        int hash = key.hashCode() % capacity;
        while(data[hash] != null && !data[hash].getKey().equals(key)){
            hash = (hash+1)%capacity;
        }
        return hash;
    }
    private class HashEntry<X,Y>{
        X key;
        Y val;

        public HashEntry(X key, Y val) {
            this.key = key;
            this.val = val;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return val;
        }

        public void setValue(Y val) {
            this.val = val;
        }
    }
}
