package club.chenlinghong.demo.zookeeper.w3cschool;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Author linghongchen
 * @Date 2019/11/25 8:33 下午
 * @Description ZK connection
 **/
public class ZookeeperConnection {

    /**
     * Zookeeper instance
     */
    private ZooKeeper zooKeeper;

    /**
     * session 超时时间
     */
    private final static int sessionTimeout = 5000;

    /**
     * 用于停止（等待）主进程，直到客户端和 Zookeeper 集群连接
     */
    final CountDownLatch connectedSignal = new CountDownLatch(1);

    /**
     * 连接 Zookeeper 集群
     *
     * @param host Zookeeper host
     * @return Zookeeper 实例对象
     * @throws IOException          创建 Zookeeper 实例对象时抛出
     * @throws InterruptedException CountDownLatch.await 抛出
     */
    public ZooKeeper connect(String host) throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(host, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    connectedSignal.countDown();
                }
            }
        });
        connectedSignal.await();
        return zooKeeper;
    }

    /**
     * 关闭 Zookeeper 连接
     *
     * @throws InterruptedException
     */
    public void close() throws InterruptedException {
        zooKeeper.close();
    }

}
