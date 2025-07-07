
- [ ] Paste the solutions GIVEN by the WEBSITE! 
- [ ] Shouldn't this be checking connection to `secure-pod`
	- [ ] `kubectl exec webapp-color -- wget --spider secure-service:80` 
- [ ] 

1) ![[Pasted image 20250701205419.png]]

- [ ] Search using 
- [ ] "Configure a Pod to Use a PersistentVolume for Storage" in website.
- [ ] I have reused the PVC configs given in this article 


My Answer :- 
controlplane ~ ➜  cat pv.yaml 
```
apiVersion: v1
kind: PersistentVolume
metadata:
  name: log-volume
  labels:
    type: local
spec:
  storageClassName: manual
  capacity:
    storage: 1Gi
  accessModes:
    - ReadWriteMany
  hostPath:
    path: "/opt/volume/nginx"
```

controlplane ~ ➜  cat pvc.yaml 
```
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: log-claim
spec:
  storageClassName: manual
  accessModes:
    - ReadWriteMany
  resources:
    requests:
      storage: 200Mi
```

controlplane ~ ➜  cat pod.yaml 
```
apiVersion: v1
kind: Pod
metadata:
  creationTimestamp: null
  labels:
    run: logger
  name: logger
spec:
  volumes:
  - name: log-storage
    persistentVolumeClaim:
      claimName: log-claim
  containers:
  - image: nginx
    name: logger
    resources: {}
    volumeMounts:   
    - mountPath: /var/www/nginx
      name: log-storage
  dnsPolicy: ClusterFirst
  restartPolicy: Always
status: {}
```


IMPORTANT Question! 
2) ![[Pasted image 20250701213929.png]]

Follow this order strictly 
- [ ] Ensure POD is running
- [ ] Check whether service (which is trying to expose the POD) has labels matching with the POD 
- [ ] Check the network policies attached to SERVICE


**Check if secure-pod is running**
`kubectl get pod secure-pod -o wide` - Pod should be in Running state.

**Check secure-service details**
```
kubectl get svc secure-service
kubectl describe svc secure-service
```
Ensure:
•	Selector matches secure-pod labels
•	Ports are correct


**Verify secure-pod labels**
```
kubectl get pod secure-pod --show-labels
```

Make sure these labels match what secure-service selects.


**Check Network Policies**
```
kubectl get networkpolicy
kubectl describe networkpolicy name
```

Look for policies blocking ingress or egress for secure-pod.

⸻

**Allow connections from webapp-color**

Get labels first
```
kubectl get pod secure-pod --show-labels
kubectl get pod webapp-color --show-labels
```



* Create a new NetworkPolicy to allow external and internal traffic to the PODs
* This Network Policy should allow the traffic FROM a POD `webapp-color` specified in INGRESS into `secure-pod`

```
spec:
  ingress:
  - from:
    - podSelector:
        matchLabels:
          name: webapp-color
  podSelector:
    matchLabels:
      run: secure-pod
  policyTypes:
  - Ingress
```

> NOTE:- Follow `Declare Network Policy` article in the DOC 



**Test connectivity from webapp-color**
`kubectl exec webapp-color -- wget --spider secure-service:80` - Connection should succeed!



3) ![[Pasted image 20250702071943.png]]

- [ ] TO BE RE-ATTEMPTED! 
Referred Doc:- look for this article --- configure-pod-configmap

Create a namespace called `dvl1987` by using the below command:-

```sh
$ kubectl create namespace dvl1987
```

Solution manifest file to create a configMap called `time-config` in the given namespace as follows:-

```yaml
apiVersion: v1
data:
  TIME_FREQ: "10"
kind: ConfigMap
metadata:
  name: time-config
  namespace: dvl1987
```

Now, create a pod called `time-check` in the same namespace as follows:-

```yaml
---
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: time-check
  name: time-check
  namespace: dvl1987
spec:
  volumes:
  - name: log-volume
    emptyDir: {}
  containers:
  - image: busybox
    name: time-check
    env:
    - name: TIME_FREQ
      valueFrom:
            configMapKeyRef:
              name: time-config
              key: TIME_FREQ
    volumeMounts:
    - mountPath: /opt/time
      name: log-volume
    command:
    - "/bin/sh"
    - "-c"
    - "while true; do date; sleep $TIME_FREQ;done > /opt/time/time-check.log"
```

4) 
![[Pasted image 20250702081654.png]]

**Solution**

Run the following command to create a manifest for deployment `nginx-deploy` and save it into a file:-

```sh
kubectl create deployment nginx-deploy --image=nginx:1.16 --replicas=4 --dry-run=client -oyaml > nginx-deploy.yaml
```

and add the `strategy` field under the `spec` section as follows:-

```yaml
  strategy:
    rollingUpdate:
      maxSurge: 1
      maxUnavailable: 2
```

So final manifest file for deployment called `nginx-deploy` should looks like below:-

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  labels:
    app: nginx-deploy
  name: nginx-deploy
  namespace: default
spec:
  replicas: 4
  selector:
    matchLabels:
      app: nginx-deploy
  strategy:
    rollingUpdate:
      maxSurge: 1
      maxUnavailable: 2
    type: RollingUpdate
  template:
    metadata:
      labels:
        app: nginx-deploy
    spec:
      containers:
      - image: nginx:1.16
        imagePullPolicy: IfNotPresent
        name: nginx
```

then run the `kubectl apply -f nginx-deploy.yaml` to create a deployment resource.  
  
Now, upgrade the deployment's image version using the `kubectl set image` command:-

```
kubectl set image deployment nginx-deploy nginx=nginx:1.17
```

Run the `kubectl rollout` command to undo the update and go back to the previous version:-

```
kubectl rollout undo deployment nginx-deploy
```


5) ![[Pasted image 20250702184013.png]]

**Solution manifest** file to create a deployment `redis` as follows:-

```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  labels:
    app: redis
  name: redis
spec:
  selector:
    matchLabels:
      app: redis
  template:
    metadata:
      labels:
        app: redis
    spec:
      volumes:
      - name: data
        emptyDir: {}
      - name: redis-config
        configMap:
          name: redis-config
      containers:
      - image: redis:alpine
        name: redis
        volumeMounts:
        - mountPath: /redis-master-data
          name: data
        - mountPath: /redis-master
          name: redis-config
        ports:
        - containerPort: 6379
        resources:
          requests:
            cpu: "0.2"
```