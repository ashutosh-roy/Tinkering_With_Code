
#### YAML in Kubernetes


![[Pasted image 20250218145825.png]]

**SAMPLE Yaml** :-
![[Pasted image 20250218191730.png]]
**Key Components:**

• **apiVersion: v1** → 
* Specifies the API version of Kubernetes to use for this resource.
* v1 is the core API version for basic resources like Pods.

• **kind: Pod** → refers to the type of object that we are trying to create.

• **metadata** → Includes the Pod name (nginx) and labels (app: nginx, tier: frontend) for organisation.

• **spec** → Defines the container:

• **name: nginx** → Container name.

• **image: nginx** → Uses the official Nginx image.


![[Pasted image 20250218145634.png]]

#### Intro 
![[Pasted image 20250218121150.png]]



#### Order matters - List is ordered whereas Dictionary is unordered
![[Pasted image 20250218124607.png]]




#### Use double space instead of tabs 
List -> Dictionary 
```
Cars: 
 - Corvette:
     Description: 
	   Color: Black 
	   Version: 11 
	   MakeYear: 1990

 - Hyundai:  
     Description: 
 	   Color: Green 
	   Version: 12 
	   MakeYear: 1990



```