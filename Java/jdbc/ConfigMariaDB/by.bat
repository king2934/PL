javac -encoding utf8 ConfigMariaDB.java Config.java UtilDB.java
jar cvfm CMariaDB.jar META-INF/MANIFEST.MF ./
java -jar CMariaDB.jar