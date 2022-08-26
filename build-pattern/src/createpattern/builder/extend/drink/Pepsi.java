package createpattern.builder.extend.drink;

import createpattern.builder.impl.ColdDrink;

/**
 * @author mucongcong
 * @date 2022/08/11 20:50
 * @since
 **/
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
