package macierze.app;

/**
 * Hello world!
 *
 */
public class App 
{
   public static void main( String[] args )
   {
      Matrix matrix1 = new Matrix(10, 4, 4);
      Matrix matrix2 = new Matrix(new int[][] { { 10, 9 }, { 8, 7 }});
      matrix1.print();
      matrix2.print();
   }
}
