class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        // Max heap for smaller half
        small = new PriorityQueue<>((a, b) -> b - a);

        // Min heap for larger half
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {

        small.offer(num);

        // Make sure small's largest element
        // is not greater than large's smallest element
        if (!large.isEmpty() && small.peek() > large.peek()) {
            large.offer(small.poll());
        }

        // Keep both heaps balanced
        if (small.size() > large.size() + 1) {
            large.offer(small.poll());
        } else if (large.size() > small.size()) {
            small.offer(large.poll());
        }
    }

    public double findMedian() {

        if (small.size() > large.size()) {
            return small.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */