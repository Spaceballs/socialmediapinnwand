cd build\classes
java -classpath .;..\..\mysql-connector-java-3.1.8-bin.jar;%CLASSPATH% -Djava.security.policy=SimplePolicy.txt -Djava.rmi.server.codebase="file:///D:/thies/Lehre/IT3/BankProjekt/build/classes/" de.hdm.thies.bankProjekt.BankServer
pause
