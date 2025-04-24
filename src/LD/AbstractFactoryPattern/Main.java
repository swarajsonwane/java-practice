package LD.AbstractFactoryPattern;

public class Main {
    public static void main(String[] args) {
        Phone phone1 = PhoneStore.getPhone("Samsung", "SamsungGalaxyS21");
        System.out.println(phone1.getDescription());

        Phone phone2 = PhoneStore.getPhone("Samsung", "SamsungGalaxyS22");
        System.out.println(phone2.getDescription());

        Phone phone3 = PhoneStore.getPhone("Apple", "iPhone14");
        System.out.println(phone3.getDescription());

        Phone phone4 = PhoneStore.getPhone("Apple", "iphone20");
        System.out.println(phone4.getDescription());
    }
}
