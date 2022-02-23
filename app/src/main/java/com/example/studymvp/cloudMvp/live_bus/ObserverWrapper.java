package com.example.studymvp.cloudMvp.live_bus;

import androidx.lifecycle.Observer;

/**
 * 自定义的一个观察者包装类
 *
 * @ClassName ObserverWrapper
 * @Author 史正龙
 * @date 2022.02.22 09:53
 */
public class ObserverWrapper<T> implements Observer<T> {
    private Observer<T> observer;
    private LiveEventData<T> liveData;

    public ObserverWrapper(Observer<T> observer, LiveEventData<T> liveData) {
        this.observer = observer;
        this.liveData = liveData;
        //mIsStartChangeData 可过滤掉liveData首次创建监听，之前的遗留的值
        liveData.setmIsStartChangeData();
    }

    @Override
    public void onChanged(T t) {
        if (liveData.ismIsStartChangeData()) {
            if (observer != null) {
                observer.onChanged(t);
            }
        }
    }
}
