class Repeat {
    int str[], cap, f, r;
    Repeat(int m) {
        str = new int[cap = m>100?100:m];
        f = 0;
        r = 0;
    }
    void pushvalue(int v){
        if ( r == cap ) System.out.println("OVERFLOW");
        else str[r++] = v;
    }
    int popvalue(){
        return f == r ? -9999 : str[f++];
    }
    void disp() {
        for(int x = f; x < r; x++) System.out.println(str[x]);
    }
    public static void main(){
        Repeat r = new Repeat(3);
        System.out.println(r.popvalue()); /* should return -9999 */
        r.pushvalue(1337);
        r.pushvalue(31337);
        r.pushvalue(7047);
        r.pushvalue(60); /* should err */
        r.disp();
        System.out.println(r.popvalue());
        System.out.println(r.popvalue());
        System.out.println(r.popvalue());
        System.out.println(r.popvalue()); /* should return -9999 */
    }
}