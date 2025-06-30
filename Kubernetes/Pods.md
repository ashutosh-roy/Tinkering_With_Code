
Simplest Setup for Kubernetes is 
Single Cluster
Single NODE 
Single POD (running a single DOCKER container which runs our application)

And if the user base is increasing we can scale up which means **adding more PODs**

And to scale down we can delete these PODs
_____
#### MultiContainer PODs 

A backend java application can run alongside a logging container collects logs from the main application container (**using SideCar Pattern**)

_____
#### Helper Containers 
These maintain a 1-1 relation with the container.