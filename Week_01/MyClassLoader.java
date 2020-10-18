import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    // @Override
    // public Class<?> loadClass(String name) throws ClassNotFoundException {
    //     InputStream is = this.getClass().getClassLoader().getResourceAsStream(name+".xlass");
    //     byte[] bytes = new byte[0];
    //     try {
    //         bytes = new byte[is.available()];
    //         is.read(bytes);
    //         for (int i = 0; i < bytes.length;i++) {
    //             bytes[i] = (byte) (255 - bytes[i]);
    //         }
    //         this.defineClass(name, bytes, 0, bytes.length);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     return super.loadClass(name);
    // }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(name+".xlass");
        byte[] bytes = new byte[0];
        try {
            bytes = new byte[is.available()];
            is.read(bytes);
            for (int i = 0; i < bytes.length;i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            Class retClass = this.defineClass(name, bytes, 0, bytes.length);
            return retClass;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }
}
