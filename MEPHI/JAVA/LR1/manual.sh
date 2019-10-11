#!/bin/bash
cd build
cd com
cd company
javac -cp ../../../lib/commons-io.jar:../../../lib/commons-codec.jar *.java
cd ..
cd ..
jar cvfm Main.jar ../MANIFEST.MD com/company/Main.class com/company/Simple.class com/company/Interactive.class
