package macierze.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Sample 2d matrix class
 *
 */
public class Matrix
{
   
   /**
    * Raw data representation of the matrix.
    *
    */
   private ArrayList<ArrayList<Integer>> data;

   /**
    * Class constructor generating matrix based on user parameters.
    *
    * @param   range       range span of generated number in matrix
    * @param   numberRow   number of rows
    * @param   numberCol   number of columns
    */
   public Matrix(int range, int numRow, int numCol)
   {
      Random rndGen = new Random();

      Stream<ArrayList<Integer>> dataStream = Stream.generate( () -> {
         return Stream.generate( () -> ( rndGen.nextInt(range) ) )
                      .limit(numCol)
                      .collect( Collectors.toCollection(ArrayList::new) );
      }); 

      data = dataStream.limit(numRow)
                       .collect(Collectors.toCollection(ArrayList::new) );
   }

   /**
    * Class constructor from 2d array.
    *
    * @param   arr2d 2d array from which matrix will be initialized 
    */
   public Matrix(int[][] arr2d)
   {

   }

   /**
    * Empty class contructor.
    * Mainly for tests.
    *
    */
   public Matrix(){}
   
   /**
    * Returns the raw data of the matrix.
    * 
    * @return  raw  raw 2d array of data from the matrix
    */
   public int[][] rawData()
   {
      int[][] raw = new int[1][1];

      return raw;
   }

   /**
    * Prints promitive representation of the matrix to the stdout.
    *
    */
   public void print()
   {
      data.forEach( element -> {
         element.forEach( number -> System.out.print(number + " "));

         System.out.println();
      });
   }
}
