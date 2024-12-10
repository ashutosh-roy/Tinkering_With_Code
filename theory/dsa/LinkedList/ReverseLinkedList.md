### Reverse LinkedList

**Algorithm for Iterative Approach** :-
* We need to make sure that the pointers pointing to next node in the given LinkedList point to the previous node.
* Once the pointer to next element points to the previous element, we move the nodes ahead (previous points to current Node & currentNode points to the nextNode). 

#### Source Code (for iterative approach) :-
```
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while(head!=null)
        {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
```
TC : O(N)  

We are doing things in one pass for 'n' elements in LinkedList.

SC : O(1). 

Constant because we are doing things in-place and not using extra space.

____
**Algorithm for Iterative Approach** :-
* 

#### Source Code (for recursive approach) :-
```
public ListNode reverseList(ListNode head) {
    if(head==null)
        return head;

}

```
____