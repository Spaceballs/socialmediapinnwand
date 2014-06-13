REM Auf diese Weise wurden vor Java 5 Stubs & Skeletons erstellt
REM Seit Java 5 wir erfolgt dies automatisch.
C:\Programme\Java\jdk1.6.0_03\bin\rmic.exe -verbose -classpath .\build\classes\ -d .\build\classes de.hdm.thies.bankProjekt.data.AccountImpl de.hdm.thies.bankProjekt.data.BankImpl de.hdm.thies.bankProjekt.data.CustomerImpl de.hdm.thies.bankProjekt.BankVerwaltungImpl de.hdm.thies.rmidemo.CalculatorImpl
pause
