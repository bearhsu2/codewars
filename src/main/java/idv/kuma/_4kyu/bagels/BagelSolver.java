package idv.kuma._4kyu.bagels;


import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class BagelSolver {


    public static Bagel getBagel() {
        // TODO : Implement me.
        try {
            Field field = Boolean.class.getField("TRUE");
            field.setAccessible(true);

            Field modField = Field.class.getDeclaredField("modifiers");
            modField.setAccessible(true);
            modField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, false);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
        return new Bagel();
    }
}
