SET JAVA_HOME = "C:\Program Files\Java\jre1.8.0_271\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd "D:\Desktop\CI\Proyectos\Etapa 2\Analizador-Sintactico-Compiladores\AnalizadorSintactico\src\codigo"
java -jar "D:\Desktop\CI\Proyectos\Etapa 2\Analizador-Sintactico-Compiladores\lib\jflex-1.6.1.jar" Scanner.flex
pause
