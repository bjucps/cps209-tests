
require-src-folder
require-files src/report.pdf

copy-gradle-buildfiles

do-compile gradle install || exit 

cp $TEST_DIR/ice.png .

run-program --test-category "Command Line Tests" --test-message "Test with ice.png" --timeout 3 build/install/app/bin/app ice.png

