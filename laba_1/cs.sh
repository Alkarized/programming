javac18 -g Laba1.java
echo "Main-Class: Laba1" > fest.mf
jar cvmf fest.mf Laba1.jar Laba1.class
java18 -jar Laba1.jar