class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int left=0;
        int right=matrix[0].length-1;

        int top=0;
        int bottom=matrix.length-1;

        while(top<=bottom){
            int midRow=(top+bottom)/2;

            if(matrix[midRow][left]>target) bottom=midRow-1;
            else if(matrix[midRow][right]<target) top=midRow+1;
            
            else{
                while(left<=right){
                    int midCol=(left+right)/2;

                    if(matrix[midRow][midCol]>target) right=midCol-1;
                    else if(matrix[midRow][midCol]<target) left=midCol+1;
                    else return true;

                }
            }
        }
        return false;
    }
}
