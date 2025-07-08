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
**Previous answer** :- 


k create deployment --help

k create deployment my-webapp --image=nginx --replicas=2
k expose deployment my-webapp --name=front-end-service --port=80 
k edit deployment front-end-service -> to edit the NODEPORT to 30083

**Current Answer**  :- 

k create deployment my-webapp --image=nginx --replica=2
```
apiVersion: v1
kind: Service
metadata:
  name: webapp-nodeport-service
spec:
  type: NodePort
  selector:
    app.kubernetes.io/name: MyApp
  ports:
    - port: 80
      # By default and for convenience, the `targetPort` is set to
      # the same value as the `port` field.
      targetPort: 80
      # Optional field
      # By default and for convenience, the Kubernetes control plane
      # will allocate a port from a range (default: 30000-32767)
      nodePort: 30083
```
1) ![[Pasted image 20250701125301.png]]

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


**Current answer** :- 
k taint node node01 app_type=alpha:NoSchedule


POD.yaml
```
apiVersion: v1
kind: Pod
metadata:
  creationTimestamp: null
  labels:
    run: alpha
  name: alpha
spec:
  containers:
  - image: redis
    name: alpha
    resources: {}
  dnsPolicy: ClusterFirst
  restartPolicy: Always
  tolerations:
  - key: "app_type"
    operator: "Exists"
    effect: "NoSchedule"
status: {}
```


3) ![[Pasted image 20250701130833.png]]

- [ ] k label node controlplane app_type=beta

- [ ] k create deployment beta-apps --image=nginx --dry-run=client -0 yaml > beta_app.yaml

- [ ] Add nodeaffinity configuration from OFFICIAL DOCUMENTATION


**CURRENT answer** :- 
 k label node controlplane app_type=beta
 
```
apiVersion: apps/v1
kind: Deployment
metadata:
  creationTimestamp: null
  labels:
    app: beta-apps
  name: beta-apps
spec:
  replicas: 1
  selector:
    matchLabels:
      app: beta-apps
  strategy: {}
  template:
    metadata:
      creationTimestamp: null
      labels:
        app: beta-apps
    spec:
      affinity:
        podAntiAffinity:
          requiredDuringSchedulingIgnoredDuringExecution:
          - labelSelector:
              matchExpressions:
              - key: app
                operator: In
                values:
                - beta
            topologyKey: "kubernetes.io/hostname"
      containers:
      - image: nginx
        name: nginx
        resources: {}
status: {}
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

**Current Answer**

```
apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: my-video-service-ingress
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - host: ckad-mock-exam-solution.com
    http:
      paths:
      - path: /video
        pathType: Prefix
        backend:
          service:
            name: my-video-service
            port:
              number: 30093
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

