package top.abigtree.conf.sdk.db;

import lombok.Data;

/**
 * @author Shuxin Wang <shuxinwang662@gmail.com>
 * Created on 2023/10/7
 */

@Data
public abstract class DatabaseConfig {
    protected static String group;

    protected String host;

    protected int port;


}
