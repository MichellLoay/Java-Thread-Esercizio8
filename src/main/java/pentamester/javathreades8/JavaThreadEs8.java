/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package pentamester.javathreades8;

/**
 *
 * @author shwak
 */
public class JavaThreadEs8 {

    public static void main(String[] args) {
        Product p = new Product(0);//monitor, sezione critica
        Consumer c1 = new Consumer(p, "C1", 5);
        Producer p1 = new Producer(p, "P1", 5);
        c1.start();
        p1.start();
        try {
            c1.join();
            p1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
