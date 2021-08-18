require-files src/report.md

check-javafx-submission

exit-if-must-pass-tests-failed

run-program --test-category "Unit Tests" --test-message "Your tests run without error" gradle test

echo -e "\nAll tests complete."

