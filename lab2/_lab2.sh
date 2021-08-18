export PS4='+(${BASH_SOURCE}:${LINENO}): ${FUNCNAME[0]:+${FUNCNAME[0]}(): }'

require-src-folder
require-files src/report.md

exit-if-must-pass-tests-failed

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

do-compile "gradle jar"

exit-if-must-pass-tests-failed

echo -e "\nExecuting your tests..."
run-program --test-category "Unit Tests" --test-message "Your tests run without error" gradle test

rm src/GuessTest.java
cp $TEST_DIR/MyGuessTest.java src

echo -e "\nExecuting official tests..."
run-program --test-category "Unit Tests" --test-message "Official tests run without error" gradle test

echo -e "\nAll tests complete."
