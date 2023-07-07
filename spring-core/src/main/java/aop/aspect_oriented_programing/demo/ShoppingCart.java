package aop.aspect_oriented_programing.demo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout() {
        //with AOP's aspect we can do:
        //logging
        //authentication  & authorization
        //sanitizing the data

        System.out.println("Checkout Method from Shopping Cart is Called");
    }

    public void checkout(String status) {
        //with AOP's aspect we can do:
        //logging
        //authentication  & authorization
        //sanitizing the data

        System.out.println(status + " | Checkout Method from Shopping Cart is Called");
    }

    public int quantity() {
        return 2;
    }
}
