class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        double [][] pos = new double[position.length][2];
        
        for(int i=0; i<position.length; i++){
            pos[i][0]=position[i];
            pos[i][1]= (double)(target - position[i]) / (double)speed[i];
        }

        Arrays.sort(pos , (a, b) -> (int)b[0] - (int)a[0]);     //Integer.compare(b[0],a[0]) for descending and Integer.compare(a[0], b[0]) for ascending

        int count=0;

        for(double[] row : pos){
            if(!stack.isEmpty() && row[1]<=stack.peek()) continue;
            else stack.push(row[1]);
        }

        while(!stack.isEmpty()){
            count++;
            stack.pop();
        }

        return count;
    }
}
