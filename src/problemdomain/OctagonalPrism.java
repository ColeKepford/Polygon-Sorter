package problemdomain;
/**
 * The OctagonalPrism class extends the Polygon class
 * @author ColeKepford
 *
 */
public class OctagonalPrism extends Polygon
{
	private double height;
	private double edgeLength;

	/**
	 * Constructor for OctagonalPrism
	 * @param height - a double
	 * @param edgeLength - a double
	 */
	public OctagonalPrism(double height, double edgeLength) 
	{
		super();
		this.height = height;
		this.edgeLength = edgeLength;
	}

	@Override
	public double getBaseArea() 
	{
		return 2 * (1 + Math.sqrt(2)) * Math.pow(this.edgeLength, 2);
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
	 * Returns the double in the field edgeLength
	 * @return a double from edgeLength
	 */
	public double getEdgeLength() 
	{
		return edgeLength;
	}

}
