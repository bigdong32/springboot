#基于jenkins镜像构建
FROM jenkins
#镜像创建者
MAINTAINER 384230490@qq.com

#指定用户
USER root
#变量
ARG maven_home=/var/local/maven
#安装maven环境
RUN mkdir ${maven_home}
RUN wget -P ${maven_home}  http://apache.fayea.com/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
RUN tar zxf ${maven_home}/apache-maven-3.3.9-bin.tar.gz -C /var/local/maven
RUN rm -rf ${maven_home}/apache-maven-3.3.9-bin.tar.gz
#设置maven环境变量
ENV M2_HOME ${maven_home}/apache-maven-3.3.9
ENV PATH $PATH:${M2_HOME}/bin



