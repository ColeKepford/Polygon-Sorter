package problemdomain;
/**
 * The Cylinder class extends the Polygon
 * @author ColeKepford
 *
 */
public class Cylinder extends Polygon
{
	private double height;
	private double radius;

	/**
	 * Constructor for Cylnder
	 * @param height - a double
	 * @param radius - a double
	 */
	public Cylinder(double height, double radius) 
	{
		super();
		this.height = height;
		this.radius = radius;
	}

	@Override
	public double getBaseArea() 
	{
		return Math.PI * Math.pow(this.radius, 2);
	}

	@Override
	public double getVolume() 
	{
		return Math.PI * Math.pow(this.radius, 2) * this.height;
	}

	@Override
	public double getHeight()
	{
		return this.height;
	}

	/**
	 * Returns the radius field
	 * @return a double from the radius field
	 */
	public double getRadius() 
	{
		return radius;
	}

}
