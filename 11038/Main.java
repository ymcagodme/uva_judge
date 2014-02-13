import java.util.Scanner;

class Main {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      while (sc.hasNext()) {
         long a = sc.nextLong();
         long b = sc.nextLong();
         if (a < 0 || b < 0)
            System.exit(0);

         long result = countZero(Math.max(a, b)) - countZero(Math.min(a, b) - 1);
         if (Math.min(a, b) == 0)
            result++;
         System.out.println(result);
      }
   }

   public static long countZero(long num) {
      long numCopy = num;
      long count = 0L;
      long left;
      long mid;
      long right;
      int power = 0;
      left = mid = right = 0;

      while (num >= 10) {
         mid = num % 10;
         left = (num /= 10);
         right = numCopy % (long) Math.pow(10, power);
         if (mid > 0)
            count += left * Math.pow(10, power);
         else
            count += (left - 1) * Math.pow(10, power) + (right + 1);
         power++;
      }

      return count;
   }
}
