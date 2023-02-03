package problemdomain;
/**
 * The TriangularPrism class extends the Polygon class
 * @author ColeKepford
 *
 */
public class TriangularPrism extends Polygon
{
	private double height;
	private double edgeLength;

	/**
	 * Triangular prism constructor
	 * @param height - a double
	 * @param edgeLength - a double
	 */
	public TriangularPrism(double height, double edgeLength) 
	{
		super();
		this.height = height;
		this.edgeLength = edgeLength;
	}

	@Override
	public double getBaseArea() 
	{
		return (Math.pow(this.edgeLength, 2) * Math.sqrt(3)) / 4;
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
	 * Returns the double in the edgeLength field
	 * @return a double from the edgeLength field
	 */
	public double getEdgeLength() 
	{
		return edgeLength;
	}
}
