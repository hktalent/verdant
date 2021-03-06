package creational.prototype.prototype;

import java.util.ArrayList;

/**
 * Author: verdant
 * Create: 2016/1/27
 * Desc:   原型
 */
public class Prototype implements Cloneable {
    private ArrayList al = new ArrayList();
    @Override
    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype) super.clone();
            prototype.al = (ArrayList) this.al.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }
}
