echo "Cleaning and building the project..."

mvn clean compile package

echo "Build complete. Check target/ for the fat jar file."
