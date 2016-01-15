package creational.abstractFactory.factory;

import creational.abstractFactory.component.AbstractComponentA;
import creational.abstractFactory.component.AbstractComponentB;

/**
 * Created by verdant on 2016/1/14.
 * Desc: 抽象工厂
 */
public interface AbstractFactory {
    public AbstractComponentA createComponentA();
    public AbstractComponentB createComponentB();
}