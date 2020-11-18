import models.Cart;
import models.Product;
import models.Variants;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cart myCart =new Cart();
        Product Banana = new Product("Banana");
       Banana.variantsList = Arrays.asList(new Variants("green",40)
               ,new Variants("yellow",45)
        );
        Product Kiwi = new Product("kiwi",30);
        Product Capsicum= new Product("Capsicum",20);

        Product Coconut = new Product("Coconut");
        Coconut.variantsList = Arrays.asList(new Variants("green",50)
                ,new Variants("Brown",100)
        );

        myCart.addVariantsToCart(Banana,Banana.variantsList.get(0));
        myCart.addVariantsToCart(Banana,Banana.variantsList.get(0));
        myCart.addVariantsToCart(Banana,Banana.variantsList.get(1));

        System.out.println("Banana Variants added : " + myCart);

        myCart.updateWBP(Kiwi,3);
        myCart.updateWBP(Capsicum,2);

        System.out.println("WBP added : " + myCart);

        myCart.addVariantsToCart(Coconut,Coconut.variantsList.get(0));
        myCart.addVariantsToCart(Coconut,Coconut.variantsList.get(1));
        myCart.addVariantsToCart(Coconut,Coconut.variantsList.get(1));

        System.out.println("Coconut Variants added : " + myCart);

        myCart.removeVariantsFromCart(Banana,Banana.variantsList.get(1)) ;
        System.out.println("Banana yellow Variant removed : " + myCart);

        myCart.removeWBP(Kiwi);
        System.out.println("WBP Kiwi removed : " + myCart);

        myCart.removeAllVariantsFromCart(Coconut);
        System.out.println("All Variants of Coconut removed : " + myCart);

    }
}
