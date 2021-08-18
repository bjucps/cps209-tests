
require-src-folder
require-files src/report.pdf

copy-gradle-buildfiles

cat >> build.gradle <<EOF
// Fail unit tests that do not complete within specified duration
test {
    timeout = Duration.ofMillis(6000)
    testLogging {
        events "passed", "failed"
    }
}
EOF

do-compile gradle install || exit 

echo -e "\nExecuting your tests..."
run-program --test-category "Unit Tests" --test-message "Your tests run without error" gradle test

run-program --test-category "Command Line Tests" --test-message "Test 1 Doesn't Crash" \
    --timeout 3 build/install/app/bin/app --shields 7 --warp 5.2 --cloak --crew kirk,uhura,mccoy 

run-program --test-category "Command Line Tests" --test-message "Test 2 Doesn't Crash" \
    --timeout 3 build/install/app/bin/app --foo --crew kirk,uhura,mccoy

rm src/*Test.java
cp $TEST_DIR/OfficialStarshipTest.java src

echo -e "\nExecuting official tests..."
do-compile --test-message "Compiles with Official Test" gradle clean jar || exit
run-program --test-category "Unit Tests" --test-message "Official tests run without error" gradle test

