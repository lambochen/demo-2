package club.chenlinghong.demo.zookeeper.w3cschool;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Author linghongchen
 * @Date 2019/11/25 8:42 下午
 * @Description 创建 ZK node
 **/
public class ZKCreate {

    /**
     * Zookeeper 实例
     */
    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection zookeeperConnection;

    /**
     * 创建 ZK 节点
     *
     * @param path znode path
     * @param data znode data
     */
    public static void create(String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.create(path, data, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    public static void main(String[] args) {

        // data
        byte[] data = ZKConstant.ZNODE_DATA.getBytes();

        try {
            zookeeperConnection = new ZookeeperConnection();
            zooKeeper = zookeeperConnection.connect(ZKConstant.HOST);
            // create znode
            create(ZKConstant.ZNODE_PATH, data);
            // close connection
            zookeeperConnection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
