package de.telran.Algorithms.lesson05_28;

import java.util.ArrayList;

public class MergeRanges {
    public static class Range {
        public int from;
        public int to;

        @Override
        public String toString() {
            return "Range{" +
                    "from=" + from +
                    ", to=" + to +
                    '}';
        }

        public Range(int from, int to) {
            this.from = from;
            this.to = to;


        }
    }

    public static ArrayList<Range> mergeRangesIter(Range[] ranges) {
        ArrayList<Range> result = new ArrayList<>();
        if (ranges.length == 0) return result;

        Range currentRanges = ranges[0];
        for (int i = 1; i < ranges.length; i++) {
            Range nextRenge = ranges[i];
            if (currentRanges.to >= nextRenge.from) {
                currentRanges.to = ranges[i].to;

            } else {
                result.add(currentRanges);
                currentRanges = nextRenge;
            }

        }
        result.add(currentRanges);
        return result;
    }

//    public static ArrayList<Range> mergeRangesIter(Range[] ranges) {
//        ArrayList<Range> mergedRanges = new ArrayList<>();
//        if (ranges.length == 0) {
//            return mergedRanges;
//        }
//
//        Range currentRange = ranges[0];
//        for (int i = 1; i < ranges.length; i++) {
//            Range nextRange = ranges[i];
//            if (nextRange.from <= currentRange.to) {
//                currentRange.to = ranges[i].to;
//            } else {
//                mergedRanges.add(currentRange);
//                currentRange = nextRange;
//
//            }
//        }
//        mergedRanges.add(currentRange);
//
//        return mergedRanges;
//    }
    public static ArrayList<Range> mergeRangesRecursive(Range[] ranges) {
        return new ArrayList<Range>();
    }

    public static void main(String[] args) {
        System.out.println(mergeRangesIter(new Range[]{new Range(2, 6), new Range(7, 11), new Range(10, 13), new Range(17, 21)}));

        System.out.println(mergeRangesIter(new Range[]{new Range(2, 6), new Range(7, 11), new Range(10, 15), new Range(14, 21)}));
    }

}
