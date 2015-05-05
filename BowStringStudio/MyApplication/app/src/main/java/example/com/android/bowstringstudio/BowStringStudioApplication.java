package example.com.android.bowstringstudio;

import android.app.Application;

import example.com.android.bowstringstudio.domains.Store;

/**
 * Created by cognitiveclouds on 02/05/15.
 */
public class BowStringStudioApplication extends Application {

    private static BowStringStudioApplication instance;

    public static BowStringStudioApplication getInstance() {
        if (null == instance) {
            instance = new BowStringStudioApplication();
        }
        return instance;
    }

    private Store store;

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
