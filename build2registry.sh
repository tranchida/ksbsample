#!/bin/bash

mvn clean compile jib:build

# Apply your kustomize configuration
kubectl apply -k kustomize/overlay/dev/