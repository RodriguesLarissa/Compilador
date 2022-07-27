import java.util.Scanner;
public class MainClass {
   public static void main(String args[]){
       Scanner scan = new Scanner(System.in);

      String  s;
      double  d;
      int  i;

      System.out.println("Quanto deveria ser a nota desse compilador? 0,00 a 10,00");
      i = 1;
      d = scan.nextDouble();
      while (d != 10.0) {
         if (d < 10.0) {
            System.out.println("Acho que deveria ser mais!");
         } else {
            System.out.println("Ai tambêm é muitoo... :)!");
         }
         d = scan.nextDouble();
         i = i + 1;
      }
      s = "Voce precisou de";
      System.out.println(s);
      System.out.println(i);
      if (i >= 1) {
         System.out.println("Tentativa");
      } else {
         System.out.println("Tentativas");
      }

      scan.close();
   }
}