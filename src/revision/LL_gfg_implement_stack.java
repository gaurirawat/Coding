package revision;
//https://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
public class LL_gfg_implement_stack {
    StackNode top;

    void push(int a) {
        StackNode node= new StackNode(a);
        if(top==null)
            top=node;
        else{
            node.next=top;
            top=node;
        }
    }
    int pop() {
        if(top==null) return -1;
        StackNode node=top;
        top=top.next;
        return node.data;
    }
    class StackNode
    {
        int data;
        StackNode next;
        StackNode(int a)
        {
            data = a;
            next = null;
        }
    }
}
