Coding Exercise
===============

Readme
------


	export JAVA_HOME=/usr/lib/jvm/java-7-oracle
	$JAVA_HOME/bin/javac -sourcepath src src/com/egnyte/utils/auditreporter/Runner.java -d bin
	$JAVA_HOME/bin/java -cp bin com.egnyte.utils.auditreporter.Runner resources/users.csv resources/files.csv 

## Command Format

command format: 

`[OPTIONS] USERS_FILENAME RESOURCE_FILENAME`

Options :

`--top n` : print n-largest files sorted by size 

`-c `    : print the report in csv instead of plain text

Options `-c` & `--top n` can be in any order but before the file names.