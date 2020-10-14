package algorithm_1;

import java.util.*;
import java.io.*;

class Ant {

	Ant() {
		this.name = "name";
		this.speedMSec = 10.5;
		this.weightInGramm = 1.5;
	}

	Ant(String name, double speedMSec, double weightInGramm) {
		this.name = name;
		this.speedMSec = speedMSec;
		this.weightInGramm = weightInGramm;
	}

	public String name;
	public double speedMSec;
	public double weightInGramm;

	public void info() {
		System.out.println("Name: " + this.name);
		System.out.println("SpeedMSec: " + this.speedMSec);
		System.out.println("WeightInGramm: " + this.weightInGramm);
	}
}

class AntCollection {

	AntCollection() {

		n = 10;

		for (int i = 0; i < n; i++) {
			antCollection[i] = new Ant();
			antCollection[i].weightInGramm = (1 + i) / 2;
			antCollection[i].speedMSec = (1 + i) / 2;
		}

	}

	AntCollection(int n) {

		this.n = n;

		for (int i = 0; i < n; i++) {
			antCollection[i] = new Ant();
		}

	}

	public Ant[] antCollection = new Ant[10]; // container
	public int n;

	public void insert() {

		Ant temp = new Ant();

		for (int i = 1; i < antCollection.length; i++) {

			for (int j = i; (j > 0) && (antCollection[j - 1].speedMSec < antCollection[j].speedMSec); j--) {
				temp = antCollection[j];
				antCollection[j] = antCollection[j - 1];
				antCollection[j - 1] = temp;
			}
		}

	}

	public void qSort() {

		int l = 0;
		int h = antCollection.length - 1;

		quickSort(antCollection, l, h);

	}

	public void quickSort(Ant[] arr, int l, int h) {
		if (arr.length == 0) {
			return;
		}

		if (l >= h) {
			return;
		}

		int m = l + (h - l) / 2;
		Ant c = arr[m];

		int i = l, j = h;
		while (i <= j) {
			while (arr[i].weightInGramm > c.weightInGramm) {
				i++;
			}

			while (arr[j].weightInGramm < c.weightInGramm) {
				j--;
			}

			if (i <= j) {
				Ant temp = new Ant();
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		if (l < j) {
			quickSort(arr, l, j);
		}

		if (h > i) {
			quickSort(arr, i, h);
		}
	}

	public void print() {
		for (int i = 0; i < n; i++) {
			antCollection[i].info();
			System.out.println("------------");
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		// Ant ant = new Ant();
		// ant.info();
		AntCollection antCollection = new AntCollection();
		// antCollection.qSort();
		antCollection.insert();
		antCollection.print();

	}
}
