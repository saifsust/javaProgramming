package Heap;

import java.util.Collections;
import java.util.Random;

interface constant {
	public static int N = 1000;
}

public class maxHeap implements constant {

	private static void makeHeap(int node,int last) {

		//System.out.println("Okay Done");
		int left, right, child;
		left = Left(node);
		right = Right(node);
		int parents = Parents(node);
		int count = node;
		if (node > last)
			return;
		child = node;
		while (count>1 && array[child]>array[parents]) {
			count = Parents(count);
			if (IsGreater(array[child], array[count])) {
				swap(child, count);
				child=count;
				parents=Parents(count);
			}
		}
		makeHeap(left, last);
		makeHeap(right,last);

	}

	private static boolean IsGreater(int a, int b) {
		return a > b;
	}

	private static void swap(int node1, int node2) {
		int temp = array[node1];
		array[node1] = array[node2];
		array[node2] = temp;
	}

	private static int Parents(int node) {
		return Math.floorDiv(node, 2);
	}

	private static int Left(int node) {
		return node * 2;
	}

	private static int Right(int node) {
		return node * 2 + 1;
	}

	public static void main(String[] args) {
		int n = 10;
		for (int i = 1; i <= n; i++)
			System.out.print(i + "\t");
		System.out.println();
		for (int i = 1; i <= n; i++)
			array[i] = rand.nextInt(100);
		for (int i = 1; i <= n; i++)
			System.out.print(array[i] + "\t");
		System.out.println();
		makeHeap(1, n);

		for (int i = 1; i <= n; i++)
			System.out.print(array[i] + "\t");
		System.out.println();
	}

	private static Random rand = new Random();
	private static int[] array = new int[N];
	private static int[] arrayHeap = new int[N];
}
