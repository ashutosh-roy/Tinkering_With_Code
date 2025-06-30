
![[Pasted image 20250217110739.png]]

**kube-apiserver** :- The API server acts as the front-end for kubernetes. The users, management devices, Command line interfaces all talk to the API server to interact with the kubernetes cluster.


```
If you imagine entering into the FICO office, this is the office reception 
```

**etcd** :- 
1) ETCD is a distributed reliable key-value store used by Kubernetes to store all data used to manage the cluster. 

2) When you have multiple nodes and multiple masters in your cluster, etcd stores all that information on all the nodes in the cluster in a distributed manner.

```
FICO One : Intranet library to store all the info about FICO 
```

**controller** :-
3) controllers are the brain behind orchestration. They are responsible for noticing and responding when nodes, containers or endpoints goes down. 

4) The controllers makes decisions to bring up new containers in such cases.

```
Engineering Manager, like Satya Shekhar, who is responsible for managing teams & team members.
```

**scheduler** :- 
scheduler is responsible for distributing work or containers across multiple nodes. It looks for newly created containers and assigns them to Nodes.

```
Principal Engineer, like Satyabrath to deleate work among team members
```

**kubelet** :-
kubelet is the agent that runs on each node in the cluster. The agent is
responsible for making sure that the containers are running on the nodes as expected.

```
SCRUM master does this by enforcing agile practices.
```

**container-runtime** :-
container runtime is the underlying software that is used to run containers. In our case it happens to be Docker.

```
FICO laptops are the runtime where FICO work happens
```