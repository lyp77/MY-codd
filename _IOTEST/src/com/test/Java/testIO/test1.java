package com.test.Java.testIO;

class test1 {
	 private long[] theArray;
	 private int nElems;
	
	public test1(int max) {
		theArray = new long[max];
		nElems = 0;
	}
	public void insert(long value) {
		theArray[nElems] = value;
		nElems++;
	}
	public void display() {
		System.out.println("A=");
		for(int i=0;i<nElems;i++){
			System.out.println(theArray[i]+" ");
			System.out.println(" ");
		}
	}
	public void quickSort() {
		requickSort(0,nElems-1);
	}
	public void requickSort(int i, int j) {
		if(j-i<=0){
			return;
		}else{
			long pivot = theArray[j];
			int partition = partitionlt(i,j,pivot);
			requickSort(i,partition-1);
			requickSort(partition+1, j);
		}
		
	}
	private int partitionlt(int i, int j, long pivot) {
			int iPtr = i-1;
			int jPtr = j;
			while(true){
				while(theArray[++iPtr]<pivot)
				;
				while(jPtr>0&&theArray[--jPtr]>pivot)
					;
				if(iPtr>=jPtr)
					break;
				else
					swap(iPtr,jPtr);
			}
			swap(iPtr,jPtr);
			return iPtr;
	}
	public void swap(int iPtr, int jPtr) {
			long temp = theArray[jPtr];
			theArray[jPtr] = theArray[iPtr];
			theArray[iPtr] = temp;
		
	}
	
	}
class test2{
	public static void main(String[] args) {
		int maxSize = 16;
		test1 arr;
		arr = new test1(maxSize);
		for(int i = 0;i>maxSize ; i++){
			long n = (int)(java.lang.Math.random()*99);
			arr.insert(n);
		}
		arr.display();
		arr.quickSort();
		arr.display();
		
		
		
	}
	
}