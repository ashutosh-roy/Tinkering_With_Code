###### Most used ones! 

kubectl delete pod PODNAME
`kubectl delete pod PODNAME`

kubectl get ns
`gets namespaces!`

kubectl get pods -n namespace
`kubectl get pods -n ns-nova`

kubectl exec -it POD_NAME -n namespace -- sh 

`kubectl exec -it ns-workflow-orchestrator-789dbf574d-rdtfj -n ns-nova -- sh`

**Lists down all the objects created**
```
kubectl get all 
```

###### Basic Kubernetes Commands

```
kubectl get deployments
```

```
kubectl service hello-minikube --url
```

```
kubectl expose deployment hello-minikube --type=NodePort --port=8080
```

```
kubectl create deployment hello-minikube --image=k8s.gcr.io/echoserver:1.4
```

###### Handy commands related to PODs

```
kubectl describe pod ___pod_name___
kubectl describe pod nginx
```


```
kubectl get pods -o wide
- [ ] Displays IP related details about the POD
```

``` 
kubectl get pods
```

**VVI for the above command :-**
- [ ] Here the READY column indicates RUNNING containers/ TOTAL Containers

**Pod Creation Command**
```
kubectl run nginx --image=nginx
```

means:

1. **kubectl run**: Creates a new **Pod** (not a Deployment) with a single container.

2. **nginx**: This is the **name of the pod**.

3. **--image=nginx**: Specifies the container image to use, in this case, nginx, which is pulled from the default container registry (Docker Hub, unless otherwise configured).



```
kubectl cluster-info
kubectl get nodes
```


###### Handy commands related to replicaSet

**Describes the contents of replicaSet**
```
kubectl get 
```

**Describes the contents of replicaSet**
```
kubectl describe rs RecplicaSetName 
```

**List POD for all namespaces**
```
kubectl get rs --all-namespaces
```

**List POD for current namespace**
```
kubectl get rs 
```

**Apply replica set changes for the first time**
```
kubectl apply -f some-file.yml
```

**Deletes a Replica Set for the given application**
```
kubectl delete replicaset ApplicationName
```



```
 kubectl replace -f some_YAML_File_Defintion.yml
```



```
kubectl scale –replicas=6 -f replicaset-definition.yml
```

this CMD updates the replicaSets COUNT without updating the values in the SHEET.




