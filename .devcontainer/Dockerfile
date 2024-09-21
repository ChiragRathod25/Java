# Use a base image with Java (this example uses Java 17)
FROM mcr.microsoft.com/vscode/devcontainers/java:0-17

# Install icedtea-netx which includes appletviewer
RUN apt-get update && apt-get install -y icedtea-netx

# Set JAVA_HOME environment variable to point to the installed Java
ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
