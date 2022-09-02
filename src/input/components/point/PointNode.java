package input.components.point;

/**
 * A 2D Point (x, y).
 * 
 * @author taterosen
 * @date 08/31/2022
 */

public class PointNode {
	protected static final String ANONYMOUS = "__UNNAMED";

	protected double _x;

	public double getX() {
		return this._x;
	}

	protected double _y;

	public double getY() {
		return this._y;
	}

	protected String _name;

	public String getName() {
		return _name;
	}

	/**
	 * Create a new Point with the specified coordinates.
	 * 
	 * @param x The X coordinate
	 * @param y The Y coordinate
	 */
	public PointNode(double x, double y) {
		this(ANONYMOUS, x, y);
	}

	/**
	 * Create a new Point with the specified coordinates.
	 * 
	 * @param name -- The name of the point. (Assigned by the UI)
	 * @param x -- The X coordinate
	 * @param y -- The Y coordinate
	 */
	public PointNode(String name, double x, double y) {
		this._name = name;
		this._x = x;
		this._y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + this.getName().hashCode();
		long temp;
		temp = Double.doubleToLongBits(this.getX());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(this.getY());
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return this.hashCode() == obj.hashCode();
	}

	@Override
	public String toString() {
		return this.getName() + "(" + this.getX() + ", " + this.getY() + ")";
	}
}
