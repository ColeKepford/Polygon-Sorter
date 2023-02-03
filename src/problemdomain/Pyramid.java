package problemdomain;
/**
 * Pyramid extends the Polygon class
 * @author ColeKepford
 *
 */
public class Pyramid extends Polygon
{
	private double height;
	private double edgeLength;
	
	/**
	 * Constructor for Pyramid
	 * @param height -  a double
	 * @param edgeLength - a double
	 */
	public Pyramid(double height, double edgeLength) 
	{
		super();
		this.height = height;
		this.edgeLength = edgeLength;
	}
	
	@Override
	public double getBaseArea() 
	{
		return Math.pow(this.edgeLength, 2);
	}
	@Override
	public double getVolume() 
	{
		return (1/3) * Math.pow(this.edgeLength, 2) * this.height;
	}
	
	@Override
	public double getHeight()
	{
		return this.height;
	}

	/**
	 * Returns the double in the edgeLength field
	 * @return a double from the edgeLength field
	 */
	public double getEdgeLength() 
	{
		return edgeLength;
	}
}
