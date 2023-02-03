package problemdomain;
/**
 * 
 * @author cocog
 *
 */
public class SquarePrism extends Polygon
{
	private double height;
	private double edgeLength;

	public SquarePrism(double height, double edgeLength) 
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
		return Math.pow(this.edgeLength, 2) * this.height;
	}

	@Override
	public double getHeight()
	{
		return this.height;
	}
	
	/**
	 * Returns the double in the edgeLength field
	 * @return a double in from the edgeLength field
	 */
	public double getEdgeLength() 
	{
		return edgeLength;
	}
}
