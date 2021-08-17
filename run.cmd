if "%1" == "" goto none
goto continue

:none
echo Usage: run asmtcode [ -d ]
goto done

:continue

if "%2" == "-d" goto debug
docker run -it --rm -v %cd%:/submission_src -v %~dp0:/tests  bjucps/cps209-test bash tests/rundocker.sh %1
goto done

:debug
docker run -it --rm -v %cd%:/submission_src -v %~dp0:/tests -e "DEBUG=1" bjucps/cps209-test bash -x tests/rundocker.sh %1

:done