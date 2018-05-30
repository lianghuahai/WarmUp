package binarySearchTree;

public class Main {

    public static void main(String[] args) {
//        Stack stack = new Stack();
//        stack.push(14);
//        stack.push(13);
//        stack.push(12);
//        stack.push(11);
//        stack.pop();
//        stack.display();
        BST bst = new BST();
        //11, 6, 8, 19, 4, 10, 5, 17, 43, 49, 31  test
        bst.insert(11);
        bst.insert(6);
        bst.insert(8);
        bst.insert(19);
        bst.insert(4);
        bst.insert(10);
        bst.insert(5);
        bst.insert(17);
        bst.insert(43);
        bst.insert(49);
        bst.insert(31);
        bst.displayInOrder();
        
    }

}
