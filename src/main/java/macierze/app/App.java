package macierze.app;

import java.util.Scanner;

/**
 * Basic app representing matrix opertions.
 *
 */
public class App 
{

   /**
    * Matrix 1.
    *
    */
   private Matrix matrix1;
   
   /**
    * Matrix 2.
    *
    */
   private Matrix matrix2;

   /**
    * Empty class constructor.
    *
    */
   public App()
   {
      matrix1 = null;
      matrix2 = null;
   }


   /**
    * Method for running basic presentation.
    *
    */
   public void run()
   {
      Scanner scanner = new Scanner(System.in);      
      
         System.out.println("Enter range:");
         int range = Integer.parseInt(scanner.nextLine());

         System.out.println("Enter x:");
         int x = Integer.parseInt(scanner.nextLine());

         System.out.println("Enter y:");
         int y = Integer.parseInt(scanner.nextLine());

      matrix1 = new Matrix(range, x, y);
      matrix2 = new Matrix(range, x, y);

      System.out.println("M1:");
      matrix1.print();

      System.out.println("M2:");
      matrix2.print();

      System.out.println("M1+M2:");
      matrix1.add(matrix2).print();

      System.out.println("M1-M2:");
      matrix1.subtract(matrix2).print();

      System.out.println("M1*M2:");
      matrix1.multiply(matrix2).print();
   }

   public static void main( String[] args )
   {
      App app = new App();
      app.run();
   }
}
