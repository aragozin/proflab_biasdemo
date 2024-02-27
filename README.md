Java sampling bias demo for "Java profilers" lab
================================================


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



