import java.util.Scanner;
class PrintJob {
    int job[], Newjob, Capacity, Front, Rear;
    PrintJob(){
        Front = Rear = -1;
        createJob();
    }
    void createJob(){
        job = new int[Capacity = 20];
    }
    void addJob(){
        Scanner s = new Scanner(System.in);
        if ( Rear == Capacity - 1 ) System.out.println("PrintJob is full, cannot add any more.");
        else job[++Rear] = s.nextInt();
    }
    void removeJob() {
        System.out.println("Printjob " + (Front == Rear ? "is empty." : (job[++Front] + " removed.")));
    }
    public static void main(String args[]){
        PrintJob p = new PrintJob();
        p.removeJob(); //err
        for(int x = 0; x < 20; x++)
            p.addJob();
        p.addJob(); //err
        for(int x = 0; x < 20; x++)
            p.removeJob();
        p.removeJob(); //err
    }    
}