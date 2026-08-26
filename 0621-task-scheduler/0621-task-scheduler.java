class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Har task ka frequency count nikalo
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // Frequencies ko Max-Heap mein daalo (Descending)
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0)
                pq.add(f);
        }

        int time = 0;

        // Process in rounds of (n + 1) slots
        while (!pq.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = n + 1; // windows size

    // Heap se max (n + 1) unique tasks nikal rahe hain
            while (count > 0 && !pq.isEmpty()) {
                int freqCurr = pq.poll();

                // Ek task execute ho gaya, agar currentFreq - 1 > 0 hai,
                if (freqCurr - 1 > 0) {
                    list.add(freqCurr - 1);
                }
                time++;
                count--;
            }
    // Executed tasks ki remaining frequencies ko waapas maxHeap mein daalo
            for (int remainingfreq : list) {
                pq.add(remainingfreq);
            }

// Agar heap khali NAHI hua, lekin cycle mein abhi bhi slots bache hain, jaise A->A->A h aur n = 2 h agr to ek bar loop chalega count 3 se 2 hoga to 2 idle lagenege
// toh matlab baaki slots IDLE the! Un slots ko totalTime mein add karo.
            if (!pq.isEmpty()) {
                time += count;
            }
        }
        return time;
    }
}
