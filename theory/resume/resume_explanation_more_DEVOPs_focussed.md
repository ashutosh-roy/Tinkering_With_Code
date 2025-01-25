
- [x] What are my ambitions 5 year down the line ?
* For this year, I have decided to get my hands more dirty into the open source contributions especially in GO
* Participate & contribute actively in Hacktoberfest
- [x] [Kubernetes Jargons](theory/resume/Kubernetes_Jargons.md)
- [x] Java - Prep from Shreyansh playlist
- [x] Spring boot - watch Shreyansh video thumbnails and gain theory context


###### Control Plane
**Scenario:** Deploying a Spring Boot application with database connectivity, scaling, and API exposure.

1. **API Server**
    - **Usage:** Acts as the interface for managing Kubernetes resources.
    - **Example:** DevOps engineers use `kubectl apply` to deploy the Spring Boot application's deployment and service YAML files. The API server validates and processes these configurations.
2. **Etcd**
    - **Usage:** Stores the desired and current state of all Kubernetes objects.
    - **Example:** The desired state for the Spring Boot application (e.g., 3 replicas, service details) is stored in Etcd. This ensures the application configuration is persistent and consistent across the cluster.
3. **Controller Manager**
    - **Usage:** Watches the state in Etcd and reconciles it with the actual state in the cluster.
    - **Example:** If the deployment specifies 3 replicas of the Spring Boot application but only 2 pods are running (due to a failure), the controller manager creates an additional pod to match the desired state.
4. **Scheduler**
    - **Usage:** Assigns pods to nodes based on resource availability and constraints.
    - **Example:** When the Spring Boot application pods are created, the scheduler selects the most appropriate nodes for them based on CPU, memory, and affinity/anti-affinity rules.
5. **Cloud Controller Manager** (Optional for cloud environments)
    - **Usage:** Interacts with the cloud provider to manage external resources.
    - **Example:** When exposing the Spring Boot application's REST API to external users, a `Service` of type `LoadBalancer` is used. The cloud controller provisions a cloud load balancer to route traffic to the application.

https://www.geeksforgeeks.org/what-is-kubernetes-control-plane/
![[Pasted image 20250124043835.jpg]]

* Read about the deployment.yml in kubernetes (refer to prf yml)



###### Deployment Strategie - CMSTP - Company Managed Change Project Board
*
* **contents :-**
- [ ] Launch Plan
- [ ] Implementation Plan
    - [ ] Can include Mongo Script Execution - (we have a jenkins pipeline)
    - [ ] Can include definitely the param store updates
    - [ ] So these are to be done before the master build gets deployed

- [ ] Rollback plan
- [ ] Canary Plan
 in a canary deployment, the older version of the application remains active while traffic is split between the old and new versions. Typically, a configuration might route 90% of the traffic to the stable (old) version and 10% to the canary (new) version.

* As we get stable feedback from our monitoring using logs and dashboard then we ***slowly and steadily increase the traffic %***


###### CI/CD Pipeline
```
We have a CI pipeline in place which comprises of two steps :- 
First Github Actions based pipeline
1) Checks the code for any UT failure
2) Runs Checkstyle checks and FORMATTING checks
3) Checks for any code coverage drop 
4) Runs sonarqube scan 
5) Runs cloud defense scan 
6) Checks if the internal dependencies that we are using in our project are outdated or NOT 

ONCE all this is done 
1) Then we shift to a DOCKER build JENKINS pipeline where we have to give branch name
2) It then generates a docker image for the final jar which is then pushed into NEXUS (container registry)
3) Then we in our CD Jenkins pipline we have to specify the 
```

* ***high performance***
    * in terms of services in general,
        * used FastExcel for lower memory footprint and increased efficiency in reading large volume of excel rows
        * used MongoDB for creating indexes for faster lookups
        * used batching to make avoid bulk processing

    * in terms of architecture,
        * use kubernetes ingress controller for efficient traffic distribution
* ***high availability***
    * in terms of code : there was multiple instances were team
        * mention that our code connects to 3 data sources
            * LMS
            * Snowflake
            * MongoDB
        * Earlier by default if any of it was timing out the pod restart would happen
        * But I wrote a custom health indicator to make sure that
        * even if our primary datasource which is mongo should be available for health check even if the other two datasources are not.
    * in terms of architecture,
    * canary deployment strategy for business critical systems.
    * **Distribute Pods Across Nodes**
        * Deploy multiple replicas of your application using `Deployment` to handle pod failures.
    - Use **pod anti-affinity** to avoid placing all replicas on a single node.
    * containerized deployment :
        * Inside the service.yml, we specify the after what CPU % should it **autoscale**
        * Inside deployment.yml, we have also configured the **liveness and readiness probe** which ensures that if there are any faulty timeouts happening then we'll restart after a given intervals
* ***interoperability***
* having a microservices based environment (made sure we can communicate to other services without much hassle)

* ***high reliability***
    * MongoAutoKill for long running queries
    * Grafana Dashboards to monitor the performance and stability of the API (number of 200/500/400 requests per month)
    * DORA metrics -- We have metrics to track these for our services :-
        * frequency of deployments
        * success and failure of deployment
        * how frequently deployments fail
        * how long does it take from service to recover
##### **Scenarios**

> - Manage ambiguity and moderate levels of complexity, proactively discovering and addressing issues.  
Examples?
* Create common channels and highlight the risks
* Reach out to the right audience
* Read documentation if available

* One where we reduced a performance bottleneck in terms of CODE :-
```
For the data sync APIs, we created a Mock Data Source and we were testing to validate if our CODE was able to sync and transfrom the data in 1.5GB heap memory and we realised that it was not able to 


- [ ] Performance Testing 
- [ ] How did we use Visual VM ?   
    - [ ] Ran our process locally with jvm allowed memory constraint set to 1.5GB   
    - [ ] Attached visual vm to the Java Process to observe which set of objects are leading to more bloated heap memory!   
  
- [ ] Personal Experience Wise  
    - [ ] Using classic getter and setter instead of custom object mappers   
    - [ ] Once each batch is performed, nullify the lists & other objects created during transformation
    - [ ] Using streams API from java to hold the value instead of collections to hold the value while serializing and de-serializing 50K objects with nearly 14 fields


Followup
- [ ] We also created a TechDebt card to include JMeter as part of our CI pipeline for Data-Sync and Download Debit sheet API to make sure that less effort is involved in doing MANUAL testing

```

* One where we reduced a performance bottleneck in terms of architecture :-

```
- [ ] I had worked on building the download-debit-sheet API where the ask was to aggregate information from different mongo collections 
	- [ ] Transform it 
```

* Multiple scenarios where I called out an estimation and RISK in a tighter timeline

###### **Scenario :-**
When our dependency became more cross team, where we had the dependent MRs to be merged by REVIEWERs from the other team.

1) Create common teams groups with necessary stakeholders. (if it's a different team who needs to code-review and merge a particular MR)

2) Notify the risks that "Let's assume if this code merge is delayed then we'll miss committed GO-LIVE date which will impact OKR delivery."

```	
- [ ] I always document the conclusions from the Tech Huddles and Design Disucssions so that they can be referred to later 
	- [ ] Say when we are going live with that particular feature 
	- [ ] All the tech huddles / story kickoff / any changes in the midway that happen :- 
		- [ ] if it's a smaller change then it gets added as part of current story subtask 
		- [ ] otherwise if there are significant spills then either me or our BA creates a new JIRA Card for the same. 
```

###### **Project Delivery Practices followed :-**
```
	- [ ] We had a process where for a story less than a 3 pointer story we wouldn't create a design Doc
	- [ ] where as for the stories above 3 pointer, we created an LLD document
	- [ ] This gets 
	- [ ] Followup Question : ask GPT
```

```	
- [ ] We have weekly spring planning session in which we had story estimations call. We as a team would estimate the .
- [ ] During the story kickoff, 
- [ ] We utilize this to discuss the business impact of the story
- [ ] RAID
	- [ ] Risks 
	- [ ] Actions 
	- [ ] Issues 
	- [ ] Dependencies 
```


###### **What are the things to increase quality standards**
```
- [ ] Add dashboards --- Grafana to monitor the api performance
- [ ] Add rate-limiting to the APIs to reduce
- [ ] we can add checkstyle and code formatting checks as 
- [ ] Sonarqube for doing the STATIC Code analysis
- [ ] Jacoco Code Coverage Check 
- [ ] Pre-PUSH and Pre-Commit Hooks to make sure that to prevent-code-breaking the tests in getting commited to the GITHUB Repo
- [ ] Talisman Security Scanning and Check
- [ ] Enforce Cloud Defense scans to avoid any vulnerabilities in the packages

```


