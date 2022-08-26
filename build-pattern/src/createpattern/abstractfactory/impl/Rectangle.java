package createpattern.abstractfactory.impl;


import createpattern.abstractfactory.inter.Shape;

/**
 * @author mucongcong
 * @date 2022/08/05 16:56
 * @since
 **/
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
