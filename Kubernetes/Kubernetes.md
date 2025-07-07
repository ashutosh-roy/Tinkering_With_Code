![[CKAD Manifestation.png]]

[[CKAD EXAM Trivia]]
[[CKAD - Questions for revision]]

######### **To Watch :-** 
TIPs for cracking CKAD exam?
https://youtu.be/tS2S926PriQ?si=fCVvKo8eEbrYoy5w

Utilising FICO learning pathway :- 
https://degreed.com/pathway/k95vo4j393/pathway?newWindow=true

##### Courses Referred :- 

1) **Kubernetes Basics** :- 
https://fico.udemy.com/course/learn-kubernetes/learn/lecture/14655916#overview


2) **Kubernetes Certified Application Developer**
https://fico.udemy.com/course/certified-kubernetes-application-developer/

[[Certified Kubernetes Application Developer (CKAD)]]
#### Kubernetes CKAD 
##### 1) Core Concepts 

####### ***Pods***
1) Create a new pod with the `nginx` image.

[[Imperative vs Declarative]]

>Learning the imperative way is equally important as in EXAMs you might not get enough time to write YAMLs

Imperative Way :- 
`k run pod ngnix-pod --image=nginx`
`k run redis --image=redis -n finance`


Declarative Way :- k apply -f nginx-pod.yaml

[[YAML Introduction]]
```
apiVersion: v1
kind: Pod
metadata:
	name: nginx-pod
spec:
	containers:
		- name: nginx
		  image: nginx
```

2) What is the image used to create the new pods?
You must look at one of the new pods in detail to figure this out.

`k describe pod pod-name`

3) What does the `READY` section indicate? 
`Running Containers in POD /Total Containers in POD`

4) ![[Pasted image 20250510102924.png]]
Run the command `kubectl describe pod newpods-<id>` and look at the `node` field.  
Alternatively run `kubectl get pods -o wide` and check for the node the pod is placed on.

5) ![[Pasted image 20250510103620.png]]
Update the pod-definition file and use `kubectl apply` command or use `kubectl edit pod redis` command.

####### ***ReplicaSets***
Replica sets is supposed to maintain the desired count of PODs even if ONE is down.

1) Write a replica-set :- 
![[Pasted image 20250510104518.png]]

```
apiVersion: apps/v1 (IMP)
kind: ReplicaSet
metadata:
  name: replicaset-1
spec:
  replicas: 2 (IMP)
  selector:
    matchLabels:
      tier: frontend (These labels SHOULD always be identical)
  template:
    metadata:
      labels:
        tier: frontend (These labels SHOULD always be identical)
    spec:
      containers:
      - name: nginx
        image: nginx
```

2) `k describe rs new-replica-set`
	
* gives us what image was used to create POD
* startup logs of the POD

`k get rs -o wide`
this gives you more details about the REPLICA-SET

To view pod logs 
* get pod name from above command
* do k get pod POD_NAME

3) Edit ReplicaSet to fix docker image

`k edit rs new-replica-set`
`k delete pods -l name=busybox-pod`
`k get pods --show-labels`

4) To scale UP pods, we can increase replica COUNT in replicaSet
`kubectl edit replicaset replicaset_NAME`

Issue is the 


###### ***Deployments***
![[Pasted image 20250511124722.png]]

**A deployment can be EXPOSED to the outside WORLD in this way :-**

- **ClusterIP** – Exposes the service on an internal IP in the cluster; accessible only within the cluster.
    
- **ExternalName** – Maps the service to an external DNS name without creating a proxy.
    
- **LoadBalancer** – Exposes the service externally using a cloud provider’s load balancer.
    
- **NodePort** – Exposes the service on each node’s IP at a static port; accessible from outside the cluster via NodeIP:NodePort.



**Command to create a deployment OR any other resource**

	`k create deployment --help`


>These are common questions in CKAD so we must practice accordingly 

Create a deployment with 
Name: `httpd-frontend`;  
Replicas: `3`;  
Image: `httpd:2.4-alpine`

`k create deployment httpd-frontend -r=3 --image=httpd:2.4-alpine -o=yaml > deploy.yaml`

**Other commands**
`k create deployment deployment_NAME`


`k edit deployment deployment_NAME`

```
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: deployment-1
spec:
  replicas: 2
  selector:
    matchLabels:
      name: busybox-pod
  template:
    metadata:
      labels:
        name: busybox-pod
    spec:
      containers:
      - name: busybox-container
        image: busybox
        command:
        - sh
        - "-c"
        - echo Hello Kubernetes! && sleep 3600
```


###### ***Namespaces***
`kubectl get pods --all-namespaces | grep blue`
this searches across all the namespaces
for this question :- 
![[Pasted image 20250507081332.png]]

>Good Question 1!

DNS means the target URL to invoke the service
1) k get svc -n marketing
2) Since `BLUE` & `db-service` are in the same namespace, we can use the service name to directly access the service.

![[Pasted image 20250507081843.png]]


>Good Question 2!


Now `BLUE` is in marketing namespace but `db-service` is in `dev` namespace.

Kubernetes services are accessible via DNS in the form:
`<service-name>.<namespace>.svc.cluster.local`

For this answer, it'll be `db-service.dev.svc.cluster.local`

![[Pasted image 20250507082616.png]]

- [x] ***Imperative Commands***

1) Deploy a pod named `nginx-pod` using the `nginx:alpine` image.
Use imperative commands only.

`k run nginx-pod --image=nginx:alpine`


2) Deploy a `redis` pod using the `redis:alpine` image with the labels set to `tier=db`.

`k run redis --image=redis:alpine -l tier=db`

3) Create a service `redis-service` to expose the `redis` application within the cluster on port `6379`.

`kubectl expose pod redis --port=6379 --target-port=6379 --name=redis-service --type=ClusterIP`

You don't always need to remember the command we can do this
`k create service --help`


4) Create a pod called `httpd` using the image `httpd:alpine` in the default namespace. Next, create a service of type `ClusterIP` by the same name `(httpd)`. The target port for the service should be `80`.

`kubectl run httpd --image=httpd:alpine --restart=Never`

`kubectl expose pod httpd --port=80 --target-port=80 --type=ClusterIP --name=httpd`


Let's try and complete ALL 
##### 2) Configuration

###### ***Commands and arguments***
Add command to execute at the startup of the pod `ubuntu-sleeper`?
```
apiVersion: v1
kind: Pod
metadata:
  name: ubuntu-sleeper-2
spec:
  containers:
    - name: ubuntu
      image: ubuntu
      command: ["sleep", "5000"] (this is the command)
  restartPolicy: Never
```


To pass a runtime parameter to `Dockerfile` :-
```
FROM python:3.6-alpine
RUN pip install flask
COPY . /opt/
EXPOSE 8080
WORKDIR /opt
ENTRYPOINT ["python", "app.py"] (this)
CMD ["--color", "red"] (AND this)
```
ENTRYPOINT and CMD is important! This translates to :- `python app.py --color red`


This is how we specify `command` & `args` in our YAML file.
```
apiVersion: v1 
kind: Pod 
metadata:
  name: webapp-green
  labels:
      name: webapp-green   
spec:
  containers:
  - name: simple-webapp
    image: kodekloud/webapp-color
    command: ["python", "app.py"]
    args: ["--color", "pink"]                               
```


###### ***ConfigMaps***

1) Update the environment variable on the POD to display a `green` background. Note: Delete and recreate the POD. Only make the necessary changes. Do not modify the name of the Pod.

For this, we can list and edit the PODs

2) List configmaps in the given namespace 
`k get configmaps -n default`

3) View the config map content
kubectl get configmap db-config -o yaml

4) ![[Pasted image 20250509222558.png]]


Imperative :
```
kubectl create configmap webapp-config-map --from-literal=APP_COLOR=darkblue --from-literal=APP_OTHER=disregard
```

Declarative:
`k apply -f webapp-config-map`
```
apiVersion: v1
kind: ConfigMap
metadata:
  name: webapp-config
data:
  APP_COLOR: "blue"
  APP_MODE: "production"
```

5) Update the environment variable on the POD to use only the `APP_COLOR` key from the newly created ConfigMap.
Note: Delete and recreate the POD. Only make the necessary changes. Do not modify the name of the Pod.

```
apiVersion: v1
kind: Pod
metadata:
  labels:
    name: webapp-color
  name: webapp-color
  namespace: default
spec:
  containers:
  - env:
    - name: APP_COLOR
      valueFrom:
       configMapKeyRef:
         name: webapp-config-map
         key: APP_COLOR
    image: kodekloud/webapp-color
    name: webapp-color
```

6) 

###### ***Secrets***
6) 
![[Pasted image 20250510183657.png]]

>answer :- type 

7) How many secrets are defined over here ??
![[Pasted image 20250510183600.png]]

9) How to create secrets ? 
![[Pasted image 20250510184342.png]]
Imperative :- 

```
kubectl create secret generic db-secret \
  --from-literal=DB_Host=sql01 \
  --from-literal=DB_User=root \
  --from-literal=DB_Password=password123
```

Declarative :- 

```

```

10) VVI question! I got stuck here badly 
![[Pasted image 20250510185803.png]]


```
apiVersion: v1
kind: Pod
metadata:
  name: webapp-pod
  labels:
    name: webapp-pod
spec:
  containers:
    - name: webapp
      image: kodekloud/simple-webapp-mysql
      envFrom: (THIS Section!)
        - secretRef:
            name: db-secret
```

###### ***Security Contexts***

`securityContext` in Kubernetes defines security settings for a Pod or
an individual container

It tells Kubernetes _how the container or Pod should run in terms of security_, like user ID, privileges, file system access, etc.

![[Pasted image 20250510203244.png]]

```
Run the command: `kubectl exec ubuntu-sleeper -- whoami` and check the user that is running the container.
```


![[Pasted image 20250510203452.png]]



![[Pasted image 20250510205157.png]]


![[Pasted image 20250510205656.png]]

```
apiVersion: v1
kind: Pod
metadata:
  name: mypod
spec:
  containers:
    - name: mycontainer
      image: ubuntu
      command: ["sleep", "3600"]
      securityContext:
	    runAsUser: 0 
        capabilities:
          add: ["SYS_TIME"]
```

![[Pasted image 20250510210709.png]]


####### ***Resource Limits***
This can be completed with the above knowledge but we should still be aware of the syntax

```
apiVersion: v1
kind: Pod
metadata:
  name: resource-limited-pod
spec:
  containers:
    - name: app-container
      image: nginx
      resources:
        requests:
          memory: "64Mi"
          cpu: "250m"
        limits:
          memory: "128Mi"
          cpu: "500m"
```

###### ***Service Account***
Was able to solve the existing questions with the above knowledge

1) `k get sa`
![[Pasted image 20250511123602.png]]
2) 
![[Pasted image 20250511125127.png]]

3) 
![[Pasted image 20250511131043.png]]


###### Which file inside the Kubernetes are TAINTs / TOLERATIONs/ NODE Affinity applied ? 

✅ Taints → Applied on Nodes
	•	You taint a node to repel pods unless they tolerate the taint.


✅ Tolerations → Defined in Pods (or Deployments)
	•	Tolerations are like “exceptions” that say:
“I’m okay with running on a node with this taint.”


✅ Node Affinity → Defined in Pods (or Deployments)
	•	Node affinity is used to attract pods to nodes with specific labels.

###### **Taints and Tolerations**

Taints are set to Nodes (they say "only special PODs allowed here")
Tolerations are set to PODs (they say "I am one of those special PODs allowed here")


==Practical Use Case: 
- You have GPU nodes and want **only GPU-specific workloads** on them.
    
- You taint the GPU node:
`kubectl taint nodes node1 special=true:NoSchedule`

* Only PODs which are able to tolerate that taint will be RUN.
```
apiVersion: v1
kind: Pod
metadata:
  name: tolerant-pod
spec:
  containers:
    - name: app
      image: nginx
  tolerations:
    - key: "special"
      operator: "Equal"
      value: "true"
      effect: "NoSchedule"
```

1) 
![[Pasted image 20250514072443.png]]

`k describe node node01` - with this we'll have a property 
`Taints:             <none>`

2) 
![[Pasted image 20250514072623.png]]

`kubectl taint nodes node1 special=true:NoSchedule`

3) 
###### ***Node Affinity*** 
1) ![[Pasted image 20250514093257.png]]

 Imperative :- `kubectl label node node01 color=blue`
 Declarative :- `kubectl edit node node01`
2) ![[Pasted image 20250514093750.png]]

`k create deployment blue --image=nginx --replicas=3`

==While setting up NodeAffinity let's keep this in mind :- 

- [ ] it can be set to PODs or DEPLOYMENTs 
- [ ] Till `matchExpressions` everything remains constant, 
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: blue
spec:
  replicas: 3
  selector:
    matchLabels:
      run: nginx
  template:
    metadata:
      labels:
        run: nginx
    spec:
      containers:
      - image: nginx
        imagePullPolicy: Always
        name: nginx
      affinity:
        nodeAffinity:
          requiredDuringSchedulingIgnoredDuringExecution:
            nodeSelectorTerms:
            - matchExpressions:
              - key: color
                operator: In
                values:
                - blue

```

- [ ] if there's a KEY value match to be added 

```
  - key: color
	operator: In
	values:
	- blue
```

- [ ] if there's a 



3) ![[Pasted image 20250514094005.png]]

```
---
apiVersion: apps/v1
kind: Deployment
metadata:
  name: blue
spec:
  replicas: 3
  selector:
    matchLabels:
      run: nginx
  template:
    metadata:
      labels:
        run: nginx
    spec:
      containers:
      - image: nginx
        imagePullPolicy: Always
        name: nginx
      affinity:
        nodeAffinity:
          requiredDuringSchedulingIgnoredDuringExecution:
            nodeSelectorTerms:
            - matchExpressions:
              - key: color
                operator: In
                values:
                - blue
```





- [ ] How many sessions left ? 
- [ ] What's the expected day of completion !? 
- [ ] 



##### 3) Multi-Container Pods
###### **Multi Container Pods** 

1) ![[Pasted image 20250514174219.png]]

`CMD : k get pods -o yaml`

2) ![[Pasted image 20250514174945.png]]

3) 
![[Pasted image 20250514175944.png]]

here this works :- 
`k exec -it app -c app -- /bin/sh`

==Basic Usage (Single Container Pod)
```bash
kubectl exec -it <pod-name> -- /bin/bash
```

If the container does not have bash, try using sh:

```bash
kubectl exec -it <pod-name> -- /bin/sh
```

==**For Multi-Container Pods**
```bash
kubectl exec -it <pod-name> -c <container-name> -- /bin/bash
```

4) ==GOOD Question
![[Pasted image 20250514180801.png]]


###### **Readiness Probes**
1) 
![[Pasted image 20250514183125.png]]


```bash

apiVersion: v1
kind: Pod
metadata:
  creationTimestamp: "2021-08-01T04:55:35Z"
  labels:
    name: simple-webapp
  name: simple-webapp-2
  namespace: default
spec:
  containers:
  - env:
    - name: APP_START_DELAY
      value: "80"
    image: kodekloud/webapp-delayed-start
    imagePullPolicy: Always
    name: simple-webapp
    ports:
    - containerPort: 8080
      protocol: TCP
    readinessProbe:
      httpGet:
        path: /ready
        port: 8080
```

2) ![[Pasted image 20250514184147.png]]

3) Answered this using the documentation! 
to reapply PODs use `k apply -f file_name.yaml --force`
![[Pasted image 20250514185626.png]]

###### **Logs**
1) ![[Pasted image 20250516091417.png]]


CMD - `k logs webapp-1`
`k logs POD_NAME`

###### **Monitoring**
1) ![[Pasted image 20250516091919.png]]


2) 
![[Pasted image 20250516092316.png]]

`k top node`


3) 
![[Pasted image 20250516092510.png]]

`kubectl top pod` - Run this command and identify the pod that uses the most Memory(bytes).



###### **Init Containers**
Description: init containers: specialized containers that run before app containers in a [Pod](https://kubernetes.io/docs/concepts/workloads/pods/). Init containers can contain utilities or setup scripts not present in an app image.

1) 
![[Pasted image 20250516094034.png]]


Check the `Reason` field for the initContainer in the `kubectl describe pod blue` command. This container was terminated after sleeping for 5 seconds.

2) 
![[Pasted image 20250516095003.png]]
```
apiVersion: v1
kind: Pod
metadata:
  name: red
  namespace: default
spec:
  containers:
  - command:
    - sh
    - -c
    - echo The app is running! && sleep 3600
    image: busybox:1.28
    name: red-container
  initContainers:
  - image: busybox
    name: red-initcontainer
    command: 
      - "sleep"
      - "20"
```



##### 4) POD Design

###### **labels and selectors**

1) ![[Pasted image 20250518162339.png]]

`kubectl get pods --selector env=dev`
`k get pods -o wide --show-labels`

2) ![[Pasted image 20250518162521.png]]


` k get pods --selector bu=finance`

3) 
![[Pasted image 20250518163434.png]]

`k get all --selector env=prod`

4) To apply multiple filters

`k get pods --selector env=prod,tier=frontend,bu=finance`


###### **RollingUpdates & Rollbacks**
`RollingUpdateStrategy:  25% max unavailable, 25% max surge`

🔹 maxUnavailable: 25%
At most 25% of the desired number of pods can be unavailable during the update.
•	If you have 4 replicas, then 1 pod (25% of 4) can be temporarily unavailable while updating.

🔹 maxSurge: 25%
Kubernetes can create up to 25% more pods than desired to speed up the rollout.
•	If you have 4 replicas, Kubernetes can create 1 extra pod (total 5 pods temporarily) during the rollout.

###### **Jobs and CronJobs**
1) ![[Pasted image 20250519120655.png]]


>kubectl create job throw-dice-job --image=kodekloud/throw-dice --dry-run=client -o yaml > throw-dice-job.yaml

|**Part**|**Explanation**|
|---|---|
|kubectl create job throw-dice-job|Create a Job resource named throw-dice-job|
|--image=kodecloud/throw-dice|Use the container image kodecloud/throw-dice|
|--dry-run=client|Don’t send the request to the Kubernetes API server; just simulate and generate output locally|
|-o yaml|Output the resource definition in YAML format|
|> throw-dice-pod.yaml|Save the YAML output into the file throw-dice-pod.yaml instead of printing it to the terminal|

`k describe jobs.batch throw-dice-job `

`k get jobs.batch `


2) ![[Pasted image 20250520101437.png]]


kubectl create cronjob hello-job \
  --image=busybox \
  --schedule="*/5 * * * *" \
  -- /bin/sh -c "echo Hello from CronJob"


##### 5) Service & Networking 

###### **Kubernetes Services**
| **Type**     | **1-Liner Difference**                                    | **Real-Life Example**                                                 | **Sample URL or Access Pattern**                                                                                    |
| ------------ | --------------------------------------------------------- | --------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- |
| ClusterIP    | Internal-only access within the cluster.                  | A **Spring Boot user-service** calls an internal **MongoDB service**. | http://mongo-service.default.svc.cluster.local:27017→ Follows the internal DNS: service.namespace.svc.cluster.local |
| NodePort     | Exposes service via a static port on each node’s IP.      | You’re testing a **Go API** on Minikube from your browser.            | http://<NodeIP>:<NodePort>e.g., http://192.168.99.100:30007                                                         |
| LoadBalancer | Provisions an external IP via a cloud load balancer.      | Your **React frontend** is publicly hosted via a K8s LoadBalancer.    | http://<ExternalIP> or mapped to http://myapp.example.come.g., http://34.93.187.101                                 |
| ExternalName | Points to an external DNS name without internal proxying. | An app in K8s calls a managed **PostgreSQL on RDS**.                  | https://mydb.rds.amazonaws.com→ No K8s-specific URL, just a normal FQDN                                             |

```
k get svc 
k describe svc
k edit svc 
these helped cover! 
```

###### **Network Policies** 
1) ![[Pasted image 20250520181653.png]]
```
k get networkpolicies.networking.k8s.io  (TAB can help you autocomplete things!)
```

***GOOD QUESTION*** --->
2) 
![[Pasted image 20250520183326.png]]

```

```


###### Note :- Ingress Networking - 1 & 2 are only 
###### **Ingress Networking - 1** 
📦 Real-world Examples:

🔹 Proxy (Forward Proxy):
	•	Used in corporate networks to control or log outbound traffic.
	•	Example: You configure your browser to go through a proxy server to access websites, hiding your IP.

🔹 Reverse Proxy:
	•	Used to handle incoming traffic to backend services.
	•	Example: NGINX or HAProxy in front of your microservices:
	•	Load balancing
	•	Path-based routing
	•	TLS termination

| **Feature**       | **Proxy**                                     | **Reverse Proxy**                        |
| ----------------- | --------------------------------------------- | ---------------------------------------- |
| Located           | On client side                                | On server side                           |
| Hides             | The client                                    | The server                               |
| Typical use cases | Content filtering, anonymity, internet access | Load balancing, SSL termination, routing |
Ingress controller is **Kubernetes component** that acts as a **smart HTTP reverse proxy** to manage external access (typically HTTP/HTTPS) to services running inside the cluster.


1) ![[Pasted image 20250521230324.png]]

`k get all -A`

2) 
![[Pasted image 20250521230757.png]]
Run the command: `kubectl get ingress --all-namespaces` and identify the name of `Ingress Resource`.

3) 
![[Pasted image 20250521231159.png]]
```
Run the command: `kubectl describe ingress --namespace app-space` and look under the `Rules` section.
```

- [ ] Very IMPORTANT to know the difference first! 

| **Term**               | **Description**                                                                                                                                            |
| ---------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Ingress**            | A **Kubernetes object (resource)** that defines HTTP/HTTPS routing rules.                                                                                  |
| **Ingress Controller** | A **Kubernetes component (software/pod)** that watches Ingress objects and implements the routing (usually via a load balancer like NGINX, HAProxy, etc.). |
Execute the command `kubectl describe ingress --namespace app-space` and examine the **Default backend** field. If it displays <default, proceed to inspect the ingress controller's manifest by executing `kubectl get deploy ingress-nginx-controller -n ingress-nginx -o yaml`. In the manifest, search for the argument --default-backend-service


![[Pasted image 20250521233229.png]]

Solution manifest file to create a new ingress service to make the application available at `/pay` as follows:

```yaml
---
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: test-ingress
  namespace: critical-space
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
    nginx.ingress.kubernetes.io/ssl-redirect: "false"
spec:
  rules:
  - http:
      paths:
      - path: /pay
        pathType: Prefix
        backend:
          service:
           name: pay-service
           port:
            number: 8282
```




###### **Ingress Networking - 2** 

>GOOD Question - Covers all the basics of NGINX!
![[Pasted image 20250522082736.png]]

##### 6) State Persistance
###### Recap 
Persistence Volume vs Volume Mount vs Storage Class 

| **Component** | **Stands for**        | **Who creates it**               | **What it represents**                                                                                     |
| ------------- | --------------------- | -------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| **PV**        | PersistentVolume      | Admin or dynamically provisioned | The **actual storage resource** (like a disk) in the cluster                                               |
| **PVC**       | PersistentVolumeClaim | Developer/user                   | A **request** for storage by a pod                                                                         |
| **sc**        | Storage Class         |                                  | Deployment creates and manages Pods, just as<br>StorageClass dynamically provisions PVs based on PVCs.<br> |

Volume Claim related crucial syntax:- 
```
spec: 
	containers: 
    - name: nginx 
      image: nginx: alpine
      volumeMounts: 
	  - name: VARIABLE_NAME 
	    mountPath: /var/www/html
    volumes: 
      - name: 
        persistentVolumeClaim: 
	        claimName: local-pvc
```

*Handy Commands :-* 
k get sc (storage class)

###### **Persistent volumes**
1) ![[Pasted image 20250522091941.png]]

```
k exec webapp -- cat /log/app.log
```

2) GOOD Question : requires the application of multiple commands

|**Field**|**Value**|**Why**|
|---|---|---|
|name: webapp-logs|In both volumes and volumeMounts|Names must match exactly|
|hostPath.path: /var/log/webapp|Writes logs to this host path|For persistence and observability|
|mountPath: /log|Container writes logs here|It maps to host’s /var/log/webapp|
|type: DirectoryOrCreate|Creates the directory on host if it doesn’t exist|Prevents errors if the path is missing|

![[Pasted image 20250522095155.png]]

| **Component** | **Stands for**        | **Who creates it**               | **What it represents**                                       |
| ------------- | --------------------- | -------------------------------- | ------------------------------------------------------------ |
| **PV**        | PersistentVolume      | Admin or dynamically provisioned | The **actual storage resource** (like a disk) in the cluster |
| **PVC**       | PersistentVolumeClaim | Developer/user                   | A **request** for storage by a pod                           |
![[Pasted image 20250523082920.png]]

Run the command: `kubectl get pv,pvc` and look at the `Access Modes`.


![[Pasted image 20250523083715.png]]

>Couldn't make the status BOUND! Try again later. 
>STORAGE Class Name was not SET correctly!

![[Pasted image 20250523085407.png]]

###### **Storage Class**

•	Deployment creates and manages Pods, just as
•	StorageClass dynamically provisions PVs based on PVCs.

But:
	•	Pods are ephemeral (can be recreated),
	•	PVCs are persistent (keep their data via PVs).

1) ![[Pasted image 20250527060433.png]]

>k get sc

2) 

![[Pasted image 20250527061628.png]]

>Look for the storage class name that uses `no-provisioner`

3) 
![[Pasted image 20250527062801.png]]

* utilised the information from local-pv volume 
* and the kubernetes documentation
* The above created PVClaim errors out because 
>The Storage Class called `local-storage` makes use of `VolumeBindingMode` set to `WaitForFirstConsumer`. This will delay the binding and provisioning of a PersistentVolume until a Pod using the PersistentVolumeClaim is created.

![[Pasted image 20250527064404.png]]

```
---
apiVersion: v1
kind: Pod
metadata:
  name: nginx
  labels:
    name: nginx
spec:
  containers:
  - name: nginx
    image: nginx:alpine
    volumeMounts:
      - name: local-persistent-storage
        mountPath: /var/www/html
  volumes:
    - name: local-persistent-storage
      persistentVolumeClaim:
        claimName: local-pvc
```


##### 7.1) Practise Docker Labs

1) ![[Pasted image 20250527074153.png]]

docker build -t webapp-color .

2) 
![[Pasted image 20250527074342.png]]

docker run -p 8282:8080 webapp-color

3) 
![[Pasted image 20250527074726.png]]

docker build -t webapp-color:lte .


##### 7.2) Practise Test Kubeconfig 
1) ![[Pasted image 20250527075217.png]]
Use the command `ls -a` and look for the kube config file under `/root/.kube`.

2) ![[Pasted image 20250527081039.png]]
kubectl config --kubeconfig=/root/my-kube-config use-context research

3) ![[Pasted image 20250527081204.png]]

![[Pasted image 20250527081220.png]]

##### 7.3) Practise Test Role based Access controls
###### Recap

1) **Namespace `kube-system`**
is where we get more information about ROLE Based access info in the cluster

`kubectl describe pod kube-apiserver-controlplane -n kube-system`

2) **To operate as a given user :-** 
You can run whatever kubernetes command with this syntax 

`k get pods` --as `dev-user`
* k get pods - can be any other KUBERNETES cmd
* --as - specifies the `dev-user`

3) Create 
```
kubectl create role --help
kubectl create rolebinding --help
```

4) EDIT 
```
kubectl edit role --help
kubectl edit rolebinding --help
```

5) Describe 
```
kubectl describe role --help
kubectl describe rolebinding --help
```
###### Questions
1) 
![[Pasted image 20250609185720.png]]

All of these authorization MODEs are found configured in `kube-apiserver-controlplane` inside `kube-system`

- [ ] Use the command `kubectl describe pod kube-apiserver-controlplane -n kube-system` and look for `--authorization-mode`.

2) ![[Pasted image 20250609190308.png]]


Use the command `kubectl get roles` to list the available `roles` in the `default` namespace.

3) 
![[Pasted image 20250609193824.png]]


4) 
![[Pasted image 20250609194210.png]]
Run the command: `kubectl describe role kube-proxy -n kube-system`


5) 
![[Pasted image 20250609194426.png]]
Run the command: `kubectl describe rolebinding kube-proxy -n kube-system`

6) ![[Pasted image 20250630162108.png]]

 
 👉 **What kube-proxy typically does:**

The kube-proxy component needs access only to its specific ConfigMap (usually named kube-proxy) so it can get its configuration.

➡ It does **not** require permissions to view all ConfigMaps across the cluster.

➡ It does **not** have broad access to all ConfigMaps in any namespace.

  

✅ The correct statement would be:

- kube-proxy role can only view and update ConfigMap object by the name kube-proxy
    
- or
    
- kube-proxy role can get details of ConfigMap object by the name kube-proxy only
 
 7) ![[Pasted image 20250630162537.png]]

**Concept**:- A Role Binding grants a given role to USERs, GROUPs or SERVICE Accounts

Run the command: `kubectl describe rolebinding kube-proxy -n kube-system`

8) ![[Pasted image 20250630163044.png]]
To operate as a given user :- 
You can run whatever kubernetes command with this syntax 

`k get pods` --as `dev-user`
* k get pods - can be any other KUBERNETES cmd
* --as - specifies the `dev-user`

9) ![[Pasted image 20250630163450.png]]

To create a Role:- `kubectl create role developer --namespace=default --verb=list,create,delete --resource=pods`  
  
To create a RoleBinding:- `kubectl create rolebinding dev-user-binding --namespace=default --role=developer --user=dev-user`

10) ![[Pasted image 20250630164842.png]]

k edit role developer -n blue
so the issue was that the resourceName specified was incorrect! 

11) ![[Pasted image 20250630165424.png]]

Be cautious that deployment will not have resourceNames!
![[Pasted image 20250630165934.png]]


##### 7.4) Practise Cluster Role based Access controls

###### Recap 
1) Cluster Roles are cluster wide and not part of any namespace.
2) A smart-way to check CMD syntax is always 
```
kubectl create clusterrole --help
kubectl create clusterrolebinding --help
```

>Remember this :-  will come in very handy during these count related questions. 

3) `wc -l` - this means give me a total lines present in the output

4) 
```
k describe clusterrole NAME 
k describe clusterolebinding NAME 
```
###### Questions
1) ![[Pasted image 20250630173503.png]]

k get clusterroles | wc -l
k get ClusterRoleBindings | wc -l


2) ![[Pasted image 20250630173919.png]]

k describe clusterrole cluster-admin
Cluster Roles are cluster wide and not part of any namespace.

3) ![[Pasted image 20250630174224.png]]
k describe clusterrolebinding cluster-admin

4) ![[Pasted image 20250630174542.png]]
k describe clusterrole cluster-admin
Performs any action on any resource in the cluster

5) Create a new CLUSTEROLE and BINDING to help `michelle` access the NODEs in the cluster.

kubectl create clusterrole node-reader --verb=get,list,watch --resource=nodes

k create clusterrolebinding node-reader-bidning --clusterrole=node-reader --user=michelle


6) ![[Pasted image 20250630175200.png]]

k create clusterrole storage-admin --verb=get,list,watch --resource=persistentvolumes,storageclasses

kubectl create clusterrolebinding michelle-storage-admin --clusterrole=storage-admin --user=michelle


##### 7.5) Practise Admission Controller
###### Recap
Admission Controller - It is a piece of code in Kubernetes-api-server that intercepts every request to modify a K8 resource before any action is performed on that resource.

**File Path for ADMISSION-CONTROLLER**
`/etc/kubernetes/manifests/kube-apiserver.yaml`

**CMD to check the process to see enabled and disabled plugins**
`ps -ef | grep kube-apiserver | grep admission-plugins`

###### Questions
1) ![[Pasted image 20250630180541.png]]
NamespaceAutoProvision

2) ![[Pasted image 20250630180732.png]]

Check `enable-admission-plugins` in `/etc/kubernetes/manifests/kube-apiserver.yaml`

cat /etc/kubernetes/manifests/kube-apiserver.yaml | grep admission

>Answer:- NodeRestriction

4) ![[Pasted image 20250630181325.png]]

To enable namespace creation in a POD, we need to update `--enable-admission-plugins` to include `NamespaceAutoProvision`

5) ![[Pasted image 20250630181528.png]]

6) Edit kube-apiserver.yaml FILE and add- --disable-admission-plugins=DefaultStorageClass

7) ![[Pasted image 20250630182642.png]]

##### 7.6) Validate and Mutate Admission Controller

##### 7.7) Validate and Mutate Admission Controller

##### 7.8) Lab - API Versions/Deprecations

##### 7.9) Practice Test - Custom Resource Definition

##### 7.10) Practice Test - Deployment strategies

##### 7.11) Labs - Install Helm

##### 7.12) Labs - Helm Concepts

##### 7.13) Lab - Managing Directories 🆕

##### 7.14) Lab - Transformers 🆕

##### 7.15) Lab - Patches 🆕

##### 7.16) Lab - Overlay 🆕

##### 7.17) Lab - Components 🆕


##### 8) Lightning LABs

I think practical for me will also be to study and test the SVC URLs inside different PODs

##### Kubernetes Basics

Course : PDF : https://drive.google.com/file/d/13ybLQaH0t1aq6hlRUwN-l8a1H8OVuTYI/view?usp=sharing

###### 1) Kubernetes Overview 
*38 mins*

Basic Hierarchy  
```
Cluster 
-> Nodes 
-> Pods 
-> Services 
-> Deployments( which help run Containers) 
-> Replica sets
```


- [ ] [[Kubernetes Jargons]]
- [ ] [[Handy Commands - Kubernetes]]
- [x] [[Containers]]
- [x] [[Container Orchestration]]
- [x] [[Kubernetes Architechture]]
- [ ] Docker vs ContainerD ( ***to be created*** )


For Hands on experience :- 
```
- [ ] Installed RANCHER in system 
brew install --cask rancher
```


###### 2) Kubernetes Concepts
*29 mins*
- [x] [[Pods]]
- [ ] Minikube

___

###### 3) YAML Introduction **(Actually Important)**
*12mins only*

- [x] [[YAML Introduction]]

###### 4) Kubernetes Concepts - Pods, ReplicaSets, Deployments **(Actually Important)** 

*2hrs 13mins (Longest !!!!)*

- [x] Pods with YAML 
- [x] Coding Exercises

[[ReplicaSets & Replication Controllers]]

###### 5) Networking in Kubernetes **(Actually Important)**

*6mins ONLY*



###### 6) Services **(Actually Important)**

*36 mins*

- [ ] Coding Exercises


###### 7) Microservices Architecture 

*47 mins*

###### 8) Kubernetes on Cloud 

*29 mins*
