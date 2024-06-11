run: build
	java -cp lib/postgresql-42.7.3.jar -cp lib/jedis-5.1.3.jar:bin src.Main

build:
	javac -d bin -cp lib/postgresql-42.7.3.jar -cp lib/jedis-5.1.3.jar  src/Main.java

kafka-run: kafka-build
	java -cp lib/kafka-clients-3.2.0.jar:lib/slf4j-api-1.7.32.jar:lib/slf4j-simple-1.7.32.jar:bin src.Main
kafka-build:
	javac -d bin -cp lib/kafka-clients-3.2.0.jar:lib/slf4j-api-1.7.32.jar:lib/slf4j-simple-1.7.32.jar src/Main.java

worker-run: worker-build
	java -cp lib/kafka-clients-3.2.0.jar:lib/slf4j-api-1.7.32.jar:lib/slf4j-simple-1.7.32.jar:bin src.worker.Worker
worker-build:
	javac -d bin -cp lib/kafka-clients-3.2.0.jar:lib/slf4j-api-1.7.32.jar:lib/slf4j-simple-1.7.32.jar src/worker/Worker.java

lib:
	tar -xvf lib.tar

.PHONY: build run kafka-run kafka-build
.SILENT: build run kafka-run kafka-build