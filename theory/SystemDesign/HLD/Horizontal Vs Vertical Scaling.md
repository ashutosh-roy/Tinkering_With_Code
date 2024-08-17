```
Imagine a scenario where you have to written some piece of code and you want to host it somewhere. 
For that you would need a machine on cloud which exposes that piece of code to the internet


```

### Horizontal Scaling

Increasing the number of servers of to deal with incoming user traffic

#### Advantages

- Resilient. No single point of failure. If one system fails, another system exists as a backup.
- This scales well as in case of more traffic we can simply add new servers

#### Disadvantages

- Load balancing becomes an overhead. Managing the logic of how and where to send the traffic correctly.
- It handles requests in remote procedure calls (which is network calls) which is slow.
- Data inconsistency since there are a lot of servers

### Vertical Scaling

Increasing the size of the same server to deal with incoming user traffic

#### Advantages

- Data Consistency coz only one place to update the data in.
- Load balancing is not required
- It handles requests with inter process communication (i.e., internal threads inside the system)

#### Disadvantages

- Single Point of failure
- There's a hardware limit so in case of a larger incoming traffic this is not scalable.