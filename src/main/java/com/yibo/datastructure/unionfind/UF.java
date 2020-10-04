package com.yibo.datastructure.unionfind;

/**
 * @Author: huangyibo
 * @Date: 2020/10/117:41
 * @Description:
 */
public interface UF {

    int getSize();

    boolean isConnected(int p, int q);

    void unionElements(int p, int q);
}
