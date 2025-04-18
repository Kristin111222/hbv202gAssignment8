JAR_NAME="your-project-1.0-SNAPSHOT-jar-with-dependencies.jar"

if [ -f "target/$JAR_NAME" ]; then
    echo "Running the application..."
    java -jar "target/$JAR_NAME"  
else
    echo "Error: Fat JAR not found. Please run ./build.sh to build the project first."
fi
