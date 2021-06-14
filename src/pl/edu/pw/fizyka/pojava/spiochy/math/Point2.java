package pl.edu.pw.fizyka.pojava.spiochy.math;

public class Point2 implements Point
{
    double x, y;

    public Point2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getValues() {
        return new double[] {this.x, this.y};
    }

    public Vector2 delta(Point p) throws DimNotEqualException {
        if(!Point.isDimEqual(this, p))
            throw new DimNotEqualException("These points seems to be from another dimension..");

        double[] val2 = p.getValues();

        return new Vector2(this.x - val2[0], this.y - val2[1]);
    }
}
