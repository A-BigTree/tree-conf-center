package top.abigtree.conf.sdk;

import java.util.concurrent.Executor;

/**
 * @author Shuxin Wang <shuxinwang662@gmail.com>
 * Created on 2023/10/7
 */
interface TreeConfListener {
    void receiveConfigInfo(String configInfo);

    Executor getExecutor();
}
