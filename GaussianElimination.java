import java.io.*;
import java.util.Scanner;

public class GaussianElimination
{

	static public void main(String[] args) throws IOException
	{
        // Create a file object with the name passed as a command line argument (i.e. as args[0] element)
        // define Scanner for reading a system from a file
		  File inp = new File(args[0]);
          Scanner input = new Scanner(inp);

        // read the size of the system (number of rows)
          int numRows = 0;
          numRows = input.nextInt();   
         
        // define a 2-dimensional array for linear system matrix. Don't forget that the number of rows in the augmented matrix doesn't equal to the number of columns.
          double[][] system = new double[numRows][numRows+1];
        
        
        // use nested loops to read linear system elements from the file to the 2-dimensional array you defined
          for (int i = 0; i < numRows; ++i)
        	  for (int j = 0; j < numRows + 1; ++j)
        		  system[i][j] = input.nextDouble();
        
        // give your 2-dimensional array as a parameter to the solve method (instead of ...)
          double[] results = solve(system);
        
        // Printing results
          for (int i = 0; i < results.length; ++i)
        	  System.out.println("x_" + (i+1) + " = " + results[i]);
        
          input.close();  
	}//Closes main method
   
	static public double[] solve(double[][] system) {
     
		  int i, j, k;
		  double sum;
		  int length = system.length;
     
		// define an array of an appropriate size to store the result (i.e. the values of unknown parameters)
		  double[] results;
		  results = new double[length];

        // TODO: implement forward elimination, given a description of the algorithm in the lab
		  for (i = 0; i < length; i++)
		  {
			  for (j = i+1; j < length; j++)
			  { 
				  double coef = system[j][i] / system[i][i]; //Row j column i / row i column i

				  for (k=0; k< length+1; k++)
				  { 
					  system[j][k] -= coef * system[i][k];// Make row j column k = 0

				  }
			  }
		  }
      
		// TODO: implement back substitution to get the values of unknown variables
		  for (i = length - 1; i >= 0; --i) 
		  {
			  sum = 0;
			  for (k=0; k<length; k++)
			  {
				  sum += system[i][k] * results[k];

			  }
			  
			  results[i] = (system[i][length] - sum) / system[i][i];
  	   
		  }
		  return results;
	}//Closes solve method
}

