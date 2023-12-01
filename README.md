#redis-app
Demo app to demonstrate redis usage as storage and cache

Used technologies: 
1. Spring Boot, 
2. Java 17,
3. Maven,
4. Redis, 
5. Docker,
6. Kubernetes,
7. minikube

---

#Docker Compose
**Note: set `host: redis` in application.yaml**

###To start the container:

`docker-compose up`

###To rebuild the image 
`docker-compose build`

###To stop the container:
`docker-compose down`

###To connect via redis-cli:
`redis-cli -h 127.0.0.1 -p 6379`

###To get all keys:
`KEYS *`

**Example:**
```
1) "token:8d83a8a3-ede6-4d56-8e08-92788b4197c2"
2) "token"
3) "token:8d83a8a3-ede6-4d56-8e08-92788b4197c1"
4) "token:8d83a8a3-ede6-4d56-8e08-92788b4197c3"
```

###To get object by key:
`HGETALL token:8d83a8a3-ede6-4d56-8e08-92788b4197c3`
```
1) "_class"
2) "com.example.redis.model.Token"
3) "expiration"
4) "10000"
5) "id"
6) "8d83a8a3-ede6-4d56-8e08-92788b4197c3"
7) "info"
8) "TRAUaM"
```

###To run redis server on terminal:
`redis-server & (& to open ttl)`

###To run redis-cli on terminal:
`redis-cli -h 127.0.0.1 -p 6379`

###To stop redis server via redis-cli:
`SHUTDOWN NOSAVE`

---
#Kubernetes, minikube

**Note: set `host: ${REDIS_HOST:localhost}` in application.yaml**

###To start minikube with docker driver
`minikube start --driver=docker`

###To start deployment (app + redis)
`kubectl apply -f=deployment.yaml`

###To start service
`kubectl apply -f=service.yaml`

###To expose service
`minikube service redis-app-service`

Note: use generated IPs

###Try APIs from PromiseController and TokenController

###To get deployments
`kubectl get deployments`

###To get pods
`kubectl get pods`

###To get services
`kubectl get services`

###To get pod's logs
`kubectl logs <pod_name>`

###To delete deployment
`kubectl delete deployment redis-app-deployment`

###To delete service
`kubectl delete service redis-app-service`

###To stop minikube
`minikube stop`

