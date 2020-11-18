package models;

import java.util.HashMap;

public class Cart {
    public HashMap<String,CartItem> AllTypeOfItemInCart = new HashMap<>();
    public HashMap<String,Integer> TotalVariantsOfItem =new HashMap<>();
    public  int subtotal, noOfItems;

    public  int addVariantsToCart(Product product,Variants variants){
        String key= product.productName + " " + variants.name;

        if(AllTypeOfItemInCart.containsKey(key))
            AllTypeOfItemInCart.get(key).qty++;
        else
            AllTypeOfItemInCart.put(key,new CartItem(variants.name, variants.price));
        noOfItems++;
        subtotal+= variants.price;

        if (TotalVariantsOfItem.containsKey(product.productName)) {
            int newQty = TotalVariantsOfItem.get(product.productName) + 1;
            TotalVariantsOfItem.put(product.productName,newQty);
        }
        else {
            TotalVariantsOfItem.put(product.productName,1);
        }
       return (int)AllTypeOfItemInCart.get(key).qty;
    }

    public int removeVariantsFromCart(Product product,Variants variants){
        String key= product.productName + " " + variants.name;
        AllTypeOfItemInCart.get(key).qty--;

        if(AllTypeOfItemInCart.get(key).qty==0)
            AllTypeOfItemInCart.remove(key);

        noOfItems--;
        subtotal-=variants.price;

        int newQty = TotalVariantsOfItem.get(product.productName) - 1;
        TotalVariantsOfItem.put(product.productName,newQty);

       if (TotalVariantsOfItem.get(product.productName)==0)
           TotalVariantsOfItem.remove(product.productName);

       return AllTypeOfItemInCart.containsKey(key) ? (int)AllTypeOfItemInCart.get(key).qty : 0;
    }

    public void removeAllVariantsFromCart(Product product){
        for (Variants variant : product.variantsList){
            String key = product.productName + " " + variant.name;

            if(AllTypeOfItemInCart.containsKey(key)){
                noOfItems-=AllTypeOfItemInCart.get(key).qty;
                subtotal-=AllTypeOfItemInCart.get(key).price;
                AllTypeOfItemInCart.remove(key);
            }
        }
        if (TotalVariantsOfItem.containsKey(product.productName))
        TotalVariantsOfItem.remove(product.productName);

    }

    public void updateWBP(Product product,float qty){
        int newPrice = (int)(product.pricePerKg*qty);

        if(AllTypeOfItemInCart.containsKey(product.productName))
            subtotal-=AllTypeOfItemInCart.get(product.productName).price;
        else
            noOfItems++;
        AllTypeOfItemInCart.put(product.productName,new CartItem(product.productName,newPrice,qty));
        subtotal+=newPrice;
        }

    public void removeWBP(Product product){
        if(AllTypeOfItemInCart.containsKey(product.productName)){
            noOfItems--;
            subtotal-=AllTypeOfItemInCart.get(product.productName).price;
            AllTypeOfItemInCart.remove(product.productName);
        }
    }

    @Override
    public String toString() {
        return "Cart{" +
                "AllTypeOfItemInCart=" + AllTypeOfItemInCart +
                ",\n TotalVariantsOfItem=" + TotalVariantsOfItem +
                ",\n subtotal=" + subtotal +
                ",\n noOfItems=" + noOfItems +
                '}';
    }
}
