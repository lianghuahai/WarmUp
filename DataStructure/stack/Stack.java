package stack;

public class Stack {
    public int []stack = new int[5];
    public int top = 0;
    public void push(int data){
        stack[top]=data;
        this.top++;
    }
    public int pop(){
        int data = stack[top-1];
        stack[top-1]=-1;
        this.top--;
        return data;
    }
    public int peek(){
        return stack[top-1];
    }
    
    public void display (){
        for (int i : stack) {
            System.out.println(i);
        }
    }
}
