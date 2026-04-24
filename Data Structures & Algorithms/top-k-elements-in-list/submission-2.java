class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        ArrayList<ArrayList<Integer>> table = new ArrayList<>();
        
        for(int i=0; i<nums.length+1; i++){
            table.add(new ArrayList<>());
        }

        for(Integer i : map.keySet() ){
            table.get(map.get(i)).add(i);
        }

        int[] result = new int[k];
        int count=0;
        
        for(int i=table.size()-1; i>=0 && count<k; i--){
            for(int num: table.get(i)){
                result[count++]=num;
                if(count==k) break;
            }
        }

        return result;
    }
}
