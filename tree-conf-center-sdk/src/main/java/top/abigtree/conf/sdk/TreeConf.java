package top.abigtree.conf.sdk;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author Shuxin Wang <shuxinwang662@gmail.com>
 * Created on 2023/10/7
 */
@Data
public class TreeConf {
    private static final Logger LOGGER = LoggerFactory.getLogger(TreeConf.class);

    private String serverAddr;

    private String userName;

    private String password;

    private long timeout = 3000;

    private static ConfigService configService;

    public void init() throws NacosException {
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        properties.put(PropertyKeyConst.USERNAME, userName);
        properties.put(PropertyKeyConst.PASSWORD, password);
        configService = NacosFactory.createConfigService(properties);
    }

    public String getConfig(String group, String dataId) throws NacosException {
        if (configService == null) {
            LOGGER.error("Config Service is null");
            throw new NacosException();
        }
        return configService.getConfig(dataId, group, timeout);
    }

    public void addListener(String group, String dataId, TreeConfListener listener) throws NacosException {
        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                listener.receiveConfigInfo(configInfo);
            }

            @Override
            public Executor getExecutor() {
                return listener.getExecutor();
            }
        });
    }

}
