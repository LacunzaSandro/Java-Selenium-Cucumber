# Ubuntu latest
# Oracle Java 1.8.0_101 64 bit
# Maven 3.3.9

FROM ubuntu:latest

MAINTAINER Kai Winter (https://github.com/kaiwinter)

# this is a non-interactive automated build - avoid some warning messages
ENV DEBIAN_FRONTEND noninteractive

# update dpkg repositories
RUN apt-get update
RUN apt-get upgrade
# install wget
RUN apt-get install -y wget

# get maven 3.3.9
RUN wget --no-verbose -O /tmp/apache-maven-3.3.9.tar.gz http://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz

# verify checksum
RUN echo "516923b3955b6035ba6b0a5b031fbd8b /tmp/apache-maven-3.3.9.tar.gz" | md5sum -c

# install maven
RUN tar xzf /tmp/apache-maven-3.3.9.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.3.9 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.3.9.tar.gz
ENV MAVEN_HOME /opt/maven

# remove download archive files
RUN apt-get clean


#install and update dependency
RUN apt-get -y install sudo libx11-6 libnss3 libglib2.0-0
RUN apt-get update && apt-get install -yq && apt-get upgrade
RUN sudo apt install wget

#set shell variable for chrome installation
ENV chrome_version 105.0.5195.52
RUN wget --no-verbose -O /tmp/chrome.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb \
  && apt install -y /tmp/chrome.deb \
  && rm /tmp/chrome.deb
RUN sudo apt-get install -f


# set shell variables for java installation
ENV java_version 1.8.0_131
ENV filename jdk-8u131-linux-x64.tar.gz
ENV downloadlink http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/$filename

# download java, accepting the license agreement
#RUN wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" -O /tmp/$filename $downloadlink
RUN  wget -c --header "Cookie: oraclelicense=accept-securebackup-cookie" -O /tmp/$filename $downloadlink

# unpack java
RUN mkdir /opt/java-oracle && tar -zxf /tmp/$filename -C /opt/java-oracle/
ENV JAVA_HOME /opt/java-oracle/jdk$java_version
ENV PATH $JAVA_HOME/bin:$PATH

# configure symbolic links for the java and javac executables
RUN update-alternatives --install /usr/bin/java java $JAVA_HOME/bin/java 20000 && update-alternatives --install /usr/bin/javac javac $JAVA_HOME/bin/javac 20000


#move into the container our project and install dependecy
COPY pom.xml /app/
COPY src /app/src/
COPY healthcheck.sh /app/
COPY .m2 /usr/share/maven/ref/repository
WORKDIR /app/
RUN mvn install -DskipTests

#to be sure it works
RUN apt -y update; apt -y upgrade; apt -y dist-upgrade
RUN apt --fix-broken install

CMD ["/app/healthcheck.sh"]