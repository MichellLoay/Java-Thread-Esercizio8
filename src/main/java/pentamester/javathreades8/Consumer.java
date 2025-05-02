/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.javathreades8;

/**
 *
 * @author shwak
 */
public class Consumer extends Thread {

    private Product prod;
    private int times;

    public Consumer(Product prod, String name, int times) {
        this.prod = prod;
        this.setName(name);
        this.times = times;
    }

    public void run() {
        try {
            for (int i = 0; i < times; i++) {
                System.out.println(this.getName() + " dormo...");
                Thread.sleep(5000);
                int tmp = prod.getElement();
                System.out.println(this.getName() + " ho consumato: " + tmp);
                prod.setElement(tmp);
            }
        } catch (InterruptedException e) {
            System.out.println(this.getName() + " sono stato interrotto ");
        }
    }
}
