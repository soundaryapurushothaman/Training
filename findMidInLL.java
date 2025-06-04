class SinglyLinkedList{
    //class- Node
    static class Node{
        
        int data;//4 
        Node next;//12
        Node(int data){
            this.data=data;
        }
    }   
    //head 
    private Node head=null;
//insertAtBeg()
public void insertAtBeg(int data){//5
    Node newNode=new Node(data);
    newNode.next=head;
    head=newNode;
}

 //insertAtEnd()
public void  insertAtEnd(int data){
    Node newNode=new Node(data);
    Node temp=head;//4000
    while(temp.next!=null)
        temp=temp.next;//4000->3k->2k->1k
    temp.next=newNode;
}

public void findMid()
{
    Node fast=head;
    Node slow=head;
    while(fast.next!=null&&fast.next.next!=null)
    {
        fast=fast.next.next;
        slow=slow.next;
    }
    System.out.println(slow.data);
}

//display
public void display(){
        Node temp=head;//4000-
        while(temp!=null){
            System.out.print(temp.data +"->");
            temp=temp.next;
        }System.out.print("null");
    }
}

 public class Main{   
    public static void main(String[] args){
        SinglyLinkedList sl=new SinglyLinkedList();
       sl.insertAtBeg(5); //1000
       sl.insertAtBeg(6); //2000
       sl.insertAtBeg(7); //3000
       sl.insertAtBeg(8); //4000
       sl.insertAtEnd(9); //5000   
       sl.findMid();//6
       sl.display();//8->7->6->5->9->null      
       }
}
