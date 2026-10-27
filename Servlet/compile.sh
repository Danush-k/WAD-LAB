#!/bin/bash
# Script to compile Java servlets using Tomcat's servlet-api.jar

TOMCAT_LIB="${CATALINA_HOME:-$HOME/tomcat}/lib/servlet-api.jar"

if [ ! -f "$TOMCAT_LIB" ]; then
    echo "Error: servlet-api.jar not found at $TOMCAT_LIB"
    echo "Make sure CATALINA_HOME is set or Tomcat is installed at ~/tomcat"
    exit 1
fi

echo "Compiling HelloServlet.java..."
javac -cp "$TOMCAT_LIB" -d WEB-INF/classes WEB-INF/classes/HelloServlet.java

if [ $? -eq 0 ]; then
    echo "Compilation successful! Class files placed in WEB-INF/classes/"
else
    echo "Compilation failed."
fi
