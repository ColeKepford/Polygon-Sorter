package problemdomain;
/**
 * PentagonalPrism extends the Polygon class
 * @author cocog
 *
 */
public class PentagonalPrism extends Polygon
{
	private double height;
	private double edgeLength;

	/**
	 * Constructor for Pentagonal Prism
	 * @param height -  a double
	 * @param edgeLength -  a double
	 */
	public PentagonalPrism(double height, double edgeLength) 
	{
		super();
		this.height = height;
		this.edgeLength = edgeLength;
	}

	@Override
	public double getBaseArea() 
	{
		return (5 * Math.pow(this.edgeLength, 2) * Math.tan(54)) / 4;
	}

	@Override
	public double getVolume() 
	{
		return getBaseArea() * this.height;
	}

	@Override
	public double getHeight()
	{
		return this.height;
	}
	
	/**
	 * Returns a double from edgeLength field
	 * @return a double from the edgeLength field
	 */
	public double getEdgeLength() 
	{
		return edgeLength;
	}

}
