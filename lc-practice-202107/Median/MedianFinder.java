class MedianFinder {
    ArrayList<Integer> list = new ArrayList();

    public MedianFinder() {}
   
    public void addNum(int num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }
        if (list.size() == 1) {
            if (list.get(0) > num) {
                list.add(0, num);
            } else {
                list.add(num);
            }
            return;
        }
        if (list.size() == 2) {
            if (list.get(1) > num) {
                list.add(1, num);
                if (list.get(0) > num) {
                    list.add(0, num);
                } else {
                    list.add(num);
                }
            } else {
                list.add(num);
            }    
            return;
        }
        if (list.size() == 3) {
            if (list.get(2) > num) {
                list.add(2, num);
                if (list.get(1) > num) {
                    list.add(1, num);
                    if (list.get(0) > num) {
                        list.add(0, num);
                    } else {
                        list.add(num);
                    }
                } else {
                    list.add(num);
                }
            } else {
                list.add(num);
            }
            return;
        }
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid + 1 >= list.size()) {
                break;
            }
            if (list.get(mid) < num) {
                start = mid + 1;
            } else if (list.get(mid) > num) {
                end = mid - 1;
            } else {
                break;
            }
        }
        list.add((start + end) / 2, num);
    }
   
    public double findMedian() {
        if (list.size() % 2 == 0) {
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;
        }
        return list.get(list.size() / 2);
    }

    public static void main(String[] args) {

        /**
         * Your MedianFinder object will be instantiated and called as such:
         * MedianFinder obj = new MedianFinder();
         * obj.addNum(num);
         * double param_2 = obj.findMedian();
         */
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.findMedian(); // return 2.0
        
    }
}

