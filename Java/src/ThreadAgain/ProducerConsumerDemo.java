package ThreadAgain;
/*多线程多生产者要用while循环，但是用了while产生全部等待
 * notify()往往唤醒线程池中的第一个
 */
public class ProducerConsumerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Resource r = new Resource();
		
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(pro);
		Thread t3 = new Thread(con);
		Thread t4 = new Thread(con);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Resource {
	private String name;
	private int count = 1;
	private boolean flag = false;
	
	public synchronized void set(String name){
		while(flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		this.name = name+"--"+count++;
		System.out.println(Thread.currentThread().getName()+"...生产者..."+this.name);
		flag = true;
		this.notifyAll();
	}
	public synchronized void out(){
		while(!flag)
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(Thread.currentThread().getName()+"...消费者..."+this.name);
		flag = false;
		this.notify();
	}	
}

class Producer implements Runnable{
	private Resource res;
	Producer(Resource res){
		this.res = res;
	}
	public void run() {
		while(true){
			res.set("+商品+");
		}		
	}	
}
class Consumer implements Runnable{
	private Resource res;
	Consumer(Resource res){
		this.res = res;
	}
	public void run() {
		while(true){
			res.out();
		}		
	}	
}

























