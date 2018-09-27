package problem.day9;

public class Problem96 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    // see leetcode discussion
    /*
     * G(n): the number of unique BST for a sequence of length n.
       F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, and the sequence ranges from 1 to n.
       G(n) = F(1, n) + F(2, n) + ... + F(n, n).
       F(i, n) = G(i-1) * G(n-i)
     formula:  G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
     
       why? below:
     * Given a sequence 1…n, we pick a number i out of the sequence as the root,
     *  then the number of unique BST with the specified root F(i), is the cartesian product of the number of BST for its left and right subtrees. For example, F(3, 7):
     *   the number of unique BST tree with number 3 as its root. To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root, 
     *   which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and another BST out of the right subsequence [4, 5, 6, 7], 
     *   and then combine them together (i.e. cartesian product). The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2),
     *  and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4)
     */
}
