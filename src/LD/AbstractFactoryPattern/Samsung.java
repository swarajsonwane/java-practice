package LD.AbstractFactoryPattern;

//This is sub-factory class
public class Samsung {

    private Samsung() {
    }

    public static Phone getPhone(String model) {
        if(model.equals("SamsungGalaxyS21")) {
            return new Phone("SamsungGalaxyS21");
        }else if (model.equals("SamsungGalaxyS22")) {
            return new Phone("SamsungGalaxyS22");}
            else if (model.equals("SamsungGalaxyS23")) {
                return new Phone("SamsungGalaxyS23");
            }

            return new NullPhone();
    }
}
