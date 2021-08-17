export PS4='+(${BASH_SOURCE}:${LINENO}): ${FUNCNAME[0]:+${FUNCNAME[0]}(): }'

require-files report.md

cat >> $BASEDIR/gradle_project_template/build.gradle <<EOF
// Fail unit tests that do not complete within specified duration
test {
    timeout = Duration.ofMillis(6000)
    testLogging {
        events "passed", "failed"
    }
}
EOF

mv Guess.java $BASEDIR/gradle_project_template/src
mv GuessTest.java $BASEDIR/gradle_project_template/src

cd $BASEDIR/gradle_project_template

do-compile "gradle jar"

echo -e "\nExecuting your tests..."
run-program --test-category "Unit Tests" --test-message "Your tests run without error" gradle test

rm src/GuessTest.java
cp $TEST_DIR/MyGuessTest.java src

echo -e "\nExecuting official tests..."
run-program --test-category "Unit Tests" --test-message "Official tests run without error" gradle test

echo -e "\nAll tests complete."
