package LD.rentzoomcar;

import java.util.List;

public class VehicleRentalSystem {
    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> storeList, List<User> userList) {
        this.storeList = storeList;
        this.userList = userList;
    }

    public Store getStore(Location location) {
        for (Store store : storeList) {
            if (store.location.equals(location)) {
                return store;
            }
        }
        return null;
    }



}
