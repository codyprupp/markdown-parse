test: MarkdownParse.java
	javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java MarkdownParse.java
	java -cp ".;libs\junit-4.12.jar;libs\hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
	scp WhereAmI.java cs15lwi22zz@ieng6.ucsd.edu:~/
