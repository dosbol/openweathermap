.PHONY: build test run run-5 write-to-file

build:	
	lein deps
	lein uberjar

test:
	lein test

run:
	java -jar target/uberjar/openweathermap-0.1.0-SNAPSHOT-standalone.jar

run-5:
	java -jar target/uberjar/openweathermap-0.1.0-SNAPSHOT-standalone.jar -l 5

write-to-file:
	java -jar target/uberjar/openweathermap-0.1.0-SNAPSHOT-standalone.jar > output.csv
