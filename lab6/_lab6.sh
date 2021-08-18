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

do-compile gradle jar
