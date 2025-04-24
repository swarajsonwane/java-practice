package LD.AbstractFactoryPattern;

import java.util.Objects;


//This is sub-factory class
public class Apple {

    private Apple() {
    }

    public static Phone getPhone(String model) {
        if(Objects.equals(model, "iPhone14")) {
            return new Phone("iPhone14");
        }else if (Objects.equals(model, "iPhone15")) {
            return new Phone("iPhone15");}
            else if (Objects.equals(model, "iPhone16")) {
                return new Phone("iPhone16");
            }

            return new NullPhone();
    }
}
