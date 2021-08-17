FROM ubuntu:20.04 
RUN apt-get update && apt-get install -y curl unzip \
    && apt-get clean

RUN curl --insecure https://cdn.azul.com/zulu/bin/zulu16.32.15-ca-jdk16.0.2-linux_x64.tar.gz --output zulu.tgz --silent && \
    tar zxf zulu.tgz && \
    rm zulu.tgz && \
    ln -s /zulu16.32.15-ca-jdk16.0.2-linux_x64/bin/java /usr/bin && \
    ln -s /zulu16.32.15-ca-jdk16.0.2-linux_x64/bin/javac /usr/bin

RUN curl --insecure https://downloads.gradle-dn.com/distributions/gradle-7.1-bin.zip --output gradle.zip --silent && \
    unzip -q gradle.zip && rm gradle.zip

ENV PATH="/gradle-7.1/bin:${PATH}"
ENV GRADLE_USER_HOME="/tmp/.gradle"

COPY Docker/setup.sh .
COPY gradle_project_template /gradle_project_template/
COPY javafx_project_template /javafx_project_template/
RUN bash -v setup.sh
