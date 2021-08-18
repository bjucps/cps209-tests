require-files src/report.md

check-javafx-submission || exit

run-program --test-category "Unit Tests" --test-message "Your tests run without error" gradle test

