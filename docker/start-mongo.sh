#!/bin/bash
sudo service docker start
sudo docker run --name mongo -d -p 27017:27017 mongo
