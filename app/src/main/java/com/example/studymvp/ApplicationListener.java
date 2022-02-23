package com.example.studymvp;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Iterator;
import java.util.Stack;

/**
 * @ClassName ApplicationListener
 * @Author 史正龙
 * @date 2022.02.22 09:37
 */
public class ApplicationListener implements Application.ActivityLifecycleCallbacks {
    /**
     * Activity管理栈
     */
    private static Stack<Activity> activityStack = new Stack<>();

    /**
     * 获取栈顶Activity
     */
    public static Activity getTopActivity() {
        return activityStack.peek();
    }

    /**
     * 获取App中当前Activity栈深度
     *
     * @return
     */
    public static int getActivitySize() {
        return activityStack.size();
    }

    /**
     * 退出指定类名的Activity
     *
     * @param cls
     */
    public static void popActivityClass(Class<?> cls) {
        Iterator<Activity> it = activityStack.iterator();
        while (it.hasNext()) {
            Activity activity = it.next();
            if (activity.getClass().equals(cls)) {
                activity.finish();
                it.remove();
            }
        }
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        if (activityStack.search(activity) != 1) {
            activityStack.push(activity);
        }
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {

    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        activityStack.pop();
    }
}
