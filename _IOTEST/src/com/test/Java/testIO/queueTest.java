package com.test.Java.testIO;

class queueTest {
	queueTest aQueueTest ;
	queueTest queueTest;
	private int  maxSize;
	private long[] queArray;
	private int front;
	private int rear;
	private int nItems;
	public  queueTest(int s) {
		maxSize = s;
		queArray = new long[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}
	public void insert(long j) {
		if(rear == maxSize-1){
			rear = -1;
			}
			queArray[++rear] =  j;
			nItems++;
		
	}
	public long remove() {
		long temp=  queArray[front++];
		if(front == maxSize)
			{
			front =0;
			}
			nItems--;
		return temp;	
		
	}
	public long peekFront() {
		return queArray[front];
	}
	public boolean isEmpty() {
		return (nItems==0);
	}
	public boolean isFull() {
		return (nItems == maxSize);
	}
	public int size(){
		return nItems;
	}
}
class QueueApp{
	public static void main(String[] args) {
		queueTest queueTest = new queueTest(5);
		queueTest.insert(10);
		queueTest.insert(20);
		queueTest.insert(30);
		queueTest.insert(40);
		queueTest.remove();
		queueTest.remove();
		queueTest.remove();
		queueTest.insert(50);
		queueTest.insert(60);
		queueTest.insert(80);
		queueTest.insert(90);
		while(!queueTest.isEmpty()){
			long n = queueTest.remove();
			System.out.print(n);
			System.out.print(" ");
		}
		System.out.println(" ");
		
	}
	
}
