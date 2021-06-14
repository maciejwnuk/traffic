package pl.edu.pw.fizyka.pojava.spiochy.math;

public interface Point {
    double[] getValues();

    Vector delta(Point p) throws DimNotEqualException;

    static boolean isDimEqual(Point p1, Point p2) {
        double[] val1 = p1.getValues();
        double[] val2 = p2.getValues();

        return (val1.length == val2.length);
    }
}
