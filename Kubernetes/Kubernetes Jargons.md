
Here are concise flashcards for **Kubernetes jargons**:
### 1. **Cluster**

**Definition:** A set of machines (nodes) running containerized applications managed by Kubernetes which helps run Control Plane node and worker nodes combined.

### 2. **Node**

**Definition:** A machine in the cluster (physical or virtual), either a **worker** or **control plane** node.  

Worker nodes run the applications; control plane nodes manage the cluster.

---

### 3. **Pod**

**Definition:** The smallest deployable unit in Kubernetes, usually running one or more containers.  
**Use:** Pods host your application containers.

---

### 4. **Deployment**

**Definition:** A resource that manages the desired state of an application, like replicas and updates.  
**Use:** Ensures the correct number of pod replicas are running.

---

### 5. **Service**

**Definition:** Exposes a set of pods as a network service.  
**Use:** Load balances traffic to pods.

---

### 6. **Ingress**

**Definition:** Manages external access to services, usually HTTP/HTTPS.  
**Use:** Routes external traffic to services inside the cluster.

---

### 7. **ConfigMap**

**Definition:** Stores configuration data as key-value pairs.  
**Use:** Externalize application configurations.

---

### 8. **Secret**

**Definition:** Stores sensitive information like passwords or API keys.  
**Use:** Securely manage sensitive data.

---

### 9. **Namespace**

**Definition:** A logical partition within the cluster.  
**Use:** Isolates resources (e.g., `dev`, `prod`).

---

### 10. **Volume**

**Definition:** Persistent storage for pods.  
**Use:** Used to store application data or logs.

---

### 11. **ReplicaSet**

**Definition:** 
* Ensures a specified number of pod replicas are running.  
* Scope is not just limited to one NODE. It can maintain replicas across multiple NODEs inside constructor.

---

### 12. **Kubelet**

**Definition:** 
* An agent that runs on each node and ensures containers are running.  
* Monitors the health and lifecycle of containers on a node.

---

### 13. **Kubectl**

**Definition:** Command-line tool to interact with the Kubernetes API server.  
**Use:** Manage and inspect cluster resources.

---

### 14. **Horizontal Pod Autoscaler (HPA)**

**Definition:** Automatically scales pods based on metrics like CPU/memory usage.  
**Use:** Adjusts the number of pods during traffic spikes.

---

### 15. **ClusterIP, NodePort, LoadBalancer**

**Definition:** Service types for exposing applications:

- **ClusterIP:** Internal access.
- **NodePort:** Exposes a port on all nodes.
- **LoadBalancer:** Creates an external load balancer.  
  **Use:** Choose appropriate access strategy for your service.