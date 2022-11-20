import java.util.Scanner;

class day2date {
  static void die(String msg) {
    System.out.println(msg);
    System.exit(0);
  }

  public static void main(String args[]) {
    int day, year, offset;
    String month[] = {
      "January",
      "February",
      "March",
      "April",
      "May",
      "June",
      "July",
      "August",
      "September",
      "October",
      "November",
      "December"
    };
    int monthmap[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    Scanner s = new Scanner(System.in);
    System.out.print("[day number]: ");
    day = s.nextInt();
    if (day < 1 || day > 366) die("Invalid day count.");
    System.out.print("[year]: ");
    year = s.nextInt();
    boolean leap = year % 4 == 0;
    if (day == 366 && !leap) die("Invalid year.");
    System.out.print("[date after (N)]: ");
    offset = s.nextInt();
    if (offset < 1 || offset > 100) die("Invalid offset.");
    year += (day += offset) / (365 + (leap ? 1 : 0));
    day %= 365 + (leap ? 1 : 0);
    int i;
    for (i = 0; day > 31; i++) day -= monthmap[i] + ((leap && i == 1) ? 1 : 0);
    System.out.printf("date after %d days: %s %d, %04d\n", offset, month[i], --day, year);
    /* On that day thus, --day, otherwise goes off by one and onto the next day */
  }
}
