package club.chenlinghong.demo.zookeeper.w3cschool;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * @Author linghongchen
 * @Date 2019/11/25 9:14 下午
 * @Description 获取 znode 子节点
 **/
public class ZKGetChildren {

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
                List<String> children = zooKeeper.getChildren(ZKConstant.ZNODE_PATH, false);
                for (String item : children) {
                    System.out.println(item);
                }
            } else {
                System.out.println("node does not exists");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
