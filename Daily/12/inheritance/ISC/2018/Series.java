class Series extends Number {
    int sum;
    Series(int nn) {
        super(nn);
    }
    public void calsum() {
        for(;n!=0;sum += factorial(n--));
    }
    public void display() {
        super.display();
        System.out.printf("sum = %d\n", sum);
    }
}
