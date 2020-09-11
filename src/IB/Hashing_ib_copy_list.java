package IB;
//https://www.interviewbit.com/problems/copy-list/
public class Hashing_ib_copy_list {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead=generateLLwithNextPointers(head);
        generateLLwithRandomPointers(newHead);
        return newHead;
    }

    public RandomListNode generateLLwithNextPointers(RandomListNode node){
        if(node==null) return null;
        RandomListNode newNode=new RandomListNode(node.label);
        newNode.next=generateLLwithNextPointers(node.next);
        node.next=newNode;
        newNode.random=node.random;
        return newNode;
    }

    public void generateLLwithRandomPointers(RandomListNode newNode){
        if(newNode==null) return ;
        if(newNode.random!=null)
            newNode.random=newNode.random.next;
        generateLLwithRandomPointers(newNode.next);
    }

     class RandomListNode {
          int label;
          RandomListNode next, random;
          RandomListNode(int x) { this.label = x; }
     }
}