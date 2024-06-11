# JHTTP
project to build a http server


## Environment
1. make
2. java11
3. postgresql
4. redis
5. kafka

## Detail
- manage package with no mavel 
- here is some random test/demo code in src/Main.java
- worker is consumer for get message from kafka

## Some simple tuor
1. run simple java hello world first
2. make postgres server available in local (or in docker, but suggest in local)
3. run a simple query to test postgres case is ok
4. make redis server available in local
5. run a simple by putting kv into redis server 

## GUI tools
1. postgres: any gui is ok, or just use psql to check
2. redis: [another redis desktop](https://github.com/qishibo/AnotherRedisDesktopManager) )
3. kafka: [KafkaIDE](https://kafkaide.com/download/)

## Getting Started
1. make lib ( prepare packages )
2. make run ( but you have to manually comment/uncomment the right code)



## other tips: see make file to build and run