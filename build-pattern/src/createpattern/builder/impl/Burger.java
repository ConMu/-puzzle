package createpattern.builder.impl;

import createpattern.builder.inter.Item;
import createpattern.builder.inter.Packing;

/**
 * @author mucongcong
 * @date 2022/08/11 20:46
 * @since
 **/
public abstract class Burger implements Item {

    @Override
    public Packing packing(){
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
