import java.io.File;
import java.rmi.server.ExportException;
import java.util.Scanner;

public class Main {

    public static void main (String[] args)
    {
        //String filename = "Test.txt";
        try
        {
        
        	Scanner input = new Scanner(System.in);
        	String filename = args[0];
        	

            File myFile = new File(filename);
            Scanner line = new Scanner(myFile);

            //TO-DO: Initialize an empty stack
            MyStack myStack = new MyStack();
            int available = 1;

            while (line.hasNextLine()) {
                //TO-DO: store post fix regular expression
                String regEx = line.nextLine();
                //TO-DO: Read regEx
                for(int i = 0; i<regEx.length(); i++)
                {
                    char current = regEx.charAt(i);
                    switch (current)
                    {
                        case '|':
                            //TODO: update to perform union on two NFAs
                            Nfa n1 = myStack.pop();
                            Nfa n2 = myStack.pop();

                            n2.union(n1);

                            myStack.push(n2);

                            break;
                        case '*':
                            //TODO: update to perform Kleene start operator
                            Nfa n = myStack.pop();
                            n.star();

                            myStack.push(n);

                            break;
                        case '&':
                            //TO-DO: update to perform concatenation
                            Nfa nfa1 = myStack.pop();
                            Nfa nfa2 = myStack.pop();

                            nfa2.concat(nfa1);
                            myStack.push(nfa2);
                            break;
                        default:
                            //TO-DO: Create an NFA that accepts a single character

                            Nfa charNfa = new Nfa(available,available+1);
                            charNfa.list = new TransitionList();

                            Transition tran = new Transition();
                            tran.setTransition(available,available+1,current);

                            charNfa.list.addTransition(tran);


                            myStack.push(charNfa);
                            
                            
                    }

                }


                //myStack.printTest();

                Nfa nfa = myStack.pop();
                if (myStack.stack.isEmpty() == false)
                {
                	System.out.println("Incorrect Expression in file. Check expressions again.");
                }
                nfa.printNFA();

                System.out.println();


            }



            line.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }


    }
}


