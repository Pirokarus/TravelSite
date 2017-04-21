package com.travelSite.server.database.DataBaseManager;

public class NewCitiesInDB {
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        dbManager.create("Moscow","Russia",55.7494733,37.3523219, "en");
        dbManager.create("Saint Petersburg","Russia",59.9171483,30.0448872, "en");
        dbManager.create("Nizhny Novgorod","Russia",56.2926609,43.786664, "en");
        dbManager.create("Minsk","Belarus",53.8838069,27.4548925, "en");
        dbManager.create("Mogilev","Belarus",53.8834808,30.2114953, "en");

    }
}
