package com.jk.mvpdemo.mvp4.base;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author JK_Liu
 * @description:
 * @date :2020/10/8 21:20
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter {

    /**
     * 强引用
     */
//    protected V mView;

    /**
     * 软引用
     * 软引用在内存降到不足的情况下，GC就会进行优先回收释放那些以软引用方式引用的对象。
     * 一定程度上去避免内存溢出（OOM）。
     */
    private SoftReference<IBaseView> mReferenceView;

    /**
     * 动态代理（省去判空操作）
     * @param view
     */
    private V mProxyView;


    @SuppressWarnings("unchecked")
    @Override
    public void attach(IBaseView view) {
//        mView = (V) view;
        mReferenceView = new SoftReference<>(view);

        /**
         * 动态代理完全就可以做到统一的空类型判断，
         *使用动态代理之后，我们在 Presenter 的实现类中就不需要做 View 层的空类型判断了，
         * 这样既节省了代码，虽然没有多少代码，但是写起来还是很烦的，
         * 又让我们的代码变得更加优雅。
         */
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (mReferenceView == null || mReferenceView.get() == null) {
                    return null;
                }
                return method.invoke(mReferenceView.get(), objects);
            }
        });
    }

    /**
     * 提供了 getView() 方法给 P 层调用，
     * 父类 View 变量进行私有化，
     * 防止子类对其进行更改造成的其他错误。
     * @return
     */
    @SuppressWarnings("unchecked")
    public V getView() {
//        return (V) mReferenceView.get();
        return mProxyView;
    }

    @Override
    public void detach() {
//        mView = null;
        mReferenceView.clear();
        mReferenceView = null;
    }
}
