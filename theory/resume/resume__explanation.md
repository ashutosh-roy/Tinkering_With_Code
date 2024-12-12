
### Piramal Related Grilling (Java, SpringBoot)

```
Automated EMI-Receipt posting, reducing turn around time (TAT) by 60% (from 5 hours to 2 hours) and ensuring compliance and timely collection of customer’s EMI by developing a Spring based file processing service that allows operational stakeholders to process millions of records.
```

##### **About Business :** 
Since Piramal is an NBFC (non-banking-financial-corporation), it has service Providers which lend to the customers using their platform. Now, operations user has to generate the reports on 25th of every month and present it to the Pennant to 

##### **Business Challenge :** 
Earlier Ops Users relied on X system and that was slow, unreliable and time consuming. So they used to download reports from multiple sources and then collate and create an Nach Status file which can be shared to lending partners like Paytm and KreditBee and help for EMI Collection.

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

>Right now, it supports only a single user? If we had multiple users concurrently trying to this, then what structural changes would you make in the architecture? 


>Since so much of reading from DB and writing back to the DB is involved, what kind of indexes did we create to enable faster response time? 


>Which excel library used for processing ? 

There were two java based excel file processing libraries in the market (fastexcel & Apache POI)
For our use case, which was to process 12+ columns & 1M rows, Fast excel made sense because of following reasons :-  
###### **FastExcel**
- **Performance**: Optimized for low memory consumption, ideal for large files (1M+ rows).
- **Memory Usage**: Efficient streaming writes, preventing OutOfMemory errors.
- **Ease of Use**: Simpler API for writing large datasets.
- **Limitations**: Limited feature set (e.g., lacks advanced formatting, charting).

###### **Apache POI**
- **Performance**: Higher memory usage, can struggle with 1M+ rows.
- **Features**: Supports advanced Excel functionalities (charts, formatting, formulas).
- **Memory Usage**: Requires significantly more heap space, prone to memory bloat.
- **Versatility**: Better for files with complex formatting or smaller datasets.


##### **Technical & Problem solving :**
>**Question** : Can you walk me through the challenges you faced while building the Spring-based file processing service?
 **Follow-up**: How did you ensure scalability and reliability when processing millions of records?


>**Question**: How did you identify the root cause of the bottleneck that led to the 5-hour turnaround time?  
 **Follow-up**: What performance optimizations did you apply to achieve a 60% reduction in TAT?



##### **System Design & Architecture :**

>**Question**: How did you design the Spring-based file processing service to handle large volumes of records efficiently?
   **Follow-up**: What architectural patterns or tools did you use to ensure high availability and fault tolerance?

>**Question**: Can you describe the key components of the service and how they interact?
  **Follow-up**: How did you ensure the system could maintain compliance and timely collection in a high-load environment?


##### **Data Processing & Optimization**

- **Question**: How did you ensure compliance while processing large volumes of customer data?
- **Follow-up**: Were there any data validation mechanisms or checks you implemented to ensure data accuracy and integrity?

- **Question**: What role did error handling and retries play in making sure the process was robust?
- **Follow-up**: How did you monitor and optimize the service post-deployment to handle edge cases?

##### **Performance & Scalability**

- **Question**: What were the key factors that contributed to reducing TAT from 5 hours to 2 hours?
- **Follow-up**: How did you optimize the data pipeline and processing steps to achieve such a significant reduction?


____

```
Enabled stakeholders to track business impact with clear insights by developing Grafana dashboards to monitor API performance and feature adoption
```


###### 1. **Core Technical Knowledge & Impact**

- **Question**: What key metrics did you prioritize when monitoring API performance, and how did these insights drive business decisions?
- **Context**: 80% of the value comes from understanding high-priority metrics and how they impact business decisions.

---

###### 2. **Stakeholder Collaboration & Business Impact**

- **Question**: How did you ensure Grafana dashboards provided actionable insights aligned with business goals?
- **Context**: 80% of the value comes from ensuring stakeholder collaboration and translating insights into business improvements.

---

###### 3. **Monitoring & Performance Optimization**

- **Question**: How did Grafana dashboards help identify bottlenecks and improve API performance?
- **Context**: 80% of the value comes from tracking performance improvements efficiently.

---

###### 4. **Feature Adoption Tracking**

- **Question**: How did you track feature adoption using Grafana dashboards, and what insights did you derive?


____

```
Enhanced efficiency for 70+ operational stakeholders by improving real-time visibility with metrics for over 1 million monthly receipts. Achieved a approximately 90% reduction in resolution time by implementing in-mail alerts for critical 5xx errors, configured using Grafana.
```




```
Ensured adherence to 99.9% SLA for data availability during business hours, reduced retrieval times via resilient Data-Sync APIs developed in SpringBoot to consolidate scattered loan and EMI data for over 1M+ customers from Pennant and Snowflake into MongoDB.
```




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


```
Reduced deployment complexity and infrastructure costs by 25% by migrating the deployment architecture from Jenkins and Ansible to GitHub Actions, AWS CodeDeploy, and EC2.
```



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

