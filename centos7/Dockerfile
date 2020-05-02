FROM centos:centos7
MAINTAINER 04637 04637@163.com

ENV container docker
#RUN yum -y update; yum clean all
RUN yum -y install systemd; yum clean all; \
(cd /lib/systemd/system/sysinit.target.wants/; for i in *; do [ $i == systemd-tmpfiles-setup.service ] || rm -f $i; done); \
rm -f /lib/systemd/system/multi-user.target.wants/*;\
rm -f /etc/systemd/system/*.wants/*;\
rm -f /lib/systemd/system/local-fs.target.wants/*; \
rm -f /lib/systemd/system/sockets.target.wants/*udev*; \
rm -f /lib/systemd/system/sockets.target.wants/*initctl*; \
rm -f /lib/systemd/system/basic.target.wants/*;\
rm -f /lib/systemd/system/anaconda.target.wants/*;
VOLUME [ "/sys/fs/cgroup" ]
ENTRYPOINT ["/usr/sbin/init"]

# 将tomcat和jdk复制进镜像
RUN mkdir -p /home/pack
WORKDIR /home/pack
ENV MYSQL_PASSWORD mysql_ff24


# 安装jdk
COPY jdk-11.0.6_linux-x64_bin.tar.gz ./
RUN mkdir -p /usr/local/jdk-11
RUN tar -zxvf jdk-11.0.6_linux-x64_bin.tar.gz -C /usr/local/jdk-11 --strip-components 1
ENV JAVA_HOME /usr/local/jdk-11
ENV PATH $PATH:$JAVA_HOME/bin

# 安装tomcat
COPY apache-tomcat-9.0.34.tar.gz ./
RUN mkdir -p /usr/local/tomcat-9
RUN tar -zxvf apache-tomcat-9.0.34.tar.gz -C /usr/local/tomcat-9 --strip-components 1
ENV TOMCAT_HOME /usr/local/tomcat-9
ENV PATH $PATH:$TOMCAT_HOME/bin
EXPOSE 8080

# 安装mysql
#COPY mysql-8.0.20-1.el7.x86_64.rpm-bundle.tar ./
#RUN mkdir -p /usr/local/mysql-8
#RUN mkdir ./mysql_bundle
#RUN tar -xvf mysql-8.0.20-1.el7.x86_64.rpm-bundle.tar -C ./mysql_bundle
COPY mysql80-community-release-el7-3.noarch.rpm ./
RUN rpm -Uvh mysql80-community-release-el7-3.noarch.rpm
RUN yum install mysql-community-server -y
#提取临时密码
RUN tmp_pwd=`grep 'temporary password' /var/log/mysqld.log | sed 's/.*is generated for root@localhost: \(.*\)/\1/g'`
ENV TMP_PWD tmp_pwd
#登录
#RUN mysql -uroot -p$tmp_pwd
#RUN alter user 'root'@'localhost' IDENTIFIED BY $MYSQL_PASSWORD
#RUN create user 'root'@'%' IDENTIFIED BY $MYSQL_PASSOWRD
#RUN grant all privileges on *.* to 'root'@'%';
#RUN quit
EXPOSE 3306

# 安装应用
COPY goody-v1.war /usr/local/tomcat-9/webapps/
CMD ["/usr/local/tomcat-9/bin/startup.sh"]

# build & run
#docker build -t centos7-unit3 .
#&& docker run
#-p 0.0.0.0:13306:3306 -p 0.0.0.0:18080:8080
#-v /tmp/mysql/data:/var/lib/mysql
#--name centos7-unit-test3
#--privileged
#centos7-unit3