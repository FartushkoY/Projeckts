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
            Range nextRange = ranges[i];
            if (currentRanges.to >= nextRange.from) {
                currentRanges.to = ranges[i].to;
            } else {
                result.add(currentRanges);
                currentRanges = nextRange;
            }
        }
        result.add(currentRanges);
        return result;
    }


    public static ArrayList<Range> mergeRangesRecursive(Range[] ranges) {
        ArrayList<Range> result = new ArrayList<>();
        if (ranges.length == 0) return result;
        return recursiveMethod(result, ranges, 0, 1);
    }

    private static ArrayList<Range> recursiveMethod(ArrayList<Range> result, Range[] ranges, int indCurrentRange, int indNextRange) {
        Range currentRange = ranges[indCurrentRange];
        if (indNextRange == ranges.length) {
            result.add(currentRange);
            return result;
        } else {
            Range nextRange = ranges[indNextRange];
            if (currentRange.to >= nextRange.from) {
                currentRange.to = nextRange.to;
                indNextRange++;
            } else {
                result.add(currentRange);
                indCurrentRange = indNextRange;
                indNextRange++;
            }
            return recursiveMethod(result, ranges, indCurrentRange, indNextRange);
        }
    }


    public static void main(String[] args) {
        System.out.println(mergeRangesIter(new Range[]{new Range(2, 6), new Range(7, 11), new Range(10, 13), new Range(17, 21)}));
        System.out.println(mergeRangesIter(new Range[]{new Range(2, 6), new Range(7, 11), new Range(10, 15), new Range(14, 21)}));


        System.out.println(mergeRangesRecursive(new Range[]{new Range(2, 6), new Range(7, 11), new Range(10, 13), new Range(17, 21)}));
        System.out.println(mergeRangesRecursive(new Range[]{new Range(2, 6), new Range(7, 11), new Range(10, 15), new Range(14, 21)}));
    }

}
