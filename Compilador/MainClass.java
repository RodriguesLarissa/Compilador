import java.util.Scanner;
public class MainClass {
   public static void main(String args[]){
       Scanner scan = new Scanner(System.in);

      String  s;
      int  d;
      int  f;
      int  i;
      String  s2;

      f = 4;
      System.out.println("Quanto deveria ser a nota desse compilador? 0,00 a 10,00");
      i = 1;
      d = scan.nextInt();
      while (d != 10) {
         switch (d) {
         case 1:
            System.out.println("1 é muito pouco");
            System.out.println("Acho que deveria ser mais");
         case 2:
            System.out.println("2 é muito pouco");
            break;
         case 3:
            System.out.println("3 é muito pouco");
         case 4:
            System.out.println("4 é muito pouco");
            break;
         case 5:
            System.out.println("5 é muito pouco");
            break;
         case 6:
            System.out.println("6 é muito pouco");
         case 7:
            System.out.println("7 é muito pouco");
         default:
            if (d < 10) {
               System.out.println("Acho que deveria ser mais");
            } else {
               System.out.println("Infelizmente o limite é 10 :(");
            }
         }
         d = scan.nextInt();
         i = i + 1;
      }
      s = "Voce precisou de";
      System.out.println(s);
      System.out.println(i);
      if (i == 1) {
         System.out.println("Tentativa");
      } else {
         System.out.println("Tentativas");
      }

      scan.close();
   }
}