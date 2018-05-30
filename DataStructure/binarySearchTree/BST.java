package binarySearchTree;

public class BST {
    private Node root;
    public Node getRoot() {
        return root;
    }
    public void setRoot(Node root) {
        this.root = root;
    }
    
    // iteration  of insert
    public void insert(int toInsert){
        if(root==null){
            root = new Node(toInsert);
        }
        else{
            Node position = root;
            while(position!=null){
                if(position.getData()-toInsert<0){
                    if(position.getRight()==null){
                        position.setRight(new Node(toInsert));
                        break;
                    }
                    position = position.getRight();
                }else if(position.getData()-toInsert>0){
                    if(position.getLeft()==null){
                        position.setLeft(new Node(toInsert));
                        break;
                    }
                    position = position.getLeft();
                }else{
                    break;
                }
            }
        }
    }
    
    
    // recursion  of insert
    public void insertUsingRecusion(int toInsert){
        
    }
    
    
    
    
    //display tree     In order
    public <T> void displayInOrder(){
        Node node = this.root;
        Stack<T> stack = new Stack<T>();
        while(stack.getStack().size()!=0 || node!=null){
            while(node!=null){
                stack.push((T) node);
                node = node.getLeft();
            }
             Node pop = (Node)(stack.pop());
            System.out.println(pop.getData());
            node = pop.getRight();
        }
    }
    
  //display tree     Post order
    public <T> void displayPostOrder(){
        Node node = this.root;
        Stack<T> stack = new Stack<T>();
        while(stack.getStack().size()!=0 || node!=null){
            while(node!=null){
                stack.push((T) node);
                node = node.getLeft();
            }
            Node pop = (Node)(stack.pop());
            System.out.println(pop.getData());
            node = pop.getRight();
        }
    }
    //display tree     Pre order
    public <T> void displayPreOrder(){
        Node node = this.root;
        Stack<T> stack = new Stack<T>();
        while(stack.getStack().size()!=0 || node!=null){
            while(node!=null){
                stack.push((T) node);
                node = node.getLeft();
            }
            Node pop = (Node)(stack.pop());
            System.out.println(pop.getData());
            node = pop.getRight();
        }
    }
    
    
    
    
    
    
}
