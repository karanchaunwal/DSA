package assignments;
//Recursion
public class Assignment11 {
    public void driver() {

        Recursion_1 ReObj = new Recursion_1();

        // System.out.println(ReObj.sum_N(3));

        // ReObj.print_N(10);

        // ReObj.print_RevN(10);

        // ReObj.print_EvenN(10);

        // ReObj.print_RevEvenN(10);

        // ReObj.print_OddN(5);

        ReObj.print_RevOddN(5);

    }
}

class Recursion_1 {

    int sum_N(int n) {
        if (n < 1) {
            return 0; // exception handled
        }
        if (n == 1) {
            return n;
        } else
            return (n + sum_N(n - 1));

    }

    void print_N(int n) {

        if (n > 0) {
            print_N(n - 1);
            System.out.print(n + " ");
        }
    }

    void print_RevN(int n) {
        if (n > 0) {
            System.out.print(n + " ");
            print_RevN(n - 1);
        }

    }

    void print_EvenN(int n) {
        if (n > 0) {
            print_EvenN(n - 1);
            System.out.print(2 * n + " ");
        }
    }

    void print_RevEvenN(int n) {
        if (n > 0) {
            System.out.print(2 * n + " ");
            print_RevEvenN(n - 1);
        }
    }

    void print_OddN(int n) {
        if (n > 0) {
            print_OddN(n - 1);
            System.out.print((2 * n - 1) + " ");
        }
    }

    void print_RevOddN(int n) {
        if (n > 0) {
            System.out.print((2 * n - 1) + " ");
            print_RevOddN(n - 1);
        }
    }
}



