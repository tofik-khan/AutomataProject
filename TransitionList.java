public class TransitionList
{
    Transition tran = new Transition();

    public void TransitionList()
    {
        //creating sentinel transition with garbage values. Helps keep track of list head
        tran.state1 = -1;
        tran.state2 = -1;
        tran.symbol = 'x';

    }

    public void addTransition(Transition t)
    {
        Transition curr = tran;
        while (curr.next != null)
        {
            curr = curr.next;
        }

        curr.next = t;
        t.next = null;


    }


    public int length()
    //returns the length of the transition list
    {
        Transition curr = tran;
        int count = 0;

        while (curr.next != null)
        {
            curr=curr.next;
            count++;
        }
        return count;
    }

    public void moveToEnd(Transition tran)
    {
        while(tran.next!=null)
        {
            tran = tran.next;
        }
    }
}
