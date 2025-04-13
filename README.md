vica-score-calculator Service

Build the Jar file:

```mvn clean package```

Checkstyle analysis (Settings come from cargarantie-build-tools):

```mvn checkstyle:checkstyle```

Create Docker Container:

Preconditions:

* Docker is installed and configured properly
* Access to CG own Docker Hub

As first one need to build the Jar file, otherwise building the Dicker Image will fail.
Execute the following command afterward:

    docker build -t  cgag/vica-score-calculator:VERSION .
