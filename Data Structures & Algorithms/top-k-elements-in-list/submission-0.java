class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        List<Integer>[] bucket =new ArrayList[nums.length + 1];

        for(int x:map.keySet()){
            int frequency=map.get(x);

            if(bucket[frequency] == null) 
                bucket[frequency] =new ArrayList<>();
            
            bucket[frequency].add(x);
        }

        int[] result=new int [k];
        int index=0;

        for(int frequency=nums.length;frequency>=1;frequency--){
            if(bucket[frequency]!=null){
                for(int num:bucket[frequency]){
                    result[index++]=num;
                    if(index==k) return result;
                }
            }
        }
        return result;
    }
}
