run: build
	java -cp lib/postgresql-42.7.3.jar -cp lib/jedis-5.1.3.jar:bin src.Main

build:
	javac -d bin -cp lib/postgresql-42.7.3.jar -cp lib/jedis-5.1.3.jar  src/Main.java



.PHONY: build run
.SILENT: build run