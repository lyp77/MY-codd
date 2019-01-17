package com.test.Java.testIO;

import java.awt.DisplayMode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.IIOException;
import javax.swing.text.AbstractDocument.BranchElement;

public class mergeTest {
	public static void main(String[] args) {
		int[] A = {23,47,81,55};
		int[] B = {7,14,39,55,62,74};
		int[] C =new int[10];
		int b= B.length;
		int a= A.length;
		merge(A,a,B,b,C);
		Display(A, a);
		Display(B, b);
		Display(C,10);
		
	}

	private static void Display(int[] c, int a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a;i++){
			System.out.print(c[i]+"  ");
	}
		System.out.println("");
	}

	private static void merge(int[] a1, int a2, int[] b1, int b2, int[] c1) {
		// TODO Auto-generated method stub
	int a= 0,b=0,c=0;
	while(a<a2&&b<b2){
		if(a1[a]<b1[b]){
			c1[c++] = a1[a++];
		}else{
		c1[c++] = b1[b++];	
		}
	}
	while(a<a2){
		c1[c++] = a1[a++];
	}
	while(b<b2){
		c1[c++] = b1[b++];
	}
	}



}
