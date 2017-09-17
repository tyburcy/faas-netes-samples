Instalacja przeprowadzana na  maszynie virtualnej z ubuntu (pojawily sie problemy) oraz  na czystym ubuntu

# 1. instalacja potrzebnych elementów
## 1.1 instalacja minikube https://github.com/kubernetes/minikube

    $ curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64  
    $ chmod +x minikube  
    $ sudo mv minikube /usr/local/bin/

## 1.2 instalacja kubectl https://kubernetes.io/docs/tasks/tools/install-kubectl/
    $ curl -Lo kubectl https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
    $ chmod +x ./kubectl 
    $ sudo mv ./kubectl /usr/local/bin/kubectl
    
## 1.3 instalacja virtualboxa
    $ sudo apt install virtualbox virtualbox-ext-pack

## 1.4 instalacja qemu-kvm (opcjonalne)
    # Install libvirt and qemu-kvm on your system, e.g.
    $ sudo apt install libvirt-bin qemu-kvm
    $ sudo usermod -a -G libvirtd $(whoami)
    $ newgrp libvirtd
    
## instalacja dockera ubuntu ma inna wersje - nie wiem czy potrzebne  (opcjonalne)
    sudo apt-get update && sudo apt-get install -qy docker.io


# 2. Podstawowe Komendy

## 2.1 uruchomienie minikube
uruchamienie domysle z virtualboxem
    
    $ minikube start
    
    
uruchomie bez maszyny virtualnej
     
     $ minikube start --vm-driver=none
     
     
dodatkowe opcje

    virtualbox
    vmwarefusion
    KVM
    xhyve
    Hyper-V
    none - (LINUX ONLY) - the 'none' driver can be used to run the kubernetes cluster components on the host instead of in a VM. This can be useful for CI workloads which do not support nested virtualization.


## 2.2 

    $ kubectl config use-context minikube
    
## 2.3 odpalenie dasborda
    $ minikube dashboard

## 2.4 zatrzymanie minikube
    $ minikube stop

## 2.5 dodatkowe komendy

    minikube ssh - if you want to check that everything worked then you can shell into the minikube vm.
    minikube stop - you should shut down the cluster before shutting down your Mac
    minikube status - gives key status information
    minikube ip - gives the IP address of your cluster

# 3. Przygotowanie faas-netes
    $ git clone https://github.com/alexellis/faas-netes
    
## 4 Uruchamianie wszystkiego
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






