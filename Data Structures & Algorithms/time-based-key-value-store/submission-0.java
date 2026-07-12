class TimeMap {
    private Map<String,TreeMap<Integer,String>> m;

    public TimeMap() {
        m = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {

        //1.USing map of Map
        m.computeIfAbsent(key, k->new TreeMap<>()).put(timestamp,value);
        
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key)){
            return "";
        }

        TreeMap<Integer,String> timestampedValues = m.get(key);
        Map.Entry<Integer,String> entry = timestampedValues.floorEntry(timestamp);
        return entry == null ? "":entry.getValue();

        
    }
}
