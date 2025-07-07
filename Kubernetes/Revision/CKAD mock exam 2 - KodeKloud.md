###### RECAP 

>Ways to expose deployment to the outside WORLD 

- **ClusterIP** – Exposes the service on an internal IP in the cluster; accessible only within the cluster.
    
- **ExternalName** – Maps the service to an external DNS name without creating a proxy.
    
- **LoadBalancer** – Exposes the service externally using a cloud provider’s load balancer.
    
- **NodePort** – Exposes the service on each node’s IP at a static port; accessible from outside the cluster via NodeIP:NodePort.

```
75 mins. Let's see.
9 questions - 8 mins per question MAX



```

###### Questions

1) ![[Pasted image 20250701122542.png]]
k create deployment --help 
k create deployment my-webapp --image=nginx --replicas=2
k expose deployment my-webapp --name=front-end-service --port=80 
k edit deployment front-end-service -> to edit the NODEPORT to 30083


2) ![[Pasted image 20250701125301.png]]

k taint -- help 
k taint node node01 app_type=alpha:NoSchedule
node/node01 tainted

k run alpha --image=redis --dry-run=client -o yaml > alpha.yaml

```
spec: 
	tolerations: 
	- key: "app_type"
	  value: "alpha" 
	  operator: "Equal"
	  effect: "NoSchedule"
```



3) ![[Pasted image 20250701130833.png]]

- [ ] k label node controlplane app_type=beta

- [ ] k create deployment beta-apps --image=nginx --dry-run=client -0 yaml > beta_app.yaml

- [ ] Add nodeaffinity configuration from OFFICIAL DOCUMENTATION

```
- key: app_type
  operator: In
  values:
  - beta
```

4) ![[Pasted image 20250701132348.png]]

- [x] Let's verify if this is CORRECT.

```
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: my-video-service
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - host: "ckad-mock-exam-solution.com"
    http:
      paths:
      - pathType: Prefix
        path: "/video"
        backend:
          service:
            name: my-video-service
            port:
              number: 8080
```

5) ![[Pasted image 20250701133633.png]]

```

```


6) ![[Pasted image 20250701133651.png]]

```

```



7) ![[Pasted image 20250701133705.png]]


```

```


7) ![[Pasted image 20250701133723.png]]

```yaml
apiVersion: v1
kind: Pod
metadata:
  name: multi-pod
spec:
  containers:
  - name: europa
    image: busybox
    command: ["/bin/sh"]
    args: ["-c", "sleep 4800;"]
    env:
    - name: type
      value: "moon"
  - name: jupiter
    image: nginx
    env:
    - name: type
      value: "planet"  
```



8) ![[Pasted image 20250701133741.png]]


```yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: custom-volume
spec:
  capacity:
    storage: 50Mi
  accessModes:
  - ReadWriteMany
  persistentVolumeReclaimPolicy: Retain
  hostPath:
    path: /opt/data
```

