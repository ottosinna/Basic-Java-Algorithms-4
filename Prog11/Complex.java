public class Complex {
    
    Rational real;
    Rational imag;

    Complex(Rational a) {
        real = a;
        imag = new Rational(); 
    }
    Complex(Rational a, Rational b) {
        real = a;
        imag = b;
    }
    // New constructor that takes two doubles
    Complex(double a, double b) {
        real = new Rational(a);
        imag = new Rational(b);
    }

    public String toString() {
        String s;
        if (imag.num < 0) s = real + " " + imag + "i";
        else if (imag.num == 0) s = ""+real;
        else s= real + " + " + imag + "i";
        return s;
    }
}