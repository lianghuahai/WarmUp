package llinkedList;

public class LinkedList {
    public Node head;
    
    public void insert(int data){
        Node node = new Node();
        node.setData(data);
        node.setNext(null);
        if(this.head==null){
            this.head = node;
        }else{
            Node ref = this.head;
            int count =0;
            while(ref.getNext()!=null){
                ref = ref.getNext();
                count++;
                if(count>=5){
                    break;
                }
            }
            
            ref.setNext(node);
        }
    }
    public void display(){
        Node ref =  this.head;
        while(ref.getNext()!=null){
            System.out.println(ref.getData());
            ref= ref.getNext();
        }
        System.out.println(ref.getData());
    }
    public void insertAtStart(int data){
        Node node = new Node();
        node.setData(data);
        node.setNext(this.head);
        this.head = node;
    }
    public void delete(int index){
        if(index==0){
            this.head=head.getNext();
        }else{
            Node n = this.head;
            Node nextNode = null;
            for (int i = 0; i < index-1; i++) {
                n=n.getNext();
            }
            nextNode= n.getNext();
            n.setNext(nextNode.getNext());
            nextNode=null;
        }
        
    }
    
    
    
    
    
    
    
    
    
}
