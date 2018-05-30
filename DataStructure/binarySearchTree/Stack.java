package binarySearchTree;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author admin
 *   Implement stack  using Array List
 * @param <T>
 */
public class Stack<T> {
    private List<T> stack = new ArrayList<T>();
    private int top=0;
    public List<T> getStack() {
        return stack;
    }
    public void setStack(List<T> stack) {
        this.stack = stack;
    }
    public int getTop() {
        return top;
    }
    public void setTop(int top) {
        this.top = top;
    }
    public void push(T number){
        stack.add(number);
        top++;
    }
    public T pop(){
        T x=(T) stack.remove(top-1);
        top--;
        return x;
    }
    public void display(){
        for (T integer : stack) {
            System.out.println(integer);
        }
    }
}
