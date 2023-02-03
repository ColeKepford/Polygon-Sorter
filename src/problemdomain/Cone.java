package problemdomain;
/**
 * The Cone class extends Polygon. 
 * It has a height and radius field
 * @author ColeKepford
 *
 */
public class Cone extends Polygon 
{
	private double height;
	private double radius;
	
	/**
	 * Constructor for cone
	 * @param height - a double
	 * @param radius - a double
	 */
	public Cone(double height, double radius) 
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
		return (Math.PI / 3) * Math.pow(this.radius, 2) * this.height;
	}
	
	@Override
	public double getHeight()
	{
		return this.height;
	}

	public void setHeight(double height) 
	{
		this.height = height;
	}

	public double getRadius() 
	{
		return radius;
	}

	public void setRadius(double radius) 
	{
		this.radius = radius;
	}
	
}
