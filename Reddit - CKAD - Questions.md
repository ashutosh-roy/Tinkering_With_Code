
1. You rolled out a new pod (Pod A). You need to edit Pod A to allow ingress requests only from Pod B and C. Similarly, Pod A is allowed to send requests (egress) only to Pod B and C. Note: There are a few network policies already existing in the k8s cluster. However, you're NOT allowed to create/update/delete a new/existing netpol.
    
2. create cronjob configure to run every 30 minutes: need to change these - startingDeadlineSeconds-successfulJobsHistoryLimit- failedJobsHistoryLimit.
    
3. here is a deployment coded in 1.23 version of k8 api deprecation need to update it to 1.9+
    
4. create deployment Edit image Set replicas Undo version Save image and check pod status and write logs to output.
    
5. There's a question gives you a deployment using image v1 and it will ask you to do a canary deployment with these requirements:
The new deployment will have a new name and using image v2.
The total of pods will be 8 or 10 pods - I don't remember exactly.
80% of traffic will route to the v1 deployment and 20% of traffic will route to the v2
Then there was some basic question like adding probe, edit deployment etc.


6) ![[Pasted image 20250703162716.png]]

7) Task: Example  
Pod ckad00018-newpod in the ckad00018 namespace to use a NetworkPolicy allowing the Pod to send and receive traffic only to and from the pods web and db

POD → web -->has **label** → app:web

POD —> db -->has **label** → app:db

POD → ckad00018-newpod → has **label** → app: newpod

**Note:** you must not create, modify, delete any network policy while working on this task.You may use only existing network policies.


8) 