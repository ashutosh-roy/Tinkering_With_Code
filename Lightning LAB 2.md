```
- [x] 4th July 
	- [x] REVISE 
	- [ ] 
```

1) ![[Pasted image 20250702185230.png]]

TRICK Question : 

1) TO identify failing POD :- 
`k get pods --all-namespaces` - this gets PODs across all the namespaces.
Just doing a `k get pods` is not enough.

2) To troubleshoot failing POD :- 
`k get pods -A | grep "nginx1401"` - to get namespace 
`k describe pod nginx1401 -n dev1401` - to identify the reason for failure

3) For this PROBLEM we see that, we need to RESTART hence LIVENESS PROBE is important

To set this UP :- 
Search `command` in livenessProbe article! 

```
livenessProbe:
  exec:
    command:
    - ls
    - /var/www/html/file_check
  initialDelaySeconds: 10
  periodSeconds: 60
```

4) The PORT in readiness PROBE should also be fixed to point to the CORRECT PORT.

🚀 ***Liveness Probe***
- [ ] Purpose: Checks if the container is still alive (i.e., running and functioning).

- [ ] - **What happens if it fails?** Kubernetes _kills_ the container and restarts it (according to the pod’s restartPolicy).

🚀 ***Readiness Probe***
- [ ] Purpose: Checks if the container is ready to serve traffic (i.e., can accept requests).
	
- [ ] **What happens if it fails?** Kubernetes removes the pod from service (i.e., from the endpoints list of the service) but **does not restart the container**.

*Solution:*
```
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: nginx
  name: nginx1401
  namespace: dev1401
spec:
  containers:
  - image: kodekloud/nginx
    imagePullPolicy: IfNotPresent
    name: nginx
    ports:
    - containerPort: 9080
      protocol: TCP
    readinessProbe:
      httpGet:
        path: /
        port: 9080    
    livenessProbe:
      exec:
        command:
        - ls
        - /var/www/html/file_check
      initialDelaySeconds: 10
      periodSeconds: 60
```


3) ![[Pasted image 20250702185500.png]]


So this question really asks for a lot of configurations available inside `CRONJOBs article of Kubernetes DOC`


**Question to CONFIG Hints:-** 
>The job should be `non-parallel` 
-> parallelism: 1

>complete the task `once`
-> completions: 1

>Use a `backoffLimit` of `25`.
-> backoffLimit: 25

>If the task is not completed within `20 seconds` the job should fail and pods should be terminated. 
-> activeDeadlineSeconds: 20


Since CronJob is of JOB category it'll support the fields like `backoffLimit` etc.

```
apiVersion: batch/v1
kind: CronJob
metadata:
  name: dice
spec:
  schedule: "*/1 * * * *"
  jobTemplate:
    spec:
      completions: 1
      backoffLimit: 25 # This is so the job does not quit before it succeeds.
      activeDeadlineSeconds: 20
      template:
        spec:
          containers:
          - name: dice
            image: kodekloud/throw-dice
          restartPolicy: Never
```


3) ![[Pasted image 20250702192023.png]]

Lookup `Secrets` file and that helps you use SECRETs as a volumeMount as required in this question.


4) ![[Pasted image 20250702213814.png]]
Referred this :- create ingress. This gives YOU the command 
https://kubernetes.io/docs/reference/kubectl/generated/kubectl_create/kubectl_create_ingress/

For ingress related questions let's try and USE YAML instead of imperative COMMANDs

*Solution*
```
---
kind: Ingress
apiVersion: networking.k8s.io/v1
metadata:
  name: ingress-vh-routing
  annotations:
    nginx.ingress.kubernetes.io/rewrite-target: /
spec:
  rules:
  - host: watch.ecom-store.com
    http:
      paths:
      - pathType: Prefix
        path: "/video"
        backend:
          service:
            name: video-service
            port:
              number: 8080
  - host: apparels.ecom-store.com
    http:
      paths:
      - pathType: Prefix
        path: "/wear"
        backend:
          service:
            name: apparels-service
            port:
              number: 8080
```


5) ![[Pasted image 20250702213856.png]]

*Solution*
```
kubectl logs dev-pod-dind-878516 -c log-x | grep WARNING > /opt/dind-878516_logs.txt
```