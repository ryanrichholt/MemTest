package MemTest;
import java.util.Scanner;

public class Main {
    public static void checkHeapSize() {
        long heapSize = Runtime.getRuntime().totalMemory();

        // Get maximum size of heap in bytes. The heap cannot
        // grow beyond this size. Any attempt will result in an
        // OutOfMemoryException.
        long heapMaxSize = Runtime.getRuntime().maxMemory();

        // Get amount of free memory within the heap in bytes.
        // This size will increase after garbage collection and
        // decrease as new objects are created.
        long heapFreeSize = Runtime.getRuntime().freeMemory();

        System.out.println("heapsize: " + formatSize(heapSize));
        System.out.println("heapmaxsize: " + formatSize(heapMaxSize));
        System.out.println("heapFreesize: " + formatSize(heapFreeSize));

    }

    public static String formatSize(long v) {
        if (v < 1024) return v + " B";
        int z = (63 - Long.numberOfLeadingZeros(v)) / 10;
        return String.format("%.1f %sB", (double)v / (1L << (z*10)), " KMGTPE".charAt(z));
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Tool for testing out -Xm argument behavior.");
            System.out.println("Usage: \"java -jar MemTest.jar <length>\"");
            System.exit(1);
        }

        Integer sizeMB = Integer.parseInt(args[0]);

        int[] data = new int[sizeMB * (1024 * 1024)];
        System.out.println("Initialized array of size: " + data.length);

        int predSize = 32 + 4 * data.length;
        int predSizeMb = predSize / (1024 * 1024);
        System.out.println("Predicted array memory usage (32 + 4n): " + predSize);
        System.out.println("Predicted array memory usage (MB): " + predSizeMb);
        
        checkHeapSize();

        Scanner reader = new Scanner(System.in);
        System.out.println("Press enter to exit.");
        reader.nextLine();
        reader.close();

    }
}
