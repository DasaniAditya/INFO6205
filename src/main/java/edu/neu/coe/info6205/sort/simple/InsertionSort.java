/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.simple;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Benchmark_Timer;
import edu.neu.coe.info6205.util.Config;
import edu.neu.coe.info6205.util.Timer;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort() {
        this(new BaseHelper<>(DESCRIPTION));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        final Helper<X> helper = getHelper();

        for (int i = from; i < to; i++) { 
     	   for ( int j = i; j > 0 && (helper.compare(xs[j-1], xs[j])) > 0; j--)
     	   {
     	       helper.swap(xs, j-1, j);
     	   }
     }
    }
    /**
     * This is used by unit tests.
     *
     * @param ys  the array to be sorted.
     * @param <Y> the underlying element type.
     */
    public static <Y extends Comparable<Y>> void mutatingInsertionSort(Y[] ys) {
        new InsertionSort<Y>().mutatingSort(ys);
    }

    public static final String DESCRIPTION = "Insertion sort";
    
    
public static void main(String[] args) {

	// Random number generator
	Random r = new Random();

	//Loop to set Number of Elements and doubling
	for(int n=500;n<=32000;n=n*2) {
	
	//declaring 4 arrays
	Integer array1[]=new Integer[n];
	Integer array2[]=new Integer[n];
	Integer array3[]=new Integer[n];
	Integer array4[]=new Integer[n];

	//storing random arrays in all the 4 arrays
	for(int m=0;m<n;m++) {
		array1[m] = r.nextInt(1000-1) + 1;	
		array2[m] = r.nextInt(1000-1) + 1;	
		array3[m] = r.nextInt(1000-1) + 1;	
		array4[m] = r.nextInt(1000-1) + 1;	
	}
	
	//for ordered elements
	Arrays.sort(array2);
	
	//for reverse elements
	Arrays.sort(array3, Collections.reverseOrder());
	
	//for partially sorted elements
	Arrays.sort(array4,0,n/2);
	
	
	InsertionSort<Integer> srt=new InsertionSort<>();

	
	Benchmark_Timer<Integer[]> benchmark = new Benchmark_Timer<Integer[]>("Lists",(x)->srt.sort(x,true));
	
	//storing values of timer for every type of array
	double timer1=benchmark.run(array1, 3);
	double timer2=benchmark.run(array2, 3);
	double timer3=benchmark.run(array3, 3);
	double timer4=benchmark.run(array4, 3);
	
	System.out.println(" ");
	System.out.println(timer1+" -> random array of " +n +" elements" );
	System.out.println(timer2+" -> ordered array of " +n +" elements");
	System.out.println(timer3+" -> reverse array of " +n +" elements");
	System.out.println(timer4+" -> partially order array of " +n +" elements");
	System.out.println(" ");
	
	}
}
}

