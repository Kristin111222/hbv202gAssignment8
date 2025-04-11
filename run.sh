#í vinnslu

#!/bin/bash

# Define the name of the fat JAR
JAR_NAME="your-project-1.0-SNAPSHOT-jar-with-dependencies.jar"

# Check if the fat JAR exists in the target directory
if [ -f "target/$JAR_NAME" ]; then
    echo "Running the application..."
    java -jar "target/$JAR_NAME"  # Run the fat JAR using Java
else
    echo "Error: Fat JAR not found. Please run ./build.sh to build the project first."
fi
