package person.hwj.Test.jedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.Jedis;

@Service
public class RedisOperation {
    @Autowired
    private Jedis jedis;

    public long save() {

        JedisTestThread[] threads = new JedisTestThread[20];

        for (int i = 0; i < 20; i++) {
            JedisTestThread jedisTestThread = new JedisTestThread(jedis);
            threads[i] = jedisTestThread;
        }
        for (int i = 0; i < 20; i++) {
            JedisTestThread jedisTestThread = threads[i];
            jedisTestThread.run();
        }
        // try {
        // Thread.sleep(10000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        return System.currentTimeMillis();
    }
}


class JedisTestThread extends Thread {
    private Jedis jedis;

    // public JedisTestThread() {}

    public JedisTestThread(Jedis jedis) {
        super();
        this.jedis = jedis;
    }

    @Override
    public void run() {
        // try {
        // Thread.sleep(1000);
        // } catch (InterruptedException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        jedis.set("test" + System.currentTimeMillis(), "" + System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
    }

}
