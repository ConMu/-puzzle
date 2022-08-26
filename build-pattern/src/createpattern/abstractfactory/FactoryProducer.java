package createpattern.abstractfactory;

import createpattern.abstractfactory.factory.ColorFactory;
import createpattern.abstractfactory.factory.ShapeFactory;

/**
 * @author mucongcong
 * @date 2022/08/05 17:31
 * @since
 **/
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
