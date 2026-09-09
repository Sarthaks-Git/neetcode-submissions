class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;

        Deque<Integer> deque=new ArrayDeque<>();
        int[] result =new int [n-k+1];

        for(int i=0;i<n;i++){
            while(deque.size() > 0 && deque.peekFirst() <= i-k) deque.pollFirst();

            while(deque.size() > 0 && nums[deque.peekLast()] < nums[i]) deque.pollLast();

            deque.offerLast(i);
            if(i >= k-1){
                result[i-k+1]=nums[deque.peekFirst()];
            } 
        }
        return result;
    }
}