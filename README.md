

# 1. Przygotowanie faas-netes
    $ git clone https://github.com/alexellis/faas-netes
    
 Uruchamianie wszystkiego

    $ minikube start

    $ kubectl config use-context minikube

    $ cd faas-netes

    $ kubectl apply -f ./faas.yml,monitoring.yml,rbac.yml

    
powinsmy uzyskac informacje o uruchominych  serwisach
> service "faas-netesd" created

> serviceaccount "faas-controller" created

> deployment "faas-netesd" created

> service "gateway" created

> deployment "gateway" created

> service "prometheus" created

> deployment "prometheus" created

> service "alertmanager" created

> deployment "alertmanager" created

> clusterrole "faas-controller" created

> clusterrolebinding "faas-controller" created

następnie sciagamy

$ git clone https://github.com/tyburcy/faas-netes-samples.git


# 2.Przykład z java

    cd javahello/

    eval $(minikube docker-env)   -przechodzimy na dockera z minikuba

    docker build -t hello-java:v1 .   -tworzymy obraz
    
    kubectl run --labels="faas_function=f-hello-java" f-hello-java --port 8080 --image hello-java:v1


    kubectl expose deployment/f-hello-java


nastepnie mozemy przetestowac z adresow

open http://$(minikube ip):31112/

oraz Prometheus $ open http://$(minikube ip):31119/

lub z lini komend - zalecane :)

curl -s --data "dodatkowe dane" http://$(minikube ip):31112/function/f-hello-java







