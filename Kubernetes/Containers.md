##### Why do we need them?

###### "It Works on My Machine!"

**Scenario:**

You finish coding a feature on your **laptop** and push it to Git. Your teammate pulls the code, runs it on their system, and… 💥 **It crashes!** They have a different Java version, missing dependencies, or conflicting environment variables.

**With Containers:**

Think of a container as a **pre-configured VS Code workspace with all extensions, linters, compilers, and libraries** already set up. You and your teammate both use **this identical setup**, so your code runs the same **on any machine**—your laptop, their laptop, a CI/CD pipeline, or production.

---

###### Lightweight & Fast – Virtual Machines vs. Containers

**Scenario:**

You need to run a local **PostgreSQL database** for your project. Without containers, you:

1. **Install PostgreSQL manually** on your system.
2. Configure ports, set environment variables, and tweak settings.
3. Your local database **conflicts** with another project that needs a different version.

**With Containers:**

Instead of installing PostgreSQL globally, you **run a Docker container**:

`docker run -d -p 5432:5432 postgres:15`

Now you have a **fully functional database in seconds**—no setup hassle, no conflicts! When you're done, just **delete the container**, and your system stays clean.

**💡 Think of this like running a VS Code Dev Container, where each project gets its own isolated setup, without affecting others.




##### What are they ?

Containers are completely isolated environments, as in they can have their own processes or services, their own network interfaces, their own mounts, just like Virtual machines, except that they all share the **same OS kernel**.
![[Pasted image 20250214123727.png]]

![[Pasted image 20250214160205.png]]
