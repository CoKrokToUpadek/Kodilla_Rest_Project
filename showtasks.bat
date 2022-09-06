CALL runcrud
if "%ERRORLEVEL%" == "0" goto success
echo.
echo wizard could  cast a spell to make this script work
got fail

:success
start C:\Users\cokro\AppData\Local\Programs\Opera\opera.exe http://localhost:8080/crud/v1/tasks
echo.
echo wizards job is done here.



:fail
echo.
echo wizard was interrupted.