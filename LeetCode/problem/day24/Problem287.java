package problem.day24;

public class Problem287 {
    public static void main(String[] args) {
        findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1});
    }
    public static int findDuplicate(int[] nums) {
        // why we need the second while loop. because first loop only find the cycle,but not really duplicated number
        //eg: {2,5,9,6,9,3,8,9,7,1}  => found 7 which is not duplicated number;
        
        // Find the intersection point of the two runners.
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

//         Find the "entrance" to the cycle.
         int ptr1 = nums[0];
         int ptr2 = tortoise;
         while (ptr1 != ptr2) {
             ptr1 = nums[ptr1];
             ptr2 = nums[ptr2];
         }

        return ptr2;
    }
}
