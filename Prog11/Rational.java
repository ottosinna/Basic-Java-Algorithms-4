import java.util.*;
public class Rational {
    int num;
    int den;

    public Rational(int m, int n) {
        if (n < 0) {
            m = -m;
            n = -n;
        }
        int gcd = Utility.findGCD(Math.abs(m), n);
        m = m / gcd;
        n = n / gcd;
        num = m;
        den = n;
    }

    public Rational() {
        num = 1;
        den = 2;
    }

    public Rational(int n) {
        num = n;
        den = 1;
    }

    public Rational(String s) {
        int whole = 0;
        int num = 0;
        int den = 1;
        s = s.trim();
        if (s.contains(".")) {
            double d = Double.parseDouble(s);
            Rational r = new Rational(d);
            num = r.num;
            den = r.den;
        } else if (s.contains("/")) {
            String[] parts = s.split("/");
            if (parts.length == 2) {
                // Proper fraction
                num = Integer.parseInt(parts[0]);
                den = Integer.parseInt(parts[1]);
            } else if (parts.length == 3) {
                whole = Integer.parseInt(parts[0]);
                num = Integer.parseInt(parts[1]);
                den = Integer.parseInt(parts[2]);
                num += whole * den;
            }
            int gcd = Utility.findGCD(num, den);
            num /= gcd;
            den /= gcd;
            whole += num / den;
            num = num % den;
        } else {
            num = Integer.parseInt(s);
            den = 1;
        }
        if (den < 0) {
            num = -num;
            den = -den;
        }
        this.num = num;
        this.den = den;
    }

    public Rational(double d) {
        String s = String.valueOf(d);
        String[] rAt = s.split("\\.");

        if (Integer.parseInt(rAt[0]) != 0) {
            num = Integer.parseInt(rAt[0]);
        }
        String bond = "1";
        for (int i = 0; i < rAt[1].length(); i++) {
            bond += "0";
        }
        num = (Integer.parseInt(rAt[0]) * Integer.parseInt(bond)) + Integer.parseInt(rAt[1]);
        den = Integer.parseInt(bond);
        if (num != 0) {
            int c = Utility.findGCD(num, den);
            num = num / c;
            den = den / c;
        }
    }

    public String toString() {
        int whole = num / den;
        int rem = num % den;
        String s = "";
        if (rem == 0) {
            s += whole;
        } else if (whole != 0) {
            s += whole + " ";
            rem = Math.abs(rem);
            int gcd = Utility.findGCD(rem, den);
            s += (rem / gcd) + "/" + (den / gcd);
        } else {
            int gcd = Utility.findGCD(rem, den);
            s += (rem / gcd) + "/" + (den / gcd);
        }
        return s.trim().replaceAll("\\s*/\\s*", "/");
    }
}