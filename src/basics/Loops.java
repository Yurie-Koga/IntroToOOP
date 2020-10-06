package basics;

public class Loops {
    public static void main(String[] args) {
        // for loop
        for (int i = 0; i < 10; i++){
            System.out.printf("%d ", i);
        }
        System.out.println();
        for (int i = 10; i >= 0; i--){
            System.out.printf("%d ", i);
        }
        System.out.println();

        // infinit loop
        for (;;){
            break;
        }

        // while
        int k = 10;
        while (true) {
            break;
        }
        while(k > 0){
            System.out.printf("%d ", k);
            k--;
        }
        System.out.println();

        // print numbers. add a line break when number is 10 or 20
        for (int i = 1; i <= 20; i++){
            System.out.printf("%d ", i);
            if (i % 10 == 0){
                System.out.println();
            }
        }
        //System.out.println();

        // print even numberes from 1 to 100.
        int l = 1;
        while (l <= 100){
            if (l % 2 == 0){
                System.out.printf("%d ", l);
            }
            l++;
        }
        System.out.println();
        // way2: if the start number can be fixed.
        int n = 2;
        while (n <= 100){
            System.out.printf("%d ", n);
            n += 2;
        }
        System.out.println();
    }
}
