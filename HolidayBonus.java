/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description: The HolidayBonus class goes through each product to 
 * find the highest amount, allocating that bonus amount relatively. 
 * The calculateTotalHolidayBonus method adds all the bonuses from the returned array of the 
 * previous method.
 * Due: 04/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Michael Walsh
*/

public class HolidayBonus extends Object
{
	private static final double highestBonus = 5000.0;
	private static final double lowestBonus = 1000.0;
	private static final double avgBonus = 2000.0;
	
	public HolidayBonus()
	{
		
	}
	static double[] calculateHolidayBonus(double[][] data)
	{	
		double [] holidayBonus = new double[data.length];
		
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				if (data[row][col] == TwoDimRaggedArrayUtility.getHighestInColumn(data, col))
				{
					holidayBonus[row] += highestBonus;
				}
				else if (data[row][col] == TwoDimRaggedArrayUtility.getLowestInColumn(data, col) &&
						data[row][col] > 0)
				{
					holidayBonus[row] += lowestBonus;
				}
				else if (data[row][col] != TwoDimRaggedArrayUtility.getHighestInColumn(data, col) &&
						data[row][col] != TwoDimRaggedArrayUtility.getLowestInColumn(data, col) &&
						data[row][col] > 0)
				{
					holidayBonus[row] += avgBonus;
				}
			}
		}
		return holidayBonus;
	}
	
	static double calculateTotalHolidayBonus(double[][] data)
	{
		double arr [] = calculateHolidayBonus(data);
		double totalBonus = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			totalBonus += arr[i];
		}
		return totalBonus;
	}
}
