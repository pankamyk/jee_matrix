package macierze.app;


/**
 * Hello world!
 *
 */
public class App 
{
   public static void main( String[] args )
   {
      Matrix matrix1 = new Matrix(new int[][] { { 1, 3 }, { 1, 0 } });
      Matrix matrix2 = new Matrix(new int[][] { { 0, 0 }, { 7, 5 } });
   

      // DEBUGING
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
}
