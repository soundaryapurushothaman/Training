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

public void deleteAtEnd()
{
    Node temp=head;
    while(temp.next.next!=null)
    {
        temp=temp.next;
    }
    temp.next=null;
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
    public void reverse(){
        Node prev=null;
        Node curr = head;
        Node temp;
        while(curr !=null){
            
            temp=curr.next;
            curr.next = prev;
            prev=curr;
            curr=temp;
        }
        head=prev;
    }

public void deleteAtBeg()
{
    head=head.next;
}

public void insertAtInd(int data,int index)
{
    Node newNode=new Node(data);
    Node temp=head;
    
    for(int i=1;i<index-1;i++)
    {
        temp=temp.next;
    }
    newNode.next=temp.next;
    temp.next=newNode;
    
}

public void deleteAtInd(int index)
{
    Node temp=head;
    
    for(int i=1;i<index-1;i++)
    {
        temp=temp.next;
    }
    temp.next=temp.next.next;
    
    
}

public void deleteAtKthNode(int k)
{
   int len = 0;
    Node temp=head;
    while (temp != null)
    {
    len++;
    temp = temp.next;
    }

    for (int i = len / k; i >= 1; i--)
    {
        deleteAtInd(i * k); 
    }

}
  //reversebygroup
    public static Node group(Node head, int k){
        Node curr = head;
        Node next = null;
        Node prev = null;
        int count=0;
        while(curr!=null && count<k){
        next = curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;
        count++;
    }
    if(next!=null){
        head.next=group(next,k);
        
    }
    return prev;
    }
     public void ReverseGroups(int n){
        head=group(head,n);
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
       sl.insertAtEnd(9); //5000   //8->7->6->5->9->null

     sl. ReverseGroups(3);
       sl.display();//8->6->9->null
       
       }
}
