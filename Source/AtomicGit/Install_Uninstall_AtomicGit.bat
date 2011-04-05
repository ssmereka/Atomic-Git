@echo off

:menu
echo WELCOME TO CHROME ...OR COCK!
echo.

echo 1) Install
echo 2) Uninstall
echo.

set /p option=">>"
if /i %option% equ 1 (goto install) else (goto uninstall)
goto exit


:install
xcopy "%~dp0\batch" "%HOMEDRIVE%\batch\" /E
xcopy "%~dp0\Shortcuts" "%HOMEDRIVE%%HOMEPATH%\Desktop\AtomicGit\" /E
goto exit

:uninstall
RMDIR /S /Q "%HOMEDRIVE%\batch\"
RMDIR /S /Q "%HOMEDRIVE%%HOMEPATH%\Desktop\AtomicGit\"


:exit