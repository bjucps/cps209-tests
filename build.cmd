docker build -f Docker/Dockerfile -t bjucps/cps209-test .

rem gather files needed
docker run -it --rm -v c:\temp:/host bjucps/cps209-test tar zcf /host/files.tar.gz -C /tmp .gradle  
