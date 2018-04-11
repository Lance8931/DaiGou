echo type your comment for this commit
set /p comment=
echo type your password for svn
set /p pwd=
E:
cd DaiGou
call mvn clean compile package -Dmaven.test.skip=true
cd target
HaoZipC x ljh-0.0.1-SNAPSHOT.war -oE:\DaiGou\target\api
xcopy api\META-INF E:\daigou-web\META-INF\ /e /y /s
xcopy api\WEB-INF E:\daigou-web\WEB-INF\ /e /y /s
xcopy api\org E:\daigou-web\org /e /y /s
cd ..
cd ..
cd ..
cd ..
cd daigou-web
svn add . --no-ignore --force
svn commit -m '%commet%' --username lijinhuan --password %pwd% --no-auth-cache
pause
