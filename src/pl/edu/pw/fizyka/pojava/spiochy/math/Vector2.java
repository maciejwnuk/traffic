package pl.edu.pw.fizyka.pojava.spiochy.math;

public class Vector2 implements Vector
{
    double x, y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getValues() {
        return new double[] {this.x, this.y};
    }

    public double getLength() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public Vector2 normalize() {
        double len = this.getLength();

        return new Vector2(this.x / len, this.y / len);
    }

    public Vector add(Vector v) throws DimNotEqualException {
        if(!Vector.isDimEqual(this, v))
            throw new DimNotEqualException("These vectors seems to be from another dimension..");

        double[] val2 = v.getValues();

        return new Vector2(this.x + val2[0], this.y + val2[1]);
    }

    public Vector subtract(Vector v) throws DimNotEqualException {
        if(!Vector.isDimEqual(this, v))
            throw new DimNotEqualException("These vectors seems to be from another dimension..");

        double[] val2 = v.getValues();

        return new Vector2(this.x - val2[0], this.y - val2[1]);
    }

    public double dot(Vector v) throws DimNotEqualException {
        if(!Vector.isDimEqual(this, v))
            throw new DimNotEqualException("These vectors seems to be from another dimension..");

        double[] val2 = v.getValues();

        return (this.x * val2[0] + this.y * val2[1]);
    }
}
