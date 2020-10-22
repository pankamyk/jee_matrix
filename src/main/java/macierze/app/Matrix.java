package macierze.app;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.*;

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

      ArrayList<ArrayList<Integer>> dataFromStream = 
         Stream.generate( () -> {
               return Stream.generate( () -> rndGen.nextInt(range) )
                         .limit(numCol)
                         .collect( Collectors.toCollection(ArrayList::new) );
            })
            .limit(numRow)
            .collect( Collectors.toCollection(ArrayList::new) ); 

      data = dataFromStream;
   }

   /**
    * Class constructor from 2d array (aka from raw data).
    *
    * @param   rawData 2d array (int[][]) from which matrix will be initialized 
    */
   public Matrix(int[][] rawData)
   {
      Stream<Stream<Integer>> rawDataStream = 
         Arrays.stream(rawData)
               .map(x -> {
                  return Arrays.stream(x)
                               .boxed();
               });

      data = rawDataStream
               .map(x -> {
                  return x.collect( Collectors.toCollection(ArrayList::new) );
               })
               .collect( Collectors.toCollection(ArrayList::new) );
   }

   /**
    * Empty class contructor.
    * Mainly for tests.
    *
    */
   public Matrix()
   {
      this(new int[][] { {0} });
   }
   
   /**
    * Returns number of rows in the matrix.
    * 
    * @return rows number of rows (sizeX)
    */
   public int rows()
   {
      return data.size();
   }
   
   /**
    * Returns number of columns in the matrix.
    *
    * @return rows number of rows (sizeX)
    */
   public int colums()
   {
      return data.get(0).size();
   }

   /**
    * Returns the raw data of the matrix.
    * 
    * @return  raw  raw 2d array(int[][]) of data from the matrix
    */
   public int[][] rawData()
   {
      int[][] raw = data.stream()
                        .map(x -> {
                           return x.stream()
                                   .mapToInt(i -> i)
                                   .toArray();
                        })
                        .toArray(int[][]::new);

      return raw;
   }
   
   /**
    * Method for multiplying two compatible matrices. Doesn't mutate the current object.
    * 
    * @param   otherMatrix    operand to be multiplied by of type Matrix.
    * @return  returnMatrix   effect of multiplication of type Matrix.
    */
   public Matrix multiply(Matrix otherMatrix)
   {
      int[][] operandData = otherMatrix.rawData();
      int[][] thisData    = rawData();

      int[][] returnData = 
         Arrays.stream(thisData)
               .parallel()
               .map(thisRow -> IntStream.range(0, operandData[0].length)
                  .map(i -> IntStream.range(0, operandData.length)
                     .map(j -> thisRow[j] * operandData[i][j])
                     .sum()
                  )
                  .toArray()
               )
               .toArray(int[][]::new);

      return new Matrix(returnData);
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
