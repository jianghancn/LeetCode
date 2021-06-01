import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
 *
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 *
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 *
 */


class MedianFinder {

    /**
     * initialize your data structure here.
     */

    PriorityQueue<Integer> maxH;
    PriorityQueue<Integer> minH;

    public MedianFinder() {
        minH = new PriorityQueue<>(1000);
        maxH = new PriorityQueue<>(1000, (a, b) -> (b - a));
    }

    public void addNum(int num) {

        if (minH.size() == 0 && maxH.size() == 0) {
            minH.add(num);
            return;
        }


        int minTop = minH.peek();

        if (minTop <= num) {
            minH.add(num);
        } else {
            maxH.add(num);
        }


        if (minH.size() > maxH.size() + 1) {
            int temp = minH.poll();
            maxH.add(temp);
        } else if (minH.size() < maxH.size()) {
            int temp = maxH.poll();
            minH.add(temp);
        }


    }

    public double findMedian() {
        if (minH.size() == maxH.size()) {
            return (minH.peek() + maxH.peek()) / 2.0;
        } else {
            return minH.peek();
        }

    }

}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */