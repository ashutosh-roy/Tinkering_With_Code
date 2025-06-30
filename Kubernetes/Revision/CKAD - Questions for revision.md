With `TECK30`, I got a discount of 30% and it costed me around 311$ (~26,810)

This EXAM link will be valid for 12 months! 
& the certification will be valid for 2 YEARs!

###### Browser Pre-requisites
If you experience any kind of issues please make sure all points here are complied with:

- **Browser**: only latest Chrome and latest Firefox are supported
- **Extensions**: disable ALL extensions/plugins and run in private mode
- **VPN/Proxy**: don't use a VPN/Proxy
- **Internet**: use a stable internet connection, with low usage by others
- **Tips**: Make sure to read the [**Tips**](https://killer.sh/attendee/506ef10e-94d2-436b-aad4-c13f486dfdf4/tips)

https://github.com/cncf/curriculum/blob/master/CKAD_Curriculum_v1.32.pdf

##### End Goal 
###### final LEG
Give Killer.sh DEMO sessions 
###### base building
```
We have to target and finish the CERTIFICATION by JUNE 2nd week anyhow! 
COZ OCT is the crucial TIME for HIKEs!
```

- [ ] ibrahimatay CKAD (https://github.com/ibrahimatay/CKAD-Exercises)
	- [ ] till exercise-11!

- [ ] dgkanatsios CKAD (https://github.com/dgkanatsios/CKAD-exercises)
	- [ ] 12 exercises!

- [ ] [[CKAD mock exam 2 - KodeKloud]]
- [ ] Let's aggregate the LIST OF WEAK topics after all these and let's practise those AGAIN

###### Attempted ONCE 
[[CKAD mock exam 1 - KodeKloud]]

###### Re-attempt for REVISION
- [ ] get more familiarised with KUBERNETES documentation.
	- [ ] We'll have access to that while appearing for EXAM! 


###### Weakness identified in these AREAs
- [ ] Roles Based Access Control!
- [ ] Practice docker basics (maybe whatever was used in README.md of `ffm-nsa-interface` )
- [ ] Persistent Volumes (REATTEMPT - KODEKLOUD session!)
- [ ] Storage classes (REATTEMPT - KODEKLOUD session!)

- [ ] Cluster IP related TOPIC
- [ ] Security Contexts
- [ ] Setting up ingress correctly 

- [ ] Setting environment variables ? 
	- [ ] let's refer documentation and try solving the UNKNOWN questions for a better brainstorming!


##### KodeKloud Hands ON Sessions 
>While revising the PROBLEMs, let's use the KUBERNETES documentation again and again to build the muscle memory to search! 

###### 5) Services and Networking
Network Policies 
- [ ] take connectivity test related answers with priority! 
###### 4) POD Design 
###### 3) MultiContainer PODs
###### 2) Configuration

- [x] ***Commands and arguments***
1) Add command to execute at the startup of the pod `ubuntu-sleeper`?
2) How to pass a runtime parameter to `Dockerfile` ?
3) 
###### 1) Core concepts
- [x] ***Pods***
1) Create a new pod with the `nginx` image. (answer in both imperative and declarative way)
```
k run pod POD_NAME --image=nginx -n WHATEVER___NAMESPACE
apiVersion: v1
kind: Pod
metadata:
  name: Pod_Name
spec: 
  container: (this can be a list of objects hence `-` before the name)
    - name: nginx
      image: nginx
```

2) What is the image used to create the new pods?
3) What does the `READY` section indicate? 
4) ![[Pasted image 20250510102924.png]]
5) ![[Pasted image 20250510103620.png]]

- [x] ***ReplicaSets***
1) Write a replica-set
2) What image was used to create POD & what is the startup logs of the POD
3) Steps to fix docker image in replicaset?
4) To scale UP pods, we can increase replica COUNT in replicaSet
5) 
![[Pasted image 20250510104518.png]]
- [x] ***Deployments***
2) Create a deployment with 
Name: `httpd-frontend`;  
Replicas: `3`;  
Image: `httpd:2.4-alpine`

- [x] Namespace
1) Which namespace has blue pod in it ? 
2) 
![[Pasted image 20250507081843.png]]

3) 
![[Pasted image 20250507082616.png]]

- [x] ***Imperative Commands***

1) Deploy a pod named `nginx-pod` using the `nginx:alpine` image.
Use imperative commands only.

2) Deploy a `redis` pod using the `redis:alpine` image with the labels set to `tier=db`.

3) Create a service `redis-service` to expose the `redis` application within the cluster on port `6379`.

4) Create a pod called `httpd` using the image `httpd:alpine` in the default namespace. Next, create a service of type `ClusterIP` by the same name `(httpd)`. The target port for the service should be `80`.


