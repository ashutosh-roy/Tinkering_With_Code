
### Piramal Related Grilling (Java, SpringBoot)

### Point 1 
```
Automated EMI-Receipt posting, reducing turn around time (TAT) by 60% (from 5 hours to 2 hours) and ensuring compliance and timely collection of customer’s EMI by developing a Spring based file processing service that allows operational stakeholders to process millions of records.
```

##### **About Business :** 
Since Piramal is an NBFC (non-banking-financial-corporation), it has service Providers which lend to the customers using their platform. Now, operations user has to generate the reports on 25th of every month which is posted their LMS. The LMS takes care of posting the receipts to Service Provider.

##### **Business Challenge :** 
1) Earlier Ops Users relied on X system and that was slow, unreliable and time consuming. 
2) So they used to download reports from multiple sources and then collate and create an Nach Status file which is posted to LMS.
3) This is shared to lending partners like Paytm and KreditBee and help for EMI Collection.

>Why couldn't we automate this entire thing E2E? 

```
We have rolled this out as an MVP to enable the OpsUsers to get their hands dirty on the system and adopt it for their day to day activities

On successful adoption, we'll get back to the Ops Users and gather requirements on what next to be added.
```

##### **High-Level Architecture :**
Two parts to this problem : 
* Pulling the data from the different sources to collate and organize it at a single place
	* [ ] We created data sync API 
* Help the user download this data into a debit sheet format 
	- [ ] So basically we made a Java Spring Boot based file processing microservice to 
		- [ ] handle file downloads (by reading the content from DB)
		- [ ] handle file uploads -> read EXCEL file content / perform validations
		- [ ] take care of the mapping and persisting of data into the DB 

>Difference between monolith and microservice ? 

[[Microservices vs Monolith Architecture]]

>Why choice of language is Java and Spring Boot in a microservice environment ? 
```
In the limited scope of client requirements, we didnot have a scope to explore on other maybe faster languages such as Go or Rust!
```

##### **Workflow :**
From the UI, an Ops User uploads the file. On the file, we perform two types of validations. 
* File Type / File Size / Missing headers Validation : this happens synchronously 
* Content Validation : 
	* here we received from business necessary validations that need to be performed based on each row ? For example, date should of a specific format
	* This generates the report with success and failure records 
* User can download the success report from the UI 
	* When the user wants to download it, our service pulls in data from S3 which gets the data as a stream from S3 and returns it to the UI 
* User can then submit the successful report which gets logged in the DB and gets posted to Pennant

>Since so much of reading from DB and writing back to the DB is involved, what kind of indexes did we create to enable faster response time? 


>Which excel library used for processing ? 

There were two java based excel file processing libraries in the market (fastexcel & Apache POI)
For our use case, which was to process 12+ columns & 1M rows, Fast excel made sense because of following reasons :-  
###### **FastExcel**
- **Performance**: Optimized for low memory consumption, ideal for large files (1M+ rows).
- **Memory Usage**: Efficient streaming writes, preventing OutOfMemory errors.
###### **Apache POI**
- **Performance**: Higher memory usage, can struggle with 1M+ rows.
- **Memory Usage**: Requires significantly more heap space, prone to memory bloat.



##### **Technical & Problem solving :**

* ***Question** : Can you walk me through the challenges you faced while building the Spring-based file processing service?


1. Handling Large Files (Memory Management)

Impact: Leads to OutOfMemoryError and affects service reliability when processing files with millions of rows.

Key Solutions:
- [ ] Use streaming approaches like FastExcel for reading and writing.
- [ ] Process files in batches and clear memory aggressively.

---

2. Streaming Data to the Client

Impact: Causes frequent ClientAbortException and broken pipe errors, impacting user experience during file downloads.

Key Solutions:
- [ ] Stream data incrementally using the response output stream.
- [ ] Query and collect the data in batches from the DB and keep sending it to the stream 



>Here, know more details about the how the STREAMING ensures faster responses.

We also observed that even after lot of performance optimisations we were getting client abort exception. This was happening due to a timeout configured at Load Balancer end. So we increased the overall request timeout for at max 4 minutes to make sure excel for a million records get aggregated and downloaded 

---

3. Concurrency and Scalability

Concurrency was a want and not a need for the client is what we observed. Instead the metrics collection was more prioritised. 

Impact: 
Performance bottlenecks during concurrent file processing and uploads affect overall throughput.

Key Solutions for Scalability :
- [ ] Use rate-limit requests to avoid overloading.
- [ ] Use async for the time taking validation and releasing the request early to frontend 

---

4. Database Interactions (Aggregation & Indexing)

Impact: Slow database queries and inefficient updates reduce the speed of file processing workflows.

Key Solutions:
- [ ] Use MongoDB’s aggregation framework for efficient filtering and projections.
- [ ] Design indexes to optimize query performance and reduce latency.

```
Have used single, 
Compound index 
Sparse index 
```

---

5. Error Handling and Reporting

Impact: Poor error reporting leads to debugging delays and reduced visibility into system issues.

Key Solutions:

- [ ] Implement centralized logging and monitoring (e.g., Spring Boot Actuator, Prometheus).
- [ ] Generate structured error reports for validation failures and file processing issues.

 * **Follow-up**: How did you ensure scalability and reliability when processing millions of records?

```
Concurrency was a want and not a need for the client is what we observed. Instead the metrics collection was more prioritised. 
```


> If we had to make this Microservice parallel what would we do ? 

1. **File Splitting**:
    - Split the large file into smaller chunks (e.g., 10,000 lines each) to allow parallel processing.
2. **Thread Pool for Parallelism**:
    - Use a thread pool (e.g., Java's `ExecutorService`) to assign each chunk to a separate thread for processing. This ensures efficient use of resources.
3. **Independent Chunk Processing**:
    - Each thread processes its chunk independently by performing tasks like data parsing, validation, and storage.
4. **Database Optimization**:
    - Use batch inserts to minimize database calls and improve throughput.
5. **Error Handling**:
    - Handle errors in a thread-safe way, e.g., using a `ConcurrentLinkedQueue` to log issues without affecting other threads.
6. **Monitoring**:
    - Track performance using metrics (e.g., processing time, errors) and log results for visibility.



**Common Questions related to Executor Service** 
[[Executor Service Common Questions]]

**Concurrency vs Parallelism**
![[Pasted image 20241213104011.png]]

**Difference between Thread and Process?**

____


**Question**: How did you identify the root cause of the bottleneck that led to the 5-hour turnaround time?  
```
This came as a business requirement from the Product Owners at Piramal.
```

**Follow-up**: What performance optimizations did you apply to achieve a 60% reduction in TAT?

``` 
- [ ] We aggregated all the scattered data into a single place.
- [ ] Manual intervention is required only to update the EMI SUCCESS and BOUNCED remarks to be added by Ops Users
- [ ] Handle file validations and persisit the data into DB
- [ ] there's a timed scheduler which keeps doing the RECEIPT posting to Pennant
```

____
##### **System Design & Architecture :**

**Question**: How did you design the Spring-based file processing service to handle large volumes of records efficiently?

**Chunk-Based Processing**:
- Split large files into smaller chunks (e.g., 10,000 lines each) to avoid memory overload.

**Streaming for Low Memory Usage**:
- Use streaming API from Fastexcel 

**Batch Database Operations**:
- Save processed records in batches to minimize database calls and improve write performance.

**Error Handling**:
- Log invalid records for later review and use retries for transient errors.

**Monitoring and Metrics**: 
- Track performance (e.g., processing time, error count) using Spring Actuator and visualize metrics with Grafana dashboards.

**Question**: Can you describe the key components of the service and how they interact?

##### **Performance & Scalability**

- **Question**: What were the key factors that contributed to reducing TAT from 5 hours to 2 hours?

```
- [ ] We aggregated all the scattered data into a single place.
- [ ] Manual intervention is required only to update the EMI SUCCESS and BOUNCED remarks to be added by Ops Users
- [ ] Handle file validations and persisit the data into DB
- [ ] there's a timed scheduler which keeps doing the RECEIPT posting to Pennant
```

____
### Point 2 
```
Enabled stakeholders to track business impact with clear insights by developing Grafana dashboards to monitor API performance and feature adoption
```


###### 1. **Core Technical Knowledge & Impact**

- **Question**: What key metrics did you prioritize when monitoring API performance, and how did these insights drive business decisions?

```
Adoption Metrics :- 
The invocation count of these APIs 
200 Success & 5XX related error tracking

Business impact related metrics :- 
For given installemnt due date the number of receipts posted 
```

____
### Point 3
```
Enhanced efficiency for 70+ operational stakeholders by improving real-time visibility with metrics for over 1 million monthly receipts. Achieved a approximately 90% reduction in resolution time by implementing in-mail alerts for critical 5xx errors, configured using Grafana.
```

Metrics were generated and emitted to Prometheus and read using Grafana dashboards 


### Point 4
```
Ensured adherence to 99.9% SLA for data availability during business hours, reduced retrieval times via resilient Data-Sync APIs developed in SpringBoot to consolidate scattered loan and EMI data for over 1M+ customers from Pennant and Snowflake into MongoDB.
```



### Point 5
```
Enhanced memory usage efficiency by 95% during high-volume data processing by using VisualVM to identify and analyze memory leaks.
```

- [ ] Add different other suggestions from chat gpt over here.

- [ ] How did we use Visual VM ? 
	- [ ] Ran our process locally with jvm allowed memory constraint set to 1.5GB 
	- [ ] Attached visual vm to the Java Process to observe which set of objects are leading to more bloated heap memory! 

- [ ] Personal Experience Wise
	- [ ] Using classic getter and setter instead of custom object mappers 
	- [ ] Once each batch is performed, nullify the lists & other objects created during transformation

### Point 6
```
Added Junit test cases to achieve 90% coverage for all business logic, improving code reliability and reducing issues in production.
```


>What are the obvious code smells that you would like to avoid as a Senior Engineer ? 

- [ ] Intent Revealing Names
- [ ] Make sure that 
- [ ] Minor nitpickings like avoiding if-ladder & replacing with switch case
- [ ] Being very cognizant and avoiding changes that impacts multiple files (basically aligning with 'O' of SOLID)
- [ ] Capturing things as tech debt in case they cannot be picked in the interest of time 


### GDHI Related Grilling (mostly devops)

### Point 7
```
Reduced deployment complexity and infrastructure costs by 25% by migrating the deployment architecture from Jenkins and Ansible to GitHub Actions, AWS CodeDeploy, and EC2.
```


### Point 8
```
Developed CI/CD pipelines for different (QA, Stage, Production) with following:-
	- [ ] Integrated automation test suites, reducing post-deployment issues by 30%, improving release quality metrics across all
	
	- [ ] environments. Incorporated JaCoCo code coverage checks, ensuring consistent monitoring of code coverage and
	
	- [ ] automatically storing reports for future analysis and improvement.
	
	- [ ] Added secrets scanning to identify potential vulnerabilities, achieving 100% compliance with security standards.
	
	- [ ] Enhanced team communication by developing a web-hook chatbot to provide real-time pipeline outcome notifications.
```




```
Reduced GCP Compute engine provisioning time by 80%, enabling faster deployments by automating resource setup with Terraform scripts.
```

**What is terraform ?**
[[Terraform Basics]]


### Kafka Basics related jargons 
[[Kafka Basics]]
