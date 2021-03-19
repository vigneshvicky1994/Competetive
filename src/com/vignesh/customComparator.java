package com.vignesh;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class customComparator implements Comparator<int[]> {


    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
}
