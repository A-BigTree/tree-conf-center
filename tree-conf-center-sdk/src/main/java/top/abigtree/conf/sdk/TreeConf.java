package top.abigtree.conf.sdk;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.Data;

import java.util.Properties;

/**
 * @author Shuxin Wang <shuxinwang662@gmail.com>
 * Created on 2023/10/7
 */
@Data
public class TreeConf {
    private String serverAddr;

    private String userName;

    private String password;

    private long timeout;

    private static ConfigService configService;

    public void init() throws NacosException {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        properties.put(PropertyKeyConst.USERNAME, userName);
        properties.put(PropertyKeyConst.PASSWORD, password);
        configService = NacosFactory.createConfigService(properties);
    }

    public String getConfig(String group, String dataId) throws NacosException {
        return configService.getConfig(dataId, group, timeout);
    }

}
