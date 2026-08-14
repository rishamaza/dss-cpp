class TimeMap {
    
    private class Pair {
        int t;
        String val;

        Pair (int t, String val) {
            this.t = t;
            this.val = val;
        }
    }

    private Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }
        List<Pair> list = map.get(key);
        String res = "";
        int low = 0, high = list.size() -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(list.get(mid).t <= timestamp) {
                res = list.get(mid).val;
                low = mid + 1;
            }
            else {
                high = mid -1 ;
            }
        }
        return res;
    }
}
