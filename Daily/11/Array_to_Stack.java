import java.util.Scanner;
class Array_to_Stack {
    int m[], st[], cap, top;
    Array_to_Stack(int n) {
        n = n > 50 ? 50: n; /* Truncate the number because users should be smart enough to read my code lol */
        st = new int[cap = n];
        m = new int[cap = n];
        top = -1;
    }
    void input_marks(){
        Scanner s = new Scanner(System.in);
        for(int x = 0; x < cap; ++x) {
            int input = s.nextInt(), brk = cap - 1;
            for(; brk > -1 && m[brk] > input; --brk); /* Search for value less than input, halt there */
            for(int i = 0; i < brk; m[i] = m[++i]); /* Shift one index left till the halting point */
            m[brk] = input; /* Insert value into the halting point */
            pushmarks(input);
        }
    }
    void pushmarks(int v) {
        if(top == cap - 1) System.out.println("not possible");
        else st[++top] = v;
    }
    int popmarks() {return top==cap-1?st[top--]:-999;}
    void display(){for(int x=0;x<cap;x++) System.out.println(st[x]);}
    void meh() {for(int x = 0;x<cap; x++) System.out.println(m[x]);} /* Proof of concept for the inplace ascending sort */
}