class Solution {
    public int reverseBits(int n) {
        int num=n;
        int reverse=0;

        for(int i=0; i<32; i++){
            int bitMask = 1<<i;
            if((n & bitMask) != 0){
                bitMask = 1<<31-i;
                reverse |= bitMask;
            }
        }
        return reverse;
    }
}
