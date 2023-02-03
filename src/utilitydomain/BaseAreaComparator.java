package utilitydomain;

import java.util.*;

import problemdomain.Polygon;

/**
 * The BaseAreaComparator implements the Comparator class
 * It compares two polygons based off base area
 * @author ColeKepford
 *
 */
public class BaseAreaComparator implements Comparator<Polygon> 
{ 
    public int compare(Polygon p1, Polygon p2) 
    {
    	if(p1.getBaseArea() == p2.getBaseArea())
		{
			return 0;
		}
		else if(p1.getBaseArea() > p2.getBaseArea())
		{
			return 1;
		}
		else 
		{
			return -1;
		}
    }
}