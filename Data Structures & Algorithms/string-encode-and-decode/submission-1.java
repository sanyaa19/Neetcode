class Solution {

    public String encode(List<String> strs) {
        StringBuilder enc = new StringBuilder();

        for(String s: strs){
            enc.append(s.length());
            enc.append('#');
            enc.append(s);
        }

        return enc.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i=0;

        while(i<str.length()){
            String len = "";
            while(i<str.length() && str.charAt(i)!='#'){
                len = len + str.charAt(i);
                i++;
            }
            i++;

            int length = Integer.parseInt(len);

            if(length == 0){
                list.add("");
                continue;
            }

            StringBuilder s = new StringBuilder();
            int start = i;

            while(i<str.length() && i < start + length){
                s.append(str.charAt(i));
                i++;
            }
            
            list.add(s.toString());
        }

        return list;
    }
}
