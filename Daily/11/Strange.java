class Strange {
    int ele[], capacity, top;
    Strange(int cap) {
        ele = new int[capacity = cap < 21 ? cap : 20];
        top = -1;
    }
    void pushItem(int value) {
        if (top != capacity - 1) ele[++top] = value;
        else System.out.println("Strange is full.");
    }
    int popItem() {
        if(top == -1) {
            System.out.println("Strange is empty. Returning -9999");
            return -9999;
        }
        return ele[top--];
    }
    static void main() {
        Strange s = new Strange(2);
        int x = s.popItem();
    }
}