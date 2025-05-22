package ru.khismatov.math;

/*Создайте сущность Дробь со следующими особенностями: • Имеет числитель: целое число 
• Имеет знаменатель: целое число 
• Дробь может быть создана с указанием числителя и знаменателя 
• Может вернуть строковое представление вида "числитель/знаменатель" 
• Может выполнять операции сложения, вычитания, умножения и деления с другой
Дробью или целым числом. Результатом операции должна быть новая Дробь (таким образом,обе исходные дроби не изменяются) 
*/
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            System.out.println("Error: Denominator cannot be zero");
            this.numerator = numerator; 
            this.denominator = 1; 
            return;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
    }

    private int nod(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return nod(b, a % b);
        }
    }

    private void simplify() {
        if (denominator == 0) {
            return; 
        }
        int commonDivisor = nod(Math.abs(numerator), Math.abs(denominator));
        if (commonDivisor != 0) {
            numerator /= commonDivisor;
            denominator /= commonDivisor;
        }
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
    }

    public Fraction sum(Fraction other) {
        return new Fraction(this.numerator * other.denominator + this.denominator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction sum(int value) {
        return new Fraction(this.numerator + this.denominator * value, this.denominator);
    }

    public Fraction minus(Fraction other) {
        return new Fraction(this.numerator * other.denominator - this.denominator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction minus(int value) {
        return new Fraction(this.numerator - this.denominator * value, this.denominator);
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction multiply(int value) {
        return new Fraction(this.numerator * value, this.denominator);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            System.out.println("Error: Division by zero (other fraction's numerator is zero).");
            return new Fraction(0, 1); 
        }
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Fraction divide(int value) {
        if (value == 0) {
            System.out.println("Error: Division by zero (integer value is zero).");
            return new Fraction(0, 1);
        }
        return new Fraction(this.numerator, this.denominator * value);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
