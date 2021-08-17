cp -r $SUBMISSION_DIR/src/* $BASEDIR/javafx_project_template/src
cd $BASEDIR/javafx_project_template

require-files report.md
do-compile "gradle jar"

echo -e "\nAll tests complete."

