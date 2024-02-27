Java sampling bias demo for "Java profilers" lab
================================================

Run `mvn compile` to compile classfiles.


AllocationTest demo
-------------------

    java -Xmx256m -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -cp target\classes AllocatioNTest


CryptoBench demo
----------------

    java -Xmx256m -cp target\classes CryptoBench

    java -Xmx256m -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -cp target\classes CryptoBench

    java -Xmx256m -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints -DtrackTime=true -cp target\classes CryptoBench

SJK demo
--------

Version 1 (slow)

    java -Xmx256m -cp bias-sjk-v1.jar;target/classes SjkBench # Windows verion

    java -Xmx256m -cp bias-sjk-v1.jar:target/classes SjkBench # Unix verion

Version 2 (fast)

    java -Xmx256m -cp bias-sjk-v2.jar;target/classes SjkBench # Windows verion

    java -Xmx256m -cp bias-sjk-v2.jar:target/classes SjkBench # Unix verion

