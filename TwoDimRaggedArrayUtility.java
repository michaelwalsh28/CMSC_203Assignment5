/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: The TwoDimRaggedArrayUtility class is a class full of methods
 * that work with a 2D array finding the largest and smallest numbers, the 
 * totals, averages, and indexes of this data. These methods are used 
 * in the HolidayBonus class of the Project to find the total holiday bonuses
 * for each company.
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Michael Walsh
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class TwoDimRaggedArrayUtility extends Object
{
	private static final int MAX_ROWS = 10;
	private static final int MAX_COLUMNS = 10;
	
	public TwoDimRaggedArrayUtility()
	{
		
	}
	static double [][] readFile (File file) throws FileNotFoundException
	{
		ArrayList<double[]> data = new ArrayList<>();
		
		
		try (Scanner inFile = new Scanner (file))
		{
			while (inFile.hasNextLine())
			{
				String currentLine = inFile.nextLine();
	
		        String [] rows = currentLine.split(" ");
		        double [] doubles = new double[rows.length];
		        
		        for (int i = 0; i < rows.length; i++)
		        {
		        	doubles[i] = Double.parseDouble(rows[i]);
		        }
		        data.add(doubles);
			}
			
		}

		catch (FileNotFoundException e)
		{
			System.out.println("That File is not Found ");
		}
		
		return data.toArray(new double[0][]);
	}
	
	static void writeToFile (double [][] data, File outputFile) throws FileNotFoundException
	{
		PrintWriter output = new PrintWriter (outputFile);
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				output.print(data[row][col] + " ");
			}
			output.println();
		}
		
		output.close();
	}
	
	static double getTotal(double [][] data)
	{
		double total = 0;
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
			}
		}
		return total;
	}
	
	static double getAverage(double [][] data)
	{
		double average = getTotal(data) / data.length;
		return average;
	}
	
	static double getRowTotal(double[][] data, int row)
	{
		double total = 0.0;
		for (int col = 0; col < data[row].length; col++)
		{
			total += data[row][col];
		}
		return total;
	}
	
	static double getColumnTotal(double [][] data, int col)
	{
		double total = 0.0;
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				total += data[row][col];
			}
		}
		return total;
	}
	
	static double getHighestInRow(double [][] data, int row)
	{
		double highest = 0;
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] > highest)
			{
				highest = data[row][col];
			}
		}
		return highest;
	}
	
	static int getHighestInRowIndex(double [][] data, int row)
	{
		double highest = 0.0;
		int highestIndex = 0;
		
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] > highest)
			{
				highest = data[row][col];
				highestIndex = col;
			}
		}
		return highestIndex;
	}
	
	static double getLowestInRow(double [][] data, int row)
	{
		double lowest = 10000000.0;
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] < lowest && data[row][col] > 0)
			{
				lowest = data[row][col];
			}
		}
		return lowest;
	}
	
	static int getLowestInRowIndex(double [][] data, int row)
	{
		double lowest = 100000.0;
		int lowestIndex = 0;
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] < lowest  && data[row][col] > 0)
			{
				lowest = data[row][col];
				lowestIndex = col;
			}
		}
		return lowestIndex;
	}
	
	static double getHighestInColumn(double [][] data, int col)
	{
;
		double highest = 0.0;
		for (int row = 0; row < data.length; row++)
		{
			if (data[row].length > col)
			{
				if (data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	static int getHighestInColumnIndex(double [][] data, int col)
	{
		int highestIndex = 0;
		double highest = 0.0;
		for (int row = 0; row < data.length; row++)
		{
			if (data[row].length > col)
			{
				if (data[row][col] > highest)
				{
					highest = data[row][col];
					highestIndex = row;
				}
			}
		}
		return highestIndex;
	}
	
	static double getLowestInColumn(double [][] data, int col)
	{
		double lowest = 1000000.0;
		for (int row = 0; row < data.length; row++)
		{
			if (data[row].length > col)
			{
				if (data[row][col] < lowest)
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
	
	static int getLowestInColumnIndex(double [][] data, int col)
	{
		int lowestIndex = 0;
		double lowest = 10000000.0;
		for (int row = 0; row < data.length; row++)
		{
			if (data[row].length > col)
			{
				if (data[row][col] < lowest)
				{
					lowest = data[row][col];
					lowestIndex = row;
				}
			}
		}
		return lowestIndex;
	}
	
	static double getHighestInArray(double [][] data)
	{
		double highest = 0.0;
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				if (data[row][col] > highest)
				{
					highest = data[row][col];
				}
			}
		}
		return highest;
	}
	
	static double getLowestInArray(double [][] data)
	{
		double lowest = 100000000.0;
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				if (data[row][col] < lowest)
				{
					lowest = data[row][col];
				}
			}
		}
		return lowest;
	}
	
}
