/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pentamester.javathreades8;

/**
 *
 * @author shwak
 */
/*public class Product {

    private int element;

    public Product(int n) {
        this.element = n;
    }

    public void setElement(int element) {
        this.element = element;
    }

    public int getElement() {
        return this.element;
    }
}

public class Product {

    private int element;

    public Product(int n) {
        this.element = n;
    }
//aggiunta synchronized
    public synchronized void setElement(int element) {
        this.element = element;
    }

    public synchronized int getElement() {
        return this.element;
    }
}
 */
public class Product {

    private int element;

    private boolean produced; // variabile guardia  

    public Product(int n) {

        this.element = n;
        this.produced = false;
    }

    public synchronized void setElement(int element) {
        while (produced) {
            try {
                System.out.println(Thread.currentThread().getName() + " aspetto");
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " sono stato interrotto mentre aspettavo di poter produrre");
            }
        }

        this.element = element;
        produced = true;
        notifyAll();
    }

    public synchronized int getElement() {

        while (!produced) {
            try {
                System.out.println(Thread.currentThread().getName() + " aspetto");
                wait();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " sono stato interrotto mentre aspettavo di poter consumare");
            }
        }
        produced = false;
        notifyAll();
        return element;
    }
}
