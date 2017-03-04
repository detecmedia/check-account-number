package de.detecmedia.checkaccountnumber;

/**
 * Created by potthast on 03.03.17.
 */
public class MainClass {
    /**
     * simple test.
     *
     * @param args
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(String[] args)
            throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException {
        System.out.println("test");

        String method = "00";

        ClassLoader classLoader = MainClass.class.getClassLoader();

        Class aClass = classLoader.loadClass(
                "de.detecmedia.checkaccountnumber.Method" + method);

        CheckAccountNumber checkAccountNumber =
                (CheckAccountNumber) aClass.newInstance();

        checkAccountNumber.setAccountNumber("9290701");
        System.out.println(checkAccountNumber.test());

    }
}
