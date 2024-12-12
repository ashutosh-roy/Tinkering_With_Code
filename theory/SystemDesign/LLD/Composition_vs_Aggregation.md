Composition and aggregation are two types of relationships between classes in object-oriented programming. Both describe "has-a" relationships but differ in their degree of dependency and lifecycle control.

## **1. Composition**

- **Definition:** A strong "has-a" relationship where one class is completely dependent on another.
    
- **Dependency:** The lifecycle of the contained object (part) is tightly bound to the lifecycle of the containing object (whole). If the whole is destroyed, the parts are also destroyed.
    
- **Example:**
    
    ```
    class Engine {
        // Engine properties and methods
    }
    
    class Car {
        private Engine engine;
    
        public Car() {
            this.engine = new Engine(); // Engine is created and owned by Car
        }
    }
    ```
    
    In this example, `Car` _owns_ `Engine`. If the `Car` object is destroyed, its `Engine` object is also destroyed.
    
- **Key Characteristics:**
    
    - Strong ownership.
        
    - No shared ownership (the part cannot exist independently or belong to another whole).
        

---

## **2. Aggregation**

- **Definition:** A weaker "has-a" relationship where the part and whole have independent lifecycles.
    
- **Dependency:** The part can exist independently of the whole, and its lifecycle is not tied to the whole's lifecycle.
    
- **Example:**
    
    ```
    class Department {
        // Department properties and methods
    }
    
    class University {
        private List<Department> departments;
    
        public University(List<Department> departments) {
            this.departments = departments; // Departments are passed in and not created by University
        }
    }
    ```
    
    Here, `University` contains `Department` objects, but `Department` objects can exist independently or belong to another university.
    
- **Key Characteristics:**
    
    - Weak ownership.
        
    - Shared ownership is possible (the part can belong to multiple wholes or exist independently).
        

---

## **Key Differences**

|Feature|Composition|Aggregation|
|---|---|---|
|**Dependency**|Strong (part depends on whole)|Weak (part is independent of whole)|
|**Ownership**|Whole owns the part exclusively|Part may belong to multiple entities|
|**Lifecycle**|Part is destroyed with the whole|Part can outlive the whole|
|**Example**|Car and Engine|University and Department|

---

Use **composition** for tight coupling when the lifecycle of the parts should be strictly managed by the whole, and **aggregation** for loosely coupled designs where components can operate independently.