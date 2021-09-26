## Samples on what's new in Java 17

Please note that this a comparison with Java 11. So, in the examples `before()` 
means the way till java 11. These features were added over the period of time from version 12 to final LTS version 17.

### Other notable changes

* Concurrent Mark Sweep (CMS) Garbage Collector (marked deprecated in java 9) has been removed.
* New Z Garbage Collector.
* Nashorn Javascript Engine removed.
* JDK 17 removes the experimental Java-based ahead-of-time (AOT) and just-in-time (JIT) compiler. 
  AOT and JIT were introduced in JDK 9 and 10, but there has been little use. And there is considerable maintenance cost.
  Developers who wish to use the Graal compiler for either AOT or JIT compilation can use GraalVM.
