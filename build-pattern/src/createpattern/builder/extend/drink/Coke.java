package createpattern.builder.extend.drink;

import createpattern.builder.impl.ColdDrink;

/**
 * @author mucongcong
 * @date 2022/08/11 20:50
 * @since
 **/
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
