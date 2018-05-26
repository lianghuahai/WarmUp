import stack.Stack;
import llinkedList.LinkedList;

public class Test {

    public static void main(String[] args) {
        //LinkedList  
           /* LinkedList linkedList = new LinkedList();
            linkedList.insert(5);
            linkedList.insert(1);
            linkedList.insert(2);
            linkedList.insert(4);
            linkedList.insert(3);
            linkedList.insert(8);
            linkedList.insertAtStart(100);
            linkedList.delete(1);
            linkedList.display();*/
            
        // Stack 
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.display();
    }

}
