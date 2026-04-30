class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        for(int i=0; i<=n; i++){
            int count=0;
            int num=i;
            while(num!=0){
                count += (num % 2);     //if last digit is 1 then that's added to count else 0 will be added
                num /= 2; 
            }
            res[i]=count;
        }
        return res;
    }
}
