
require-src-folder
require-files src/report.md

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

do-compile gradle jar || exit

echo -e "\nExecuting your tests..."
run-program --test-category "Unit Tests" --test-message "Your tests run without error" gradle test

cp $TEST_DIR/Lab8Test.java src

echo -e "\nExecuting official tests..."
run-program --test-category "Unit Tests" --test-message "Official tests run without error" gradle test
