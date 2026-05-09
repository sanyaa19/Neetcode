class Solution {
    public String multiply(String num1, String num2) {
        // if(Integer.parseInt(num1)==0 || Integer.parseInt(num2)==0) return "0";
        
        int[] prod = new int[num1.length() + num2.length()];

        for(int i=num1.length() - 1; i>=0; i--){
            int n = prod.length-1 - (num1.length() - 1 - i);
            for(int j= num2.length()-1; j>=0; j--){
                    int b = num1.charAt(i) - '0';
                    int a = num2.charAt(j) - '0';

                    int product = b*a;
                    prod[n] += product;

                    if(prod[n]>9){
                        prod[n-1] += prod[n]/10;
                        prod[n] = prod[n] % 10;
                    }

                    n--;
            }
            while(prod[n]>9){
                prod[n-1] += prod[n]/10;
                prod[n] = prod[n] % 10;
                n--;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean leadZero = true;

        for(int i=0; i<prod.length; i++){
            if(prod[i]==0 && leadZero) continue;
            if(prod[i]!=0 && leadZero) leadZero = false;
            sb.append(prod[i]);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
