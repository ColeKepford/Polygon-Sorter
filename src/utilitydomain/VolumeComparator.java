package utilitydomain;

import java.util.*;
import problemdomain.Polygon;
/**
 *The VolumeComparator implements the Comparator class
 *It compares two polygons based off volume
 * @author ColeKepford
 *
 */
public class VolumeComparator implements Comparator<Polygon> 
{ 
    public int compare(Polygon p1, Polygon p2) 
    {
    	if(p1.getVolume() == p2.getVolume())
		{
			return 0;
		}
		else if(p1.getVolume() > p2.getVolume())
		{
			return 1;
		}
		else 
		{
			return -1;
		}
    }
}