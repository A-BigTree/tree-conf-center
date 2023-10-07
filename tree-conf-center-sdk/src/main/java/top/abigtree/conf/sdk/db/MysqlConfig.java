package top.abigtree.conf.sdk.db;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Shuxin Wang <shuxinwang662@gmail.com>
 * Created on 2023/10/7
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class MysqlConfig extends DatabaseConfig{


    static {
        group = "MYSQL";
    }
}
