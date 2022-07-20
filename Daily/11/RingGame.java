class RingGame {
    int ring[], max, upper;
    RingGame(int m) {
        ring = new int[max = m < 11 ? m : 10];
        upper = -1;
    }
    void jump_in(int x) {
        if (upper == max - 1) System.out.println("Column is full. Start removing rings");
        else ring[++upper] = x;
    }
    void jump_out() {
        if(upper != -1) upper--;
        else System.out.print("Congratulations. The game is over");
    }
    public static void main(String args[]) {
        RingGame game = new RingGame(12); /* Should be truncated to max of 10 */
        game.jump_in(0x50);
        game.jump_in(0x72);
        game.jump_in(0x65);
        game.jump_in(0x65);
        game.jump_in(0x74);
        game.jump_in(0x69);
        for(int x = 0; x < 7; x++) game.jump_out();
    }
}