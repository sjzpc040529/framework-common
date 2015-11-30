package org.lzh.framework.common.util;

import com.github.zkclient.ZkClient;
import org.apache.zookeeper.data.Stat;

import java.util.Date;

/**
 * @Description: 创建序列号
 * @author: lizhaohua
 * @date: 15/11/30 下午12:53
 * @version: V1.0
 */
public class ZkGenerateSeqUtils {
    //提前创建好存储Seq的"/createSeq"结点 CreateMode.PERSISTENT
    public static final String SEQ_ZNODE = "/seq";
    private  ZkClient zkClient ;
    private String connectString ;
    private String sessionTimeout ;

    private String connectionTimeout ;
    public void setConnectionTimeout(String connectionTimeout){
        this.connectionTimeout = connectionTimeout;
    }
    public  void setConnectString(String connectString){
        this.connectString = connectString;
    }
    public void setSessionTimeout(String sessionTimeout){
        this.sessionTimeout  = sessionTimeout ;
    }
    public void init(){

    }
    public ZkGenerateSeqUtils(){

    }

    /**
     * 主要用户非spring注入使用
     * @param connectString
     * @param connectionTimeout
     * @param sessionTimeout
     */
    public ZkGenerateSeqUtils(String connectString,String connectionTimeout,String sessionTimeout){
        this.connectString = connectString ;
        this.connectionTimeout = connectionTimeout;
        this.sessionTimeout = sessionTimeout ;
    }

    /**
     * 节点
     * @param childZnode
     * @param max 最大长度
     * @param everyDay 是否每天重新计算
     * @returnn
     */
    public String generateZkSeq(String childZnode,int max,boolean everyDay){
        zkClient  = new ZkClient(connectString,Integer.valueOf(sessionTimeout),Integer.valueOf(connectionTimeout));
        String node =SEQ_ZNODE;
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, new byte[0]);
        }
        node = SEQ_ZNODE+childZnode;
        if (!zkClient.exists(node)) {
            zkClient.createPersistent(node, new byte[0]);

        }
        if(everyDay){
            node =SEQ_ZNODE+childZnode+StringUtils.dateFormat(new Date());
            if (!zkClient.exists(node)) {
                zkClient.createPersistent(node, new byte[0]);
                zkClient.delete(SEQ_ZNODE+childZnode+StringUtils.yesterdayFormate());

            }
        }

        Stat stat = zkClient.writeData(node, new byte[0], -1);

        int versionAsSeq = stat.getVersion();

        String seqString="00000000000000000000";
        seqString= seqString.substring(0,max-String.valueOf(versionAsSeq).length()).concat(String.valueOf(versionAsSeq));
        System.out.println("序列号："+seqString);
        zkClient.close();
        return seqString ;
    }



}
