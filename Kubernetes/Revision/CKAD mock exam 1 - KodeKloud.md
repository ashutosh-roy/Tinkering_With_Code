TIME GIVEN - 55 MINS 

##### Able to solve
1) ![[Pasted image 20250520184712.png]]

2) ![[Pasted image 20250520184752.png]]


3) ![[Pasted image 20250520184915.png]]

4) ![[Pasted image 20250520185101.png]]


##### IMPORTANT -- 5) 
![[Pasted image 20250520185543.png]]

6) ![[Pasted image 20250520190641.png]]

7) 
![[Pasted image 20250520190854.png]]


9) ![[Pasted image 20250520191344.png]]
##### NOT ABLE TO SOLVE



###### Questions
6) 
>COULDN"T SOLVE this one! REATTEMPT 
![[Pasted image 20250520185627.png]]

COULDN"T answer this one. I'll need to understand the meaning of all these

  clusterip      Create a ClusterIP service
  externalname   Create an ExternalName service
  loadbalancer   Create a LoadBalancer service
  nodeport       Create a NodePort service

kubectl create service nodeport messaging-service --namespace=marketing --tcp=6379:6379

Did it with some common sense but let's understand all of the above! 

10) ![[Pasted image 20250520191505.png]]


11) 
![[Pasted image 20250520192516.png]]

kubectl logs e-com-1123 -n e-commerce > /opt/outputs/e-com-1123.logs

12) ![[Pasted image 20250520192748.png]]


```
apiVersion: v1
kind: PersistentVolume
metadata:
  name: pv-analytics
spec:
  capacity:
    storage: 100Mi
  volumeMode: Filesystem
  accessModes:
  - ReadWriteMany
  hostPath:
      path: /pv/data-analytics
```

13) 
![[Pasted image 20250520192822.png]]


To create deployment:

```
kubectl create deployment redis --image=redis:alpine --replicas=1
```

To expose the deployment using ClusterIP:

```
kubectl expose deployment redis --name=redis --port=6379 --target-port=6379
```

To create ingress rule:

```
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: redis-access
  namespace: default
spec:
  podSelector:
    matchLabels:
       app: redis
  policyTypes:
  - Ingress
  ingress:
  - from:
    - podSelector:
        matchLabels:
          access: redis
    ports:
     - protocol: TCP
       port: 6379
```


14) 
![[Pasted image 20250520192839.png]]


The pod yaml file should be:

```
apiVersion: v1
kind: Pod
metadata:
  name: sega
spec:
  containers:
  - image: busybox
    name: tails
    command:
    - sleep
    - "3600"
  - image: nginx
    name: sonic
    env:
    - name: NGINX_PORT
      value: "8080"
```