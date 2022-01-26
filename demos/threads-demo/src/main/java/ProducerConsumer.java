import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ProducerConsumer {
    private final Queue<String> buffer;
    private final boolean running;
    private final int MAX_SIZE;

    public ProducerConsumer(int maxSize) {
        MAX_SIZE = maxSize;
        running = true;
        buffer = new ConcurrentLinkedDeque<>();
    }

    public void produce() throws InterruptedException {
        while(running) {

            synchronized (this) {

                while (buffer.size() >= MAX_SIZE) {
                    wait();
                }

                String rand = Integer.toString((int) (Math.random() * 100));
                buffer.add(rand);
                System.out.println("Producing...  " + rand);

                notify();
                Thread.sleep(500);


            }
        }
    }

    public void consume() throws InterruptedException {
        while(running) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }

                String str = buffer.poll();
                System.out.println("Consuming...  " + str + "\n");

                notify();
                Thread.sleep(500);
            }
        }
    }
}
