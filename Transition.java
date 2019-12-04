public class Transition {
    int state1;
    int state2;
    char symbol;
    Transition next = null;

    //TO-DO: Implement a list of transitions

    public void setTransition(int s1, int s2, char s)
    //sets the values of the current transition to arguments
    {
        state1 = s1;
        state2 = s2;
        symbol = s;
    }

    public void printTransition()
    {
        System.out.println(String.format("(q%d , %c) -> q%d", state1, symbol, state2));
    }


}
