package problem.day22;

public class Problem189 {
    /* 1.time O(n) + space O(n)   create a new array to store the nums
     * 2.time O(n) + space O(1)   using a temp variable to keep the previous value and keep shifting 
     *         eg:  1 2 3 4 5 6  k=2     1) i=0   swap 1 and 3 =>  1 2 1 4 5 6, prev=3 and next is to shift prev with 5, 
 *                                                     =>     1 2 1 4 3 6    prev=5  and next is to shift prev with 1,    
 *                                                     =>     5 2 1 4 3 6    end it
 *                                          i=1        =>     5 2 1 2 3 6 prev=4                                                                    
                                                       =>     5 2 1 2 3 4 prev=6 
     *                                                 =>     5 6 1 2 3 4 prev=6  end it
     *            we have to have a counter++ keep tracking how many numbers we traveled when counter ==array.length, done!
     */
}
