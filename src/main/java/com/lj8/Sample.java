package com.lj8;

import java.util.stream.IntStream;

/**
 * Created by halfont on 11/10/2016.
 */
public class Sample {
    public static boolean isPrime( int number ){
        //boolean divisble = false;

        //for( int i = 2; i < number; i++){
        //    if(number % i == 0 ){
        //        divisble = true;
        //        break;
        //    }
        //}

        //return number < 1 && !divisble;

        return number > 1 &&
            IntStream.range(2, number)
                      .noneMatch(i ->number % i == 0 );
    }

}
