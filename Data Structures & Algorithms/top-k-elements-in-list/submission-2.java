class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Using hashmap and then ordering it based on freq/value
        //int[] res = new int[k];
        //Map<Integer,Integer> count = new HashMap<>();
        //for(int i : nums){
            //count.put(i,count.getOrDefault(i,0)+1);
        //}

        //Map<Integer,Integer> orderedCount = new LinkedHashMap<>();
        //count.entrySet().stream()
        //.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        //.forEach(e -> orderedCount.put(e.getKey(),e.getValue()));

        //int counter = 0;
        //for(int j : orderedCount.keySet()){
            //res[counter] =  j;
            //counter++;
            //if(counter==k){
                //break;
            //}      
         //}

        //return res;

        //MinHeap
        //int[] res = new int[k];
        //Map<Integer,Integer> count = new HashMap<>();
        //for(int i : nums){
            //count.put(i,count.getOrDefault(i,0)+1);
        //}

        //Queue<Integer> pQueue = new PriorityQueue<>((a,b) -> count.get(a)-count.get(b));

        //for(int j : count.keySet()){
            //pQueue.add(j);
            //if(pQueue.size()>k){
                //pQueue.poll();
            //}
        //}

        //while(k>0){
            //res[k-1]=pQueue.poll();
            //k--;
        //}

        //return res;


        //Bucket Sort
        int[] res = new int[k];
        Map<Integer,Integer> count = new HashMap<>();
        for(int i : nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }

        List<Integer>[] bucketArr = new List[nums.length+1];
        for(int i = 0; i< bucketArr.length;i++){
            bucketArr[i] = new ArrayList<>();
        }

        for(int p : count.keySet()){
            bucketArr[count.get(p)].add(p);
        }

        int counter = 0;
        for(int i = bucketArr.length-1; i>=0;i--){
            List<Integer> l = bucketArr[i];
            for(int j : l){
                res[counter] = j;
                counter++;
                if(counter==k){
                    return res;
                }
            }
        }

        return res;
  
    }
}
