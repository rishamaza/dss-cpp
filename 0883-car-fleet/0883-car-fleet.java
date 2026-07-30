class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Deque<Double> stack = new ArrayDeque<>();
        int n = position.length;
        double[][] cars = new double[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
/*
        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) / cars[i][1];
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }
        return stack.size();
*/
        
        int fleetCount = 0;
        double maxTime = 0;

        for (int i = 0; i < n; i++) {
            double time = (target - cars[i][0]) / cars[i][1];
            if (time > maxTime) {
                maxTime = time; // Current fleet ka leader yeh ho gaya
                fleetCount++; // Nayi fleet count badh gayi
            }
        }
        return fleetCount;
        
    }
}
