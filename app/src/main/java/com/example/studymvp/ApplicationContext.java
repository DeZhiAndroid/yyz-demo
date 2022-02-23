package com.example.studymvp;

import android.app.Application;

/**
 * @ClassName ApplicationContext
 * @Author 史正龙
 * @date 2022.02.22 09:36
 */
public class ApplicationContext extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ApplicationListener());
    }

    @Override
    public void registerActivityLifecycleCallbacks(ActivityLifecycleCallbacks callback) {
        super.registerActivityLifecycleCallbacks(callback);
    }
}
