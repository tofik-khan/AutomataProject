import java.util.Stack;

public class MyStack
{
    Stack<Nfa> stack = new Stack<Nfa>();

    public Stack<Nfa> MyStack() {
        return stack;
    }

    public void printTest()
    {
        while(!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }

    public void push(Nfa c)
    {
        stack.push(c);
    }

    public Nfa pop()
    {
        return stack.pop();
    }
}
