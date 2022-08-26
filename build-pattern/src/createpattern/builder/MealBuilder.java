package createpattern.builder;

import createpattern.builder.extend.burger.ChickenBurger;
import createpattern.builder.extend.burger.VegBurger;
import createpattern.builder.extend.drink.Coke;
import createpattern.builder.extend.drink.Pepsi;

/**
 * @author mucongcong
 * @date 2022/08/11 20:51
 * @since
 **/
public class MealBuilder {
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
