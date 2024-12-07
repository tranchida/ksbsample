install 
 - minikube
 - kubectl
 - helm

minikube start
minikube addons enable ingress

add 
    192.168.49.2    ksbsample.test 
in /etc/hosts

from helm/esbk run
    helm install sample .

test with
    curl http://ksbsample.test/say/hello