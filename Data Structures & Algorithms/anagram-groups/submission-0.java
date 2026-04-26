class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,Integer> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        
        for(String s: strs){

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String st = new String(arr); //coverts character array to string

            if(map.containsKey(st)){
                int idx=map.get(st);
                list.get(idx).add(s);
            }

            else{
                list.add(new ArrayList<>());
                int idx=list.size()-1;
                list.get(idx).add(s);
                map.put(st,idx);
            }
        }
        
        return list;
    }
}
