
require-files Grader.java Guess.java report.md

do-compile --test-message "Grader compiles" --expect-exe Grader.class javac Grader.java 
do-compile --test-message "Guess compiles" --expect-exe Guess.class javac Guess.java

run-program --test-category "Guess" --test-message "Guess executes with no errors" --max-lines 30 --timeout 3 java Guess <<EOF
1
2
3
4
5
6
7
8
9
10
EOF

# 
# Test Grader
#

cat >expected.log <<EOF
75
67
40
33
EOF

diff_cmd="diff __output.log expected.log"

run-program --test-category "Grader" --test-message "Correctness Test" \
  --max-lines 30 --timeout 3 --expected expected.log \
  --diff-cmd "diff __output.log expected.log" \
  java Grader <<EOF
4
73
67
38
33
EOF

