// Inspired by: https://medium.com/swlh/programming-linear-algebra-in-java-vector-operations-6ba08fdd5a1a

package pl.edu.pw.fizyka.pojava.spiochy.math;

public interface Vector {
    double[] getValues();

    double getLength();
    Vector normalize();

    Vector add(Vector v) throws DimNotEqualException;
    Vector subtract(Vector v) throws DimNotEqualException;
    double dot(Vector v) throws DimNotEqualException;

    static boolean isDimEqual(Vector v1, Vector v2) {
        double[] val1 = v1.getValues();
        double[] val2 = v2.getValues();

        return (val1.length == val2.length);
    }
}
