package com.example.studymvp.cloudMvp.live_bus;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * @ClassName LiveEventData
 * @Author 史正龙
 * @date 2022.02.22 09:43
 */
public class LiveEventData<T> extends MutableLiveData<T> {
    //在添加observe的时候，同一个界面对应的一个事件只能注册一次
    //自己添加逻辑定制
    private String mEventType;

    /**
     * 首次注册的时候，判断是否需要当前liveData最新数据
     */
    private boolean mNeedCurrentDataWhenFirstObserve;

    public LiveEventData(String eventType) {
        mEventType = eventType;
    }

    /**
     * 手动触发添加才会更新
     */
    private boolean mIsStartChangeData = false;

    @Override
    public void setValue(T value) {
        mIsStartChangeData = true;
        super.setValue(value);
    }

    @Override
    public void postValue(T value) {
        mIsStartChangeData = true;
        super.postValue(value);
    }

    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        super.observe(owner, observer);
    }

    @Override
    public void observeForever(@NonNull Observer<? super T> observer) {
        super.observeForever(observer);
    }

    public void setmNeedCurrentDataWhenFirstObserve(boolean mNeedCurrentDataWhenFirstObserve) {
        this.mNeedCurrentDataWhenFirstObserve = mNeedCurrentDataWhenFirstObserve;
    }

    public String getmEventType() {
        return mEventType;
    }

    public void setmEventType(String mEventType) {
        this.mEventType = mEventType;
    }

    public boolean ismNeedCurrentDataWhenFirstObserve() {
        return mNeedCurrentDataWhenFirstObserve;
    }

    public boolean ismIsStartChangeData() {
        return mIsStartChangeData;
    }

    /**
     * 过滤LiveData首次创建时之前遗留的值
     */
    public void setmIsStartChangeData() {
        this.mIsStartChangeData = mNeedCurrentDataWhenFirstObserve;
    }
}
