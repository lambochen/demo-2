package club.chenlinghong.demo.zookeeper.w3cschool;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @Author linghongchen
 * @Date 2019/11/25 9:00 下午
 * @Description 获取数据
 **/
public class ZKGetData {

    private static ZooKeeper zooKeeper;

    private static ZookeeperConnection connection;

    /**
     * znode 是否存在
     */
    public static Stat exists(String path) throws KeeperException, InterruptedException {
        return zooKeeper.exists(path, true);
    }

    public static void main(String[] args) {
        final CountDownLatch connectedSignal = new CountDownLatch(1);

        try {
            connection = new ZookeeperConnection();
            zooKeeper = connection.connect(ZKConstant.HOST);

            Stat stat = exists(ZKConstant.ZNODE_PATH);

            if (stat != null) {
                byte[] data = zooKeeper.getData(ZKConstant.ZNODE_PATH, new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {
                        if (watchedEvent.getType() == Event.EventType.None) {
                            switch (watchedEvent.getState()) {
                                case Expired:
                                    connectedSignal.countDown();
                                    break;
                            }
                        } else {

                            try {
                                byte[] dataN = zooKeeper.getData(ZKConstant.ZNODE_PATH, false, null);
                                String dataStr = new String(dataN, "UTF-8");
                                System.out.println("znode data case 1: " + dataStr);
                                connectedSignal.countDown();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }, null);

                String dataStr = new String(data, "UTF-8");
                System.out.println("znode data case 2: " + dataStr);
                connectedSignal.await();
            } else {
                System.out.println("node does not exists");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
