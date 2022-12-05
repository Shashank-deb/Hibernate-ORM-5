package com.bsl.tester;

import java.util.Arrays;
import java.util.Scanner;

import org.hibernate.boot.model.naming.ImplicitCollectionTableNameSource;

public class Test {
	public static void main(String[] args) {
		 Scanner scanner=new Scanner(System.in);
		 int n=scanner.nextInt();
		 int []arr=new int[n];
		 for(int i=0;i<arr.length;i++) {
			 arr[i]=scanner.nextInt();
		 }
		 Arrays.sort(arr);
		 
		
		 System.out.println(arr[0]*arr[1]);
		 
		 
	}

}
