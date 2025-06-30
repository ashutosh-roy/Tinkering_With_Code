##### Replica Set (new) / Replication Controller (old) 

1. provides **High Availability** (in case of any pod crash) by running multiple instances of a single POD in the kubernetes cluster
2. Automatically increases the number of pods in the container by adding OR removing PODs depending on the LOAD 
3. ReplicaSet spans across **multiple NODEs** and can add PODs to any NODE. 


##### CODE 
![[Pasted image 20250225105459.png]]
![[Pasted image 20250224131751.png]]

___
##### Labels and Selectors

![[Pasted image 20250224151204.png]]

_____

