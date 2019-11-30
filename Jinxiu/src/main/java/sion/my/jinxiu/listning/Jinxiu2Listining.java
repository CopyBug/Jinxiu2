package sion.my.jinxiu.listning;

/**
 * 作者： 梁浩文, 日期： 2019/10/12.
 * 让代码更加美观
 */
public interface Jinxiu2Listining<T> {
    void SuccessRequest(T t);
    void FailRequest(String throwable);
}
