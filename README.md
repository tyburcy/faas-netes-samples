Instalacja przeprowadzana na  maszynie virtualnej z ubuntu (pojawily sie problemy) oraz  na czystym ubuntu

# 1. instalacja potrzebnych elementów
## 1.1 instalacja minikube

    $ curl -Lo minikube https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64  
    $ chmod +x minikube  
    $ sudo mv minikube /usr/local/bin/

## 1.2 instalacja kubectl
    $ curl -Lo kubectl https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl
    $ chmod +x ./kubectl 
    $ sudo mv ./kubectl /usr/local/bin/kubectl
    
## 1.3 instalacja virtualboxa
    $ sudo apt install virtualbox virtualbox-ext-pack


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





