package structural.decorator.uml.decorater;

import structural.decorator.uml.component.Component;
import utils.DebugLog;
import utils.DebugLogFactory;
import utils.DesignPatternEnum;

/**
 * 实例化装饰者B
 *
 * @author verdant
 * @since 2016/04/12
 */
public class ConcreteDecoratorB extends Decorator {

    private static final DebugLog logger = DebugLogFactory.getLogger(ConcreteDecoratorB.class, DesignPatternEnum.Decorator);

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        logger.log("Decorate by " + DebugLog.getClassName(this.getClass()));
        super.operation();
        // 写相关的业务代码
    }
}
