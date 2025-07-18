[[CKAD EXAM Trivia]]
[[Kubernetes]]
###### Why is CKAD important

- [ ] This will create a strong case for GOOD hike 
	- [ ] good impression in front of Himela/Vinay/Sathyabrata 
	- [ ] will help me with a EASY small talk for a 50k REFUND for PHONE

- [ ] Will free up my TIME to practice DSA questions
- [ ] Will get me back my 20K 


###### Revision 
Week 14th - 20th
- [ ] Let's finish Updates MODULE from KODEKLOUD

- [ ] ibrahimatay CKAD (https://github.com/ibrahimatay/CKAD-Exercises)
	- [ ] CKAD-Exercises-v1
	- [ ] Check THE answers I think I didnot answer most of them correctly! 
	- [ ] let's make notes in the form of FLASH Cards
	- [ ] You know at the END of KODEKLOUD course completion I should really ask NOTEBOOK LLM to aggregate the commands and questions depending on the TOPIC as per the KUBERNETES syllabus.
	- [ ] Reattempt this test again TOMORROW!
```
9:09: started 
9:51: Coffee Break
1Hr 15 mins but try completing 1HR 
11 questions
9 mins Q5
```

- [ ] dgkanatsios CKAD (https://github.com/dgkanatsios/CKAD-exercises)
	- [ ] 12 exercises!

- [ ] CKAD-Exercise-3

- [ ] [[Reddit - CKAD - Questions]]

- [ ] let's make RECAP notes along the WAY! 



Week 21st - 27th
- [ ] Let's give the Mock Exam 1 & 2 and Lightning Lab 1 & 2
- [ ] Let's give the two Mock Killer.SH sessions 

Week 27th - 27th



###### Flashcards 

***Run as ROOT :-***
```
securityContext:
	runAsUser: 0 
```

***Aggregating logs :-***
kubectl logs dev-pod-dind-878516 (POD_NAME) -c log-x (CONTAINER_NAME) | grep WARNING > /opt/dind-878516_logs.txt (LOG_FILE_NAME)

***Setting environment variables and labels as an imperative command :-***
* Create configmap 
k create configmap name --from-literal=key=value

* Create secret 
k create secret name --from-literal=key=value

***MB is written as Mi and GB as Gi***


###### Exams

[[CKAD-Exercise-v1]](https://github.com/ibrahimatay/CKAD-Exercises)
- [ ] till exercise-11!

```
let's go! - 30 mins --- 11 questions 
11:38 - 

Could solve 4 with making notes
```

- [ ] dgkanatsios CKAD (https://github.com/dgkanatsios/CKAD-exercises)
	- [ ] 12 exercises!

- [ ] CKAD-Exercise-3

- [ ] [[Reddit - CKAD - Questions]]


[[Lightning LAB 1]] 
- [x] attempted once 
- [ ] revise 
```

Topics covered in this LAB :- 
- [ ] Persistent Volume + CLaim + Mount volume to POD

- [ ] Network Policy to allow incoming and outgoing connections

- [ ] Add Commands and Arguments + Create configmap

- [ ] ROLLING UPDATES 

- [ ] Create a deployment which has 
	- [ ] port
	- [ ] CPU
	- [ ] configmap
	- [ ] volume 

```
[[Lightning LAB 2]] 
- [x] attempted once
- [ ] revise
```
Topics covered in this LAB :- 

- [ ] PROBEs related question
- [ ] CRON Job and a bunch of configurations related to the JOB
- [ ] Add secrets to the POD 
- [ ] Creating an ingress for the services
- [ ] Redirect LOGs to a file 

```

[[CKAD mock exam 2 - KodeKloud]] 
- [x] attempted once 
- [ ] revise 
```
Topics covered in this LAB :- 

```
[[CKAD mock exam 1 - KodeKloud]] 
- [x] attempted once 
- [ ] revise 
```
Topics covered in this LAB :- 

```



- [ ] **END GOAL :** Give Killer.sh DEMO sessions 
	- [ ] there are two of these. 
	- [ ] buy more if needed to gain confidence


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


