#!/bin/bash

# Source the minikube docker environment
eval $(minikube docker-env)

# Now you can run your docker commands here
# For example:
mvn clean compile jib:dockerBuild

# Apply your kustomize configuration
kubectl apply -k kustomize/overlay/dev/