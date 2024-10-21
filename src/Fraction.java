public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {throw new IllegalArgumentException("Denominator cannot be zero");}
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private int nod(int a, int b) {
        if (b == 0) {return a;}
        else {return nod(b, a % b);}
    }

    private void simplify() {
        int nod = nod(Math.abs(numerator), Math.abs(denominator));
        numerator /= nod;
        denominator /= nod;
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public Fraction sum(Fraction other) {return new Fraction(this.numerator * other.denominator + this.denominator * other.numerator, this.denominator * other.denominator);}

    public Fraction sum(int value) {return new Fraction(this.numerator + this.denominator * value, this.denominator);}

    public Fraction minus(Fraction other) {return new Fraction(numerator * other.denominator - this.denominator * other.numerator, this.denominator * other.denominator);}

    public Fraction minus(int value) {return new Fraction(this.numerator - this.denominator * value, this.denominator);}

    public Fraction multiply(Fraction other) {return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);}

    public Fraction multiply(int value) {return new Fraction(this.numerator * value, this.denominator);}

    public Fraction divide(Fraction other) {return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);}

    public Fraction divide(int value) {return new Fraction(this.numerator, this.denominator * value);}

    @Override
    public String toString() {return numerator + "/" + denominator;}
}
