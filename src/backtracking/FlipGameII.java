//294. Flip Game II
 // T(n!!)  S(n!!)
    // 有冗余的case， 可以用map来cache一下
    //https://discuss.leetcode.com/topic/27351/java-backtracking-solution-with-time-optimization-through-dp-205ms-19ms
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
         Map<String, Boolean> winMap = new HashMap<String, Boolean>();
        return helper(s, winMap);
    }
    
    private boolean helper(String s, Map<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(t, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
