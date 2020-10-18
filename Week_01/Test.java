import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {


    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader();
        try {
            Class cls = myClassLoader.findClass("Hello");
            Object obj = cls.newInstance();
            Method method = cls.getMethod("hello");
            method.setAccessible(true);
            method.invoke(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
