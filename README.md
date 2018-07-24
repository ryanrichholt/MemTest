Tool for testing out -Xm argument behavior.
Usage: `java -jar MemTest.jar <length>`

This will generate an array of size <length> * 1 million, then print out memory usage stats.

```
$ java -jar MemTest.jar 10
Initialized array of size: 10485760
Predicted array memory usage (32 + 4n): 41943072
Predicted array memory usage (MB): 40
heapsize: 360.5 MB
heapmaxsize: 5.2 GB
heapFreesize: 316.7 MB
Press enter to exit.
```
