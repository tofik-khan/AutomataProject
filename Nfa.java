public class Nfa {
    int start;
    int end;
    TransitionList list;

    public Nfa(int startin, int endin)
    {
        start = startin;
        end = endin;


    }


    public void printNFA()
    {
        Transition curr = list.tran.next;
        while (curr != null)
        {
            if(curr.state1 == start)
            {
                System.out.println(String.format("S(q%d, %c) -> q%d", curr.state1, curr.symbol, curr.state2));
            }
            else if (curr.state2 == end)
            {
                System.out.println(String.format("F(q%d, %c) -> q%d", curr.state1, curr.symbol, curr.state2));
            }
            else
            {
                curr.printTransition();
            }

            curr = curr.next;
        }
    }

    public void union (Nfa nfa)
    {
        //TO-DO: Create a union function for two nfas

        //creating new start state
        Transition startNfa1 = new Transition();
        int available = this.list.length() + 2; //available state number

        startNfa1.setTransition(available, this.list.tran.next.state1, 'E');
        this.start = available;
        available++;
        startNfa1.next = this.list.tran.next;

        this.list.addTransition(startNfa1);

        Transition startNfa2 = new Transition();

        nfa.list.tran.next.state1 = available++;
        nfa.list.tran.next.state2 = available++;
        startNfa2.setTransition(startNfa1.state1, nfa.list.tran.next.state1, 'E');
        this.list.addTransition(startNfa2);
        //System.out.println(nfa.list.tran.next.symbol);
        this.list.addTransition(nfa.list.tran.next);

        //updating state names
        while (nfa.list.tran.next != null)
        {
            //System.out.println(available);
            nfa.list.tran.state1 = available++;
            nfa.list.tran.state2 = available++;
            this.list.addTransition(nfa.list.tran);



            startNfa2 = startNfa2.next;


        }

        this.list.addTransition(startNfa2); //adding last transition



        Transition endTransition1 = new Transition();
        endTransition1.setTransition(startNfa1.state2+1, available, 'E');
        Transition endTransition2 = new Transition();
        endTransition2.setTransition(startNfa2.state2, available, 'E');

        this.list.addTransition(endTransition1);
        this.list.addTransition(endTransition2);

        this.end = available;



    }

    public void concat(Nfa nfa)
    {
        Transition eTran = new Transition();
        eTran.state1 = end;
        eTran.state2 = nfa.start;
        eTran.symbol = 'E';
        Transition curr = list.tran;

        while (curr.next != null)
        {
            curr = curr.next;
            //System.out.println("yo");
        }
        //curr is now the last transition
        curr.next = eTran;
        eTran.next = nfa.list.tran.next;

        //Renaming states
        curr = list.tran;
        int one = -100;
        boolean flag = false;
        while (curr != null)
        {
            if(flag)
            {
                curr.state1 = one-1;
                curr.state2 = one;
                one++;

            }
            else
            {
                if (curr.symbol == 'E')
                {
                    flag = true;
                    curr.state2 = curr.state1+1;
                    one = curr.state2+1;
                }
            }
            curr = curr.next;


        }

        //Changing final state;
        curr = list.tran;
        while (curr.next != null)
        {
            curr = curr.next;
        }

        end = curr.state2;

        //curr.printTransition();
        //eTran.setTransition();
    }

    public void star()
    {
        Transition newStart = new Transition();
        int available = this.list.length() + 1;

        newStart.setTransition(available+1,this.list.tran.next.state1, 'E');
        newStart.next=this.list.tran.next;
        this.list.addTransition(newStart);

        this.end = this.list.tran.next.state1;
    }

    public void testUnion(Nfa nfa)
    {
        Transition head = new Transition();
        int headState1 =  this.list.length();
        head.setTransition(headState1, this.list.tran.next.state1, 'E');

        head.next = this.list.tran.next;
        this.list.tran = head;

        Transition endOfNFA1 = this.list.tran;

        while(endOfNFA1.next != null)
        {
            endOfNFA1 = endOfNFA1.next;
        }

        Transition endNfa1 = new Transition();
        endNfa1.setTransition(endOfNFA1.state2, headState1+2, 'E');
        endOfNFA1.next = endNfa1;

        Transition head2 = new Transition();
        head2.setTransition(headState1, nfa.list.tran.next.state1, 'E');
        head2.next = nfa.list.tran.next;


        Transition endOfNFA2 = this.list.tran;
        while(endOfNFA2.next != null)
        {
            endOfNFA2 = endOfNFA2.next;
        }

        Transition endNfa2 = new Transition();
        System.out.println(endOfNFA2.state2);
        endNfa2.setTransition(endOfNFA2.state2, headState1+2, 'E');

        //renaming states
        Transition curr = nfa.list.tran.next;
        Transition headOfNfa2 = nfa.list.tran.next;

        headState1 = headState1 +3;
        while (curr != null)
        {
            curr.state1 = headState1++;
            curr.state2 = headState1++;

            curr = curr.next;
        }
        endOfNFA2.next = endNfa2;

        endNfa1.next = head2;


    }

}
