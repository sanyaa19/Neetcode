class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            if(n%2==1) count++; 
            n/=2;
        }

        return count;       //O(32) since lenfth if integer is always 32 bits
    }
}
