package utilitydomain;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import problemdomain.Polygon;
/**
 * This class runs multiple sorts on arrays full of polygons
 * The sorts consist bubble, insertion, selection, merge, quick, and gnome
 * @author ColeKepford
 *
 */
public class Sorter
{
	private static BaseAreaComparator ac = new BaseAreaComparator();
	private static VolumeComparator vc = new VolumeComparator();
	private static Polygon polygon;
	
	/**
	 * This method uses bubble sort to sort an array of polygons
	 * @param arr - an array of Polygons
	 * @param arg - a String consisting of one character determining how polygons are compared.
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void bubbleSort(Polygon arr[], String arg) throws NoSuchMethodException, SecurityException
	{
		Method method = null;
		
		
		if(arg.equals("a"))
		{
			method = ac.getClass().getMethod("compare", Polygon.class, Polygon.class);
		}
		else if(arg.equals("v"))
		{
			method = vc.getClass().getMethod("compare", Polygon.class, Polygon.class);
		}
		//compare height
		if(arg.equals("h"))
		{
			int n = arr.length;
			for(int i = 0; i < n - 1; i++)
			{
				for(int j = 0; j < n - i - 1; j++) 
				{
					if(arr[j].compareTo(arr[j + 1]) == -1)
					{
						Polygon temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		}
		

		else
		{
			int n = arr.length;
			for(int i = 0; i < n - 1; i++)
			{
				for(int j = 0; j < n - i - 1; j++) 
				{
					try 
					{
						if( (int) method.invoke(null, arr[j], arr[j + 1]) == -1)
						{
							Polygon temp = arr[j];
							arr[j] = arr[j + 1];
							arr[j + 1] = temp;
						}
					} 
					catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) 
					{
						e.printStackTrace();
					}
				}
			}
		}
		//compare base area
		/*else if(arg.equals("a"))
		{
			int n = arr.length;
			for(int i = 0; i < n - 1; i++)
			{
				for(int j = 0; j < n - i - 1; j++) 
				{
					if(ac.compare(arr[j], arr[j + 1]) == -1)
					{
						Polygon temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		}
		
		//compare volume
		else if(arg.equals("v"))
		{
			int n = arr.length;
			for(int i = 0; i < n - 1; i++)
			{
				for(int j = 0; j < n - i - 1; j++) 
				{
					if(vc.compare(arr[j], arr[j + 1]) == -1)
					{
						Polygon temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;
					}
				}
			}
		}*/	
	}
	
	/**
	 * This method uses insertion sort to sort an array of polygons
	 * @param arr - an array of polygons
	 * @param arg - a String consisting of one character determining how polygons are compared.
	 */
	public static void insertionSort(Polygon arr[], String arg)
	{
		//compare height
		if(arg.equals("h"))
		{
			int n = arr.length;
			for(int i = 1; i < n; i++)
			{
				Polygon key = arr[i];
				int j = i ;
				
				while(j > 0 && arr[j - 1].compareTo(key) == -1)
				{
					arr[j] = arr[j - 1];
					j--;
				}
				arr[j] = key;
				if(i % 100000 == 0)
				{
					System.out.println(i + " items sorted");
				}
			}
		}
		
		//compare base area
		else if(arg.equals("a"))
		{
			int n = arr.length;
			for(int i = 1; i < n; i++)
			{
				Polygon key = arr[i];
				int j = i;
				
				while(j > 0 && ac.compare(arr[j - 1], key) == -1)
				{
					arr[j] = arr[j - 1];
					j--;
				}
				arr[j] = key;
			}
		}
		
		//compare volume
		else if(arg.equals("v"))
		{
			int n = arr.length;
			for(int i = 1; i < n; i++)
			{
				Polygon key = arr[i];
				int j = i;
				
				while(j > 0 && vc.compare(arr[j - 1], key) == -1)
				{
					arr[j] = arr[j - 1];
					j--;
				}
				arr[j] = key;
				if(i == 0 || i % 1000 == 0 || i == n -1)
				{
					System.out.println(arr[i].getVolume());
				}
			}
		}
	}
	
	/**
	 * This method uses selection sort to sort an array of polygons
	 * @param arr - an array of polygons
	 * @param arg - a String consisting of one character determining how polygons are compared.
	 */
	public static void selectionSort(Polygon arr[], String arg)
	{
		//compare height
	    if(arg.equals("h"))
	    {
	    	for(int i = 0; i < arr.length-1; i++)
		    {
		        int max = i;
		        for(int j = i+1; j < arr.length; j++)
		        {
		            if(arr[j].compareTo(arr[max]) == 1)
		            {
		                max = j;
		            }
		        }
		        if(max != i)
		        {
		            swap(arr,max,i);
		        }
		    }
	    }
	    
	    //compare base area
	    else if(arg.equals("a"))
	    {
	    	for(int i = 0; i < arr.length-1; i++)
		    {
		        int max = i;
		        for(int j = i+1; j < arr.length; j++)
		        {
		            if(ac.compare(arr[j], arr[max]) == 1)
		            {
		                max = j;
		            }
		        }
		        if(max != i)
		        {
		            swap(arr,max,i);
		        }
		    }
	    }
	    
	    //compare volume
	    else if(arg.equals("v"))
		{
			for(int i = 0; i < arr.length-1; i++)
		    {
		        int max = i;
		        for(int j = i+1; j < arr.length; j++)
		        {
		            if(vc.compare(arr[j], arr[max]) == 1)
		            {
		                max = j;
		            }
		        }
		        if(max != i)
		        {
		            swap(arr,max,i);
		        }
		    }
		}	
	}
	
	/**
	 * This method uses merge sort to sort an array of polygons
	 * @param arr - an array of polygons
	 * @param lowest - the lowest index of the array
	 * @param highest - the highest index of the array
	 * @param arg - a String consisting of one character determining how polygons are compared.
	 */
	public static void mergeSort(Polygon[] arr, int lowest, int highest, String arg)
	{
	    if (lowest == highest) 
	        return; 
	    int middle = (lowest + highest) / 2; 
	    mergeSort(arr, lowest, middle, arg); 
	    mergeSort(arr, middle + 1, highest, arg); 

	    merge(arr, lowest, middle, highest, arg); 
	}

	/**
	 * The merge method merges two polygon arrays and sorts them in descending order
	 * @param arr - an array of polygons
	 * @param lowest - lowest index of the array
	 * @param middle - middle index of the array
	 * @param highest - highest index of the array
	 * @param arg - a String consisting of one character determining how polygons are compared.
	 */
	public static void merge(Polygon[] arr, int lowest, int middle, int highest, String arg)
	{

	    Polygon[] temp = new Polygon[highest - lowest + 1]; 
	    int i = lowest, 
	    j = middle + 1, 
	    n = 0; 
	    
	    //compare height
	    if(arg.equals("h"))
	    {
	    	while (i <= middle || j <= highest) 
		    { 
		        if (i > middle) 
		        { 
		            temp[n] = arr[j]; 
		            j++; 
		        } 
		        else if (j > highest) 
		        { 
		            temp[n] = arr[i]; 
		            i++; 
		        } 
		        
		        else if (arr[i].compareTo(arr[j]) == 1) 
		        {   
		            temp[n] = arr[i];
		            i++;
		        }
		        else
		        {
		            temp[n] = arr[j];
		            j++;
		        }
		        n++;
		    }   
		    for (int k = lowest ; k <= highest ; k++) 
		    {
		        arr[k] = temp[k - lowest]; 
		    }
	    }
	    
	    //compare base area
	    else if(arg.equals("a"))
	    {
	    	while (i <= middle || j <= highest) 
		    { 
		        if (i > middle) 
		        { 
		            temp[n] = arr[j]; 
		            j++; 
		        } 
		        else if (j > highest) 
		        { 
		            temp[n] = arr[i]; 
		            i++; 
		        } 
		        
		        else if (ac.compare(arr[i], arr[j]) == 1) 
		        {   
		            temp[n] = arr[i];
		            i++;
		        }
		        else
		        {
		            temp[n] = arr[j];
		            j++;
		        }
		        n++;
		    }   
		    for (int k = lowest ; k <= highest ; k++) 
		    {
		        arr[k] = temp[k - lowest]; 
		    }
	    }
	    
	    //compare volume
	    else if(arg.equals("v"))
	    {
	    	while (i <= middle || j <= highest) 
		    { 
		        if (i > middle) 
		        { 
		            temp[n] = arr[j]; 
		            j++; 
		        } 
		        else if (j > highest) 
		        { 
		            temp[n] = arr[i]; 
		            i++; 
		        } 
		        
		        else if (vc.compare(arr[i], arr[j]) == 1) 
		        {   
		            temp[n] = arr[i];
		            i++;
		        }
		        else
		        {
		            temp[n] = arr[j];
		            j++;
		        }
		        n++;
		    }   
		    for (int k = lowest ; k <= highest ; k++) 
		    {
		        arr[k] = temp[k - lowest]; 
		    }
	    }
	}  
	
	/**
	 * This method uses quicksort to sort an array of polygons
	 * @param arr - an array of polygons
	 * @param lowest - the lowest index of the array
	 * @param highest - the highest index of the array
	 * @param arg - a String consisting of one character determining how polygons are compared.
	 */
	public static void quickSort(Polygon[] arr, int lowest, int highest, String arg) 
    {
      if (arr == null || arr.length == 0)
      {
          return;
      }
      if (lowest >= highest)
      {
          return;
      }
      
      //compare height
      if(arg.equals("h"))
      {
    	  int middle = lowest + (highest - lowest) / 2;
          Polygon pivot = arr[middle];

          int i = lowest, j = highest;
          while (i <= j)
          {
              while (arr[i].compareTo(pivot) ==  1) 
              {
                  i++;
              }
              while (arr[j].compareTo(pivot) ==  - 1) 
              {
                  j--;
              }
              if (i <= j) 
              {
                  swap (arr, i, j);
                  i++;
                  j--;
              }
          }
     
          if (lowest < j)
          {
              quickSort(arr, lowest, j, arg);
          }
          if (highest > i)
          {
              quickSort(arr, i, highest, arg);
          }
      }
      
      //compare base area
      else if(arg.equals("a"))
      {
    	  int middle = lowest + (highest - lowest) / 2;
          Polygon pivot = arr[middle];

          int i = lowest, j = highest;
          while (i <= j)
          {
              while (ac.compare(arr[i], pivot) ==  1) 
              {
                  i++;
              }
              while (ac.compare(arr[j], pivot) ==  -1) 
              {
                  j--;
              }
              if (i <= j) 
              {
                  swap (arr, i, j);
                  i++;
                  j--;
              }
          }
     
          if (lowest < j)
          {
              quickSort(arr, lowest, j, arg);
          }
          if (highest > i)
          {
              quickSort(arr, i, highest, arg);
          }
      }

      //compare volume
      else if(arg.equals("v"))
      {
    	  int middle = lowest + (highest - lowest) / 2;
          Polygon pivot = arr[middle];

          int i = lowest, j = highest;
          while (i <= j)
          {
              while (vc.compare(arr[i], pivot) ==  1) 
              {
                  i++;
              }
              while (vc.compare(arr[j], pivot) ==  - 1) 
              {
                  j--;
              }
              if (i <= j) 
              {
                  swap (arr, i, j);
                  i++;
                  j--;
              }
          }
     
          if (lowest < j)
          {
              quickSort(arr, lowest, j, arg);
          }
          if (highest > i)
          {
              quickSort(arr, i, highest, arg);
          }
      }
      
    }
	
	/**
	 * This method uses gnome sort to sort an array of polygons
	 * @param arr - an array of polygons
	 * @param arg - a String consisting of one character determining how polygons are compared.
	 */
	public static void gnomeSort(Polygon[] arr, String arg)
	  {
		  int i=1;
		  int j=2;
		 
		  //compare height
		  if(arg.equals("h"))
		  {
			  while(i < arr.length) 
			  {
			    if (arr[i - 1].compareTo(arr[i]) == 1 || arr[i - 1].compareTo(arr[i]) == 0) 
				{
			      i = j; 
			      j++;
			    } 
			    else 
			    {
			      Polygon temp = arr[i - 1];
			      arr[i-1] = arr[i];
			      arr[i--] = temp;
			      i = (i == 0) ? j++ : i;
			    }
			  }
		  }
		  
		  //compare base area
		  else if(arg.equals("a"))
		  {
			  while(i < arr.length) 
			  {
				  
			    if (ac.compare(arr[i - 1], arr[i]) == 0 || ac.compare(arr[i - 1], arr[i]) == 1) 
				{
			      i = j; 
			      j++;
			    } 
			    else 
			    {
			      Polygon temp = arr[i - 1];
			      arr[i-1] = arr[i];
			      arr[i--] = temp;
			      i = (i == 0) ? j++ : i;
			    }
			  }
		  }
		  
		  //compare volume
		  else if(arg.equals("v"))
		  {
			  while(i < arr.length) 
			  {
				  
			    if (vc.compare(arr[i - 1], arr[i]) == 0 || vc.compare(arr[i - 1], arr[i]) == 1) 
				{
			      i = j; 
			      j++;
			    } 
			    else 
			    {
			      Polygon temp = arr[i - 1];
			      arr[i-1] = arr[i];
			      arr[i--] = temp;
			      i = (i == 0) ? j++ : i;
			    }
			  }
		  }	  
	  }
	
	/**
	 * This method swaps to polygons in a polygon array
	 * @param arr - an array of polygons
	 * @param x - first polygon
	 * @param y - second polygon
	 */
	public static void swap (Polygon arr[], int x, int y)
    {
        Polygon swapArray = arr[x];
        arr[x] = arr[y];
        arr[y] = swapArray;
    }
}