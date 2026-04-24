class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //Brute Force
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        ArrayList<Map.Entry<Integer, Integer>> list= new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());

        int[] result = new int[k];
        int i=0;
        
        for(Map.Entry<Integer, Integer> e : list){
            result[i] = e.getKey();
            i++;
            if(i==k){
                break;
            }
        }
        return result;
    }
}
