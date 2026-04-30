class Solution {
    public int hammingWeight(int n) {
        // int count=0;
        // while(n!=0){
        //     if(n%2==1) count++; 
        //     n/=2;
        // }

        // return count;       //O(32) = O(1) since length if integer is always 32 bits

        int count = 0;

        while(n != 0){
            n &= (n-1);   // n=111  n-1=110  n&(n-1) = 110 count=1 
            count++;      // n=110  n-1=101  n&(n-1) = 100 count=2
        }                 // n=100  n-1=011  n&(n-1) = 000 count=3
        return count;
    }
}
