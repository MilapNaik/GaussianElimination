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
         
        
        double[][] system = new double[numRows][numRows+1];
        // define a 2-dimensional array for linear system matrix. Don't forget that the number of rows in the augmented matrix doesn't equal to the number of columns.
        for (int i = 0; i < numRows; ++i)
            for (int j = 0; j < numRows + 1; ++j)
                 system[i][j] = input.nextDouble();
          
        // use nested loops to read linear system elements from the file to the 2-dimensional array you defined
        
        double[] res = solve(system); // give your 2-dimensional array as a parameter to the solve method (instead of ...)

        // Printing results
        for (int i = 0; i < res.length; ++i)
             System.out.println("x_" + (i+1) + " = " + res[i]);
        
        input.close();  
	}//Closes main method
   
	static public double[] solve(double[][] system) {
     
		int j, i, k, x;
		double sum, fact;
		int n = system.length;
     
		// define an array of an appropriate size to store the result (i.e. the values of unknown parameters)
        double[] a;
        a = new double[n];

        // TODO: implement forward elimination, given a description of the algorithm in the lab
        for (i = 0; i < n; i++)
        {//1
        	for (j = i+1; j < n; j++)
        	{
        		double coef = system[j][i] / system[i][i];
 
        		for (k=0; k< n+1; k++)
        		{ 
        			system[j][k] -= coef * system[i][k];
        		}
        	}
        }//1
      
       for (i = n - 1; i >= 0; --i) 
       {
    	   sum = 0;
    	   for (k=i+1; k<n-1; k++)
    	   {
			   sum += system[i][k] * a[k];
    	   }
    	   a[i] = (system[i][n] - sum) / system[i][i];
			   
    	   // TODO: implement back substitution to get the values of unknown variables	   
       }
       return a;
	}//Closes solve method
}

