package club.chenlinghong.demo.zookeeper.w3cschool;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;

/**
 * @Author linghongchen
 * @Date 2019/11/25 9:10 下午
 * @Description set data
 **/
public class ZKSetData {

    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection connection;

    /**
     * 更新 znode 数据
     * @param path  znode path
     * @param data  新数据
     */
    public static void update(String path, byte[] data) throws KeeperException, InterruptedException {
        zooKeeper.setData(path, data, zooKeeper.exists(path, true).getVersion());
    }

    public static void main(String[] args) {
        byte[] data = "update".getBytes();

        try {
            connection = new ZookeeperConnection();
            zooKeeper = connection.connect(ZKConstant.HOST);
            update(ZKConstant.ZNODE_PATH, data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
