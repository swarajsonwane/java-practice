package LD.AbstractFactoryPattern;


//This is super-factory class
public class PhoneStore {

    //Why private constructor?
    //Because we don't want to create object of this class
    private PhoneStore() {
    }

    public static Phone getPhone(String brand, String model) {
        if(brand.equals("Apple")) {
            return Apple.getPhone(model);
        }else if (brand.equals("Samsung")) {
            return Samsung.getPhone(model);
        }

        return new NullPhone();
    }
}
