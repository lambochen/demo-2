package club.chenlinghong.demo.zookeeper.w3cschool;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Author linghongchen
 * @Date 2019/11/25 9:18 下午
 * @Description 删除节点
 **/
public class ZKDelete {

    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection connection;

    /**
     * 删除节点
     * @param path znode path
     */
    public static void delete(String path) throws KeeperException, InterruptedException {
        zooKeeper.delete(path, zooKeeper.exists(path, true).getVersion());
    }

    public static void main(String[] args) {
        try {
            connection = new ZookeeperConnection();
            zooKeeper = connection.connect(ZKConstant.HOST);
//            delete(ZKConstant.ZNODE_PATH);
            delete("/myZnode/children1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
