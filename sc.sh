git add .
DAYOFWEEK=$(date +%A)
MONTH=$(date +%B)
DAYOFMONTH=$(date +%d)
YEAR=$(date +%Y)
branch=$(git branch | sed -n -e 's/^\* \(.*\)/\1/p')
message=$1
COMMIT_MESSAGE="${branch} ${DAYOFWEEK} ${MONTH} ${DAYOFMONTH} ${YEAR} ${message}"
echo ${COMMIT_MESSAGE}
git commit -m "${COMMIT_MESSAGE}"