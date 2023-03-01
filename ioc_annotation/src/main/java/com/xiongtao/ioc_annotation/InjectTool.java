package com.xiongtao.ioc_annotation;

import android.util.Log;
import android.view.View;

import com.xiongtao.ioc_annotation.annotation.BindView;
import com.xiongtao.ioc_annotation.annotation.Click;
import com.xiongtao.ioc_annotation.annotation.ContentView;
import com.xiongtao.ioc_annotation.annotation_common.OnBaseCommon;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:
 * @Author: xiongtao
 * @Date: 2023-02-28 15:09
 */
public class InjectTool {

    private static final String TAG = InjectTool.class.getSimpleName();

    public static void inject(Object object){
        injectSetContentView(object);
        injectBindView(object);
        injectClick(object); // 只处理点击事件

        // >>>>>>>>>>>>>>>>>>>>> 下面是 兼容版本的事件代码
        injectEvent(object);
    }




    /**
     * 把布局绑定到 Activity中去
     * @param object MainActivity 的 this
     */
    private static void injectSetContentView(Object object) {
        Class<?> mMainActivityClass = object.getClass();
        // 获取 @ContentView 注解
        ContentView mContentView = mMainActivityClass.getAnnotation(ContentView.class);

        if(mContentView == null){
            Log.d(TAG, "ContentView is null ");
            return; // 全部结束
        }
        // 获取 R.layout.activity_main
        int layoutID = mContentView.value();
        // 反射执行 setContentView(layoutID == R.layout.activity_main);
        try {
            Method setContentViewMethod = mMainActivityClass.getMethod("setContentView", int.class);
            // 通过 Method 执行 setContentView 函数
            setContentViewMethod.invoke(object,layoutID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 把布局控件到 Activity中去
     * @param object MainActivity 的 this
     */
    private static void injectBindView(Object object) {
        Class<?> mMainActivityClass = object.getClass();
        // mMainActivityClass.getFields(); // 1  2  public
        Field[] fields = mMainActivityClass.getDeclaredFields();// 私有的 公开的 都可以

        for (Field field : fields) {
            field.setAccessible(true);// 让JVM不要去管 private 修饰的
            // 只关心 BindVIew注解的 字段，其他的不管
            BindView bindView = field.getAnnotation(BindView.class);
            if (bindView == null) {
                Log.d(TAG, "BindView is null");
                continue; // 结束本次，继续下一次
            }

            // 代表一定有 BindView 注解的
            // 获取 R.id.bt_t2 == viewID
            int viewId = bindView.value();

            try {
                // 反射 1 findViewById(viewID == R.id.bt_t2)
                Method findViewByIdMethod = mMainActivityClass.getMethod("findViewById", int.class);
                Object resultView = findViewByIdMethod.invoke(object, viewId);

                // 2 获取反射的值 赋值给 button1  button2  button3
                field.set(object,resultView);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    private static void injectClick(Object object) {
        Class<?> mMainActivityClass = object.getClass();
        Method[] declaredMethods = mMainActivityClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            Click click = declaredMethod.getAnnotation(Click.class);

            if (click == null) {
                Log.d(TAG, "BindView is null");
                continue; // 结束本次，继续下一次
            }

            // R.id.bt_test3 == viewID
            int viewID = click.value();

            try {
                // 1.findViewById 反射寻找 findViewById
                Method findViewByIdMethod = mMainActivityClass.getMethod("findViewById", int.class);

                // 2.findViewById 反射执行 的 成果拿到   resultView == button1的实例对象了
                Object resultView = findViewByIdMethod.invoke(object, viewID);

                // 3.findViewById 反射执行 的 成果拿到 .setOnClickListener { }
                View view = (View) resultView;

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 4.反射回调到 Click注解的show函数  最终一定要反射执行 show函数
                        //declaredMethod == 第三个函数 show函数，为什么，因为前面代码已经过滤了
                        try {
                            declaredMethod.invoke(object);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /** TODO 下面是 兼容版本的事件代码
     * 把布局事件到 Activity中去
     * @param object MainActivity 的 this
     */
    private static void injectEvent(Object object) {
        Class<?> mMainActivityClass = object.getClass();

        Method[] declaredMethods = mMainActivityClass.getDeclaredMethods();

        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);


            // 1  2  又回到了 之前XUtils的固定写法
            // OnClickCommon annotation = declaredMethod.getAnnotation(OnClickCommon.class);
            // 以前的方式，全部忘记

            Annotation[] annotations = declaredMethod.getAnnotations();

            for (Annotation annotation : annotations) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                OnBaseCommon onBaseCommon = annotationType.getAnnotation(OnBaseCommon.class);

                if (null == onBaseCommon) {
                    Log.d(TAG, "OnBaseCommon is null");
                    continue; // 结束本次，继续下一次
                }

                // 终于找到了 此注解包含 OnBaseCommon
                // 获取事件三要数
                String setCommonListener = onBaseCommon.setCommonListener();
                Class setCommonObjectListener = onBaseCommon.setCommonObjectListener();
                String callbackMethod= onBaseCommon.callbackMethod(); // 感觉3在，多个方法下才有用

// 动态代理完成
                try {
                    // 由于上面无法明确 子注解   annotationType获取到子注解

                    // 获取 @OnClickCommon(R.id.bt_t1) value == R.id.bt_t1
                    Method valueMethod = annotationType.getDeclaredMethod("value");
                    valueMethod.setAccessible(true);
                    int value  = (int) valueMethod.invoke(annotation);


                    // 就是执行 findViewById 拿到 button1 == resultView
                    Method findViewByIdMethod = mMainActivityClass.getMethod("findViewById", int.class);
                    Object resultView = findViewByIdMethod.invoke(object, value);

                    // 现在不能这样干，固定   但是又要实现这个效果
                    /*View button1 = (View) resultView;
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                        }
                    });

                    button1.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            return false;
                        }
                    });*/

                    // button1.setOnClickListener(new OnClickList)
                    // button1.要素1(要素2);

                    //获取view 里面的setonclicklistyer(new OnClickListener)方法
                    // 再次启用反射  button1 class    setOnClickListener（事件三要数之一）   setCommonObjectListener（事件三要数之一）
                    Method mViewMethod = resultView.getClass().getMethod(setCommonListener, setCommonObjectListener);

                    // 动态代理 监听 第三个要素
                    Object proxy = Proxy.newProxyInstance(setCommonObjectListener.getClassLoader(), new Class[]{setCommonObjectListener}, new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            return declaredMethod.invoke(object, null);
                        }
                    });
                    // 事件三要素的 第三个 最终的事件消费  代理对象是代理的 setCommonObjectListener  对象
                    mViewMethod.invoke(resultView,proxy);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
