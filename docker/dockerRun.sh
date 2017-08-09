#!/bin/bash

imageName=myspringboot/test
tagNum=v1
image=$imageName":"$tagNum

projectPos=/var/local/jekinsRelease/
containerId=`docker ps -a |grep $imageName |awk '{print $1}'`
imageId=`docker images |grep -i $imageName |awk '{print $3}'`

if [ -n "$containerId" ];then
  docker stop $containerId && docker rm -f $containerId
fi
if [ -n "$imageId" ];then
 docker rmi -f $imageId
fi

cd $projectPos

echo docker build is start
docker build -t $image .
echo docker build is end

sleep 10s

docker run -d -p 8081:8081 $image
imageId=`docker images |grep -i $imageName |awk '{print $3}'`
echo "docker run is start,imageId:"$imageId
