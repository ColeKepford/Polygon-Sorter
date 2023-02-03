package applicationdomain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import problemdomain.*;
import utilitydomain.Sorter;
/**
 * This class reads a text file of polygon objects. Then takes input from the command line to 
 * sort the polygons in descending order
 * @author ColeKepford
 *
 */

public class AppDriver 
{
	/**
	 * Main Method
	 * @param args - arguments
	 * @throws IOException -  throws IOException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String args[]) throws IOException, NoSuchMethodException, SecurityException
	{
		System.out.println("App Launched");
		String file = "";
        String compareType = "";
        String sort = "";

        //reads input from the command line
        for (int x = 0; x < args.length; x++) 
        {
            if (args[x].toLowerCase().contains("-f")) 
            {
                file = args[x].substring(2);
            } 
            else if (args[x].toLowerCase().contains("-t")) 
            {
                compareType = args[x].substring(2);
            } 
            else if (args[x].toLowerCase().contains("-s")) 
            {
                sort = args[x].toLowerCase().substring(2);
            }
        }

        Polygon arr[] = populate(file);
        
        //recording start time
        long currTime = System.currentTimeMillis();
        System.out.println("\nSorting started...");
        
        //checking for sort type
    	if(sort.equals("b"))
    	{
    		Sorter.bubbleSort(arr, compareType);
    	}
    	
    	else if(sort.equals("i"))
    	{
    		Sorter.insertionSort(arr, compareType);
    	}
    	
    	else if(sort.equals("s"))
    	{
    		Sorter.selectionSort(arr, compareType);
    	}
    	
    	else if(sort.equals("m"))
    	{
    		Sorter.mergeSort(arr, 0, arr.length - 1, compareType);
    	}
    	
    	else if(sort.equals("q"))
    	{
    		Sorter.quickSort(arr, 0, arr.length - 1, compareType);
    	}
    	
    	else if(sort.equals("z"))
    	{
    		Sorter.gnomeSort(arr, compareType);
    	}
        //calculate sort time
        long timeDiff = (System.currentTimeMillis() - currTime);
        
        
        if(compareType.equals("h"))
        {
        	//Print out every 1000 sorted values
            System.out.println("[1] " + arr[0].getHeight());
            for(int i = 999; i < arr.length; i += 1000)
            {
            	System.out.println("[" + (1 + i) + "] " + arr[i].getHeight());
            }
            System.out.println("Last Value: " + arr[arr.length - 1].getHeight());
        }
        else if(compareType.equals("a"))
        {
        	 //Print out every 1000 sorted values
            System.out.println("[1] " + arr[0].getBaseArea());
            for(int i = 999; i < arr.length; i += 1000)
            {
            	System.out.println("[" + (1 + i) + "] " + arr[i].getBaseArea());
            }
            System.out.println("Last Value: " + arr[arr.length - 1].getBaseArea());
        }
        else if(compareType.equals("v"))
        {
        	 //Print out every 1000 sorted values
            System.out.println("[1] " + arr[0].getVolume());
            for(int i = 999; i < arr.length; i += 1000)
            {
            	System.out.println("[" + (1 + i) + "] " + arr[i].getVolume());
            }
            System.out.println("Last Value: " + arr[arr.length - 1].getVolume());
        }
        //Output time
        System.out.println("The sort took " + timeDiff + " milliseconds");
	}
	
	/**
	 * This method reads a txt file of polygons and populates an array with the file
	 * @param fileName - string for a filename
	 * @return returns an array from the file
	 * @throws IOException - throws IOException
	 */
	public static Polygon[] populate(String string) throws IOException
	{
		String file = string;
		
		BufferedReader br;
		br = new BufferedReader(new FileReader(new File(file)));
		
        String line = "";
        ArrayList<String> content = new ArrayList<>();
        
       int size;
        
       //read text file into arraylist
       while ((line = br.readLine()) != null) 
         {
            String splitLine[] = line.split(" "); 
    	   	for(int i = 0; i < splitLine.length; i++)
    	   	{
    	   		content.add(splitLine[i]);
    	   	}
         }
         br.close();
         
         System.out.println("File loaded...\n\n Loading Polygon Array...");
        
         //read number of polygons in array then delete first entry.
         size = Integer.parseInt(content.get(0));
         content.remove(0);
         
         Polygon[] arr = new Polygon[size];
         //number of shapes added to array
         int addedShapes = 0;
         
         //read file into array of polygons
         for(int i = 0; i < content.size(); i++)
         {
            if(content.get(i).equals("Cone"))
            {
            	Cone cone = new Cone(Double.parseDouble(content.get(i + 1)), Double.parseDouble(content.get(i + 2)));
            	arr[addedShapes] = cone;
            	addedShapes++;
            	i = i + 1;
            	continue;
            }
            
            else if(content.get(i).equals("Cylinder"))
            {
            	Cylinder cylinder = new Cylinder(Double.parseDouble(content.get(i + 1)), Double.parseDouble(content.get(i + 2)));
            	arr[addedShapes] = cylinder;
            	addedShapes++;
            	i = i + 1;
            	continue;
            }
            
            else if(content.get(i).equals("Pyramid"))
            {
            	Cylinder cylinder = new Cylinder(Double.parseDouble(content.get(i + 1)), Double.parseDouble(content.get(i + 2)));
            	arr[addedShapes] = cylinder;
            	addedShapes++;
            	i = i + 1;
            	continue;
            }
            
            else if(content.get(i).equals("OctagonalPrism"))
            {
            	OctagonalPrism oPrism = new OctagonalPrism(Double.parseDouble(content.get(i + 1)), Double.parseDouble(content.get(i + 2)));
            	arr[addedShapes] = oPrism;
            	addedShapes++;
            	i = i + 1;
            	continue;
            }
            
            else if(content.get(i).equals("PentagonalPrism"))
            {
            	PentagonalPrism pPrism = new PentagonalPrism(Double.parseDouble(content.get(i + 1)), Double.parseDouble(content.get(i + 2)));
            	arr[addedShapes] = pPrism;
            	addedShapes++;
            	i = i + 1;
            	continue;
            }
            
            else if(content.get(i).equals("SquarePrism"))
            {
            	SquarePrism sPrism = new SquarePrism(Double.parseDouble(content.get(i + 1)), Double.parseDouble(content.get(i + 2)));
            	arr[addedShapes] = sPrism;
            	addedShapes++;
            	i = i + 1;
            	continue;
            }
            
            else if(content.get(i).equals("TriangularPrism"))
            {
            	TriangularPrism tPrism = new TriangularPrism(Double.parseDouble(content.get(i + 1)), Double.parseDouble(content.get(i + 2)));
            	arr[addedShapes] = tPrism;
            	addedShapes++;
            	i = i + 1;
            	continue;
            }
         }
         
         System.out.println("\nPolygon Array Loaded...");
         return arr;
	}
}
