SET JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_221\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd "C:\Users\Fabian Martinez\OneDrive\Escritorio\Analizador-Sintactico-Compiladores\AnalizadorSintactico\src\codigo"
java -jar "C:\Users\Fabian Martinez\OneDrive\Escritorio\Analizador-Sintactico-Compiladores\lib\jflex-1.6.1.jar" Scanner.flex
pause
