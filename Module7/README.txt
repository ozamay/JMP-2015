//Task #1

Serial Collector: 
java -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseSerialGC -cp PATH_TO_JAR_FILE(....JMP-2015\Module7\out\artifacts\Module7_jar\Module7.jar) com.epam.olukash.module7.Main


Parallel Collector:
java -Xms3m -Xmx18m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseParallelGC -cp PATH_TO_JAR_FILE(....JMP-2015\Module7\out\artifacts\Module7_jar\Module7.jar) com.epam.olukash.module7.Main


Parallel Old Collector:
java -Xms9m -Xmx18m -Xmn3m -XX:PermSize=40m -XX:MaxPermSize=40m -XX:+UseParallelOldGC -cp PATH_TO_JAR_FILE(....JMP-2015\Module7\out\artifacts\Module7_jar\Module7.jar) com.epam.olukash.module7.Main


Concurrent Mark Sweep (CMS) Collector  with 2 Parallel CMS Threads:
java -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2 -cp PATH_TO_JAR_FILE(....JMP-2015\Module7\out\artifacts\Module7_jar\Module7.jar) com.epam.olukash.module7.Main


G1 Garbage Collector: 
java -Xms4m -Xmx16m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -cp PATH_TO_JAR_FILE(....JMP-2015\Module7\out\artifacts\Module7_jar\Module7.jar) com.epam.olukash.module7.Main

