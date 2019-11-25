package club.chenlinghong.demo.zookeeper.w3cschool;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @Author linghongchen
 * @Date 2019/11/25 8:53 下午
 * @Description 校验 ZNode 是否存在
 **/
public class ZKExists {


    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection connection;

    /**
     * ZNode 是否存在
     *
     * @param path znode path
     * @return 返回 znode 元数据
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static Stat exists(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, true);
    }

    public static void main(String[] args) {
        try {
            connection = new ZookeeperConnection();
            zooKeeper = connection.connect(ZKConstant.HOST);
            Stat stat = exists(ZKConstant.ZNODE_PATH);

            if (stat != null) {
                System.out.println("znode 存在，并且 version = " + stat.getVersion());
            } else {
                System.out.println("znode does not exists");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
