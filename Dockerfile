FROM tomcat:9.0.34-jdk11-openjdk
COPY target/goody-v1.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]