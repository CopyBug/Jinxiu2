package sion.my.jinxiu.listning;

/**
 * 作者： 梁浩文, 日期： 2019/9/24.
 * 让代码更加美观
 */
public interface JinxiuListning<T> {
    void SuccessRequest(T t);
     void FailRequest(Throwable throwable);
    void OtherError(String error);

}
