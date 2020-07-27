package revision;

public class LL_gfg_implement_queue {
    QueueNode front, rear;
    void push(int a)
    {
        QueueNode node= new QueueNode(a);
        if(rear==null){
            front=node;
            rear=node;
        }
        else{
            rear.next=node;
            rear=node;
        }
    }

    // This function should remove front
    // item from queue and should return
    // the removed item.
    int pop()
    {
        if(front==null)
            return -1;
        QueueNode node=front;
        front=front.next;
        if(front==null)
            rear=null;
        return node.data;
    }

    class QueueNode
    {
        int data;
        QueueNode next;
        QueueNode(int a)
        {
            data = a;
            next = null;
        }
    }
}
