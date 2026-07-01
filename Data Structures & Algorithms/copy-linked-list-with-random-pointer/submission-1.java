/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //1.create map with oldnode to new node -- not implementing
        
        //2. add new nodes in between and then seperate
        if(head == null){
            return null;
        }
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        //allocate random pointers of new node in merged list
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            
            curr = curr.next.next;
        }

        //seperate lists
        curr = head;

        Node newHead = head.next;
        Node newCurr = newHead;
        while(curr != null){
            curr.next = newCurr.next;
            curr = curr.next;

            if(curr != null){
                newCurr.next = curr.next;
                newCurr = newCurr.next;
            }
            
        }

        return newHead;
       

    }
}
