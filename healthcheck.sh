#!/bin/sh
# Enviroment Variables
# HUB_HOST

wget -O jq https://github.com/stedolan/jq/releases/download/jq-1.6/jq-linux64
chmod +x ./jq
sudo apt -y install curl
sudo cp jq /usr/bin
jq --version
export REMOTE_IP=$HUB_HOST
#while [ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]
while true
do
  sleep 1
done

#start the maven command


#mvn clean verify -DdriverName=$BROWSER -DREMOTE_IP=$HUB_HOST