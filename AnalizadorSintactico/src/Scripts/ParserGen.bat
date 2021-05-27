SET JAVA_HOME = "C:\Program Files\Java\jre1.8.0_271\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd "D:\Desktop\CI\Proyectos\Etapa 2\Analizador-Sintactico-Compiladores\AnalizadorSintactico\src\codigo"
java -jar "D:\Desktop\CI\Proyectos\Etapa 2\Analizador-Sintactico-Compiladores\lib\java-cup-11b.jar" -parser Parser -symbols Sym Parser.cup
pause