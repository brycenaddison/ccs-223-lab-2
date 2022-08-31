package input.components.segment;

import input.components.point.PointNode;

/**
 * A utility class only for representing ONE segment
 * 
 * @author brycenaddison
 * @date Wed Aug 31 2022
 */
public class SegmentNode {
	protected PointNode _point1;
	protected PointNode _point2;

	public PointNode getPoint1() {
		return _point1;
	}

	public PointNode getPoint2() {
		return _point2;
	}

	public SegmentNode(PointNode pt1, PointNode pt2) {
		_point1 = pt1;
		_point2 = pt2;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SegmentNode)) {
			return false;
		}

		SegmentNode s = (SegmentNode) obj;

		return ((this._point1.equals(s._point1) && this._point2.equals(s._point2))
				|| (this._point1.equals(s._point2) && this._point2.equals(s._point1)));
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash *= 31 * this._point1.hashCode();
		hash *= 37 * this._point2.hashCode();
		return hash;
	}

	@Override
	public String toString() {
		return String.format("<%s, %s>", this._point1.toString(), this._point2.toString());
	}
}
