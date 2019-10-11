Java Lab1
------------

Write a console program that generates a hash value (md5 and sha256) for the text files.
In interactive mode the program should not exist until the user does not want this.
In simple mode the user can specify paths to the files which hash.

HOW TO INSTALL
------------
Download .java files
1. Main.java
2. Interactive.java
3. Simple.java

And please install libs: 
1. commons-codec-1.8.jar
2. org.apache.commons.io.jar

HOW TO COMPILE
------------
cd build

cd com

cd company

javac -cp ../../../lib/commons-io.jar:../../../lib/commons-codec.jar *.java

cd ..

cd ..

jar cvfm Main.jar ../MANIFEST.MD com/company/Main.class com/company/Simple.class com/company/Interactive.class

or 

bash manual.sh

HOW TO USE
------------
Write in terminal, if you want to run interactive mode:

java -jar Main.jar -i

And this command, if you want to run manual mode (flag -md5 or -sha256)

java -jar Main.jar -md5 -f test.txt 

my contacts
------------
You can connect with me by email: 
cheraten@yandex.ru
