package problemdomain;
/**
 * This class defines an abstract class of polygon
 * @author ColeKepford
 *
 */
public abstract class Polygon implements Comparable<Polygon>
{
	private double height;
	
	/**
	 * This method compares the height of this polygon to another polygon
	 * then returns  0 if they're equal, 1 if this polygon's height is greater
	 * and -1 if the other polygon's height is greater
	 * @param shape - a polygon
	 * @return an integer of 1,0, or -1
	 */
	@Override
	public int compareTo(Polygon shape)
	{
		if(this.getHeight() == shape.getHeight())
		{
			return 0;
		}
		else if(this.getHeight() > shape.getHeight())
		{
			return 1;
		}
		else 
		{
			return -1;
		}
	}
	
	/**
	 * Returns the double in the height field
	 * @return double in height field
	 */
	public double getHeight()
	{
		return this.height;
	}
	
	/**
	 * This method returns the base area of a polygon
	 * @return a double being the base area
	 */
	public abstract double getBaseArea();
	
	/**
	 * This method returns the base area of a polygon
	 * @return a double being the volume
	 */
	public abstract double getVolume();
}
