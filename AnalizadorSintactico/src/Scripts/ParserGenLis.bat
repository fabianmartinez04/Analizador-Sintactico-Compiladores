SET JAVA_HOME = "C:\Program Files\Java\jdk1.8.0_202\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd "C:\Users\liset\OneDrive\Documentos\Ingenieria en Computacion\Computacion V Semestre\Compiladores e interpretes\Proyectos\Parser\AnalizadorSintactico\src\codigo"
java -jar "C:\Users\liset\OneDrive\Documentos\Ingenieria en Computacion\Computacion V Semestre\Compiladores e interpretes\Proyectos\Parser\lib\java-cup-11b.jar" -parser Parser -symbols Sym Parser.cup
pause